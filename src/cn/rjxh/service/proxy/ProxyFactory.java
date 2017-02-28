package cn.rjxh.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

import cn.rjxh.dao.support.DBConnection;

public class ProxyFactory{	
	@SuppressWarnings("unchecked")
	public static <T> T getProxy(final T bean){		
		return (T)Proxy.newProxyInstance(bean.getClass().getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler(){
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
				Connection conn = DBConnection.getConnection();
				/** 默认不开启事务*/
				boolean isAutoCommit = true;
				try{
					/** 调用serviceImpl的setConnection方法 */
					bean.getClass().getMethod("setConnection", Connection.class).invoke(bean, conn);
					/** 获取serviceImpl中正在调用的方法，比如getUser() */
					/** m = public java.util.List cn.rjxh.service.impl.RxServiceImpl.getUser() */
					Method m = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
					/** 若getUser()方法上面有注解，则返回true */
					if (m.isAnnotationPresent(Transcation.class)){
						/** 读出getUser()方法上的注解 */
						/** t = @cn.rjxh.service.proxy.Transcation(readOnly=false) */
						Transcation t = m.getAnnotation(Transcation.class);
						/** 读出@Transcation(readOnly=true|false)的值 */
						isAutoCommit = t.readOnly();
					}
					/** 若为false，则不会自动提交，必须使用conn.commit()方法，手动提交事务 */
					/** 所以说，设置true时，不用commit()方法，他会自动提交，不影响执行！ */
					conn.setAutoCommit(isAutoCommit);
					/** getUser()方法执行 */
					Object obj =  method.invoke(bean, args);
					/** 开启事务则提交 */
					if(!isAutoCommit){
						conn.commit();
					}
					return obj;
				}
				catch(Throwable ex){
					/** 若开始事务，出错则回滚 */
					if (!isAutoCommit) conn.rollback();
					throw new Throwable(ex);
				}
				finally{
					/** 最后，关闭连接 */
					DBConnection.close(conn);
				}
			}
		});
	}
}
