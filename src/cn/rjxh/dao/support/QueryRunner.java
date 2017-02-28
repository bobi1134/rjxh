package cn.rjxh.dao.support;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.rjxh.utils.page.PageModel;

public class QueryRunner{
	/**
	 * 通用查询方法
	 * @param conn
	 * @param sql
	 * @param params
	 * @param handler
	 * @return
	 * @throws SQLException
	 */
	public <T> T query(Connection conn, String sql, Object[] params, ResultSetHandler<T> handler) 
			throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (params != null && params.length > 0){
			for (int i = 0; i < params.length; i++){
				pstmt.setObject(i + 1, params[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		return handler.execute(rs);
	}
	
	/**
	 * 通用 的CUD方法
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection conn, String sql, Object[] params) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if (params != null && params.length > 0){
			for (int i = 0; i < params.length; i++){
				pstmt.setObject(i + 1, params[i]);
			}
		}
		return pstmt.executeUpdate();
	}
	
	/**
	 * 通用分页查询方法
	 * @param connection
	 * @param sql
	 * @param params
	 * @param pageModel
	 * @param handler
	 * @return
	 * @throws SQLException
	 */
	public <T> T queryByPage(Connection conn, String sql, Object[] params, PageModel pageModel, ResultSetHandler<T> handler) throws SQLException
	{
		int start= sql.toLowerCase().indexOf("from");
		int end = sql.toLowerCase().indexOf("group by");
		String countSql = "select count(*) " + sql.substring(start, end == -1 ? sql.length() : end);
		int recordCount = this.query(conn, countSql, params, new ResultSetHandler<Integer>() 
		{
			@Override
			public Integer execute(ResultSet rs) throws SQLException 
			{
				if (rs.next())
				{
					return rs.getInt(1);
				}
				return 0;
			}
		});
		pageModel.setRecordCount(recordCount);
		if (recordCount == 0)
		{
			//return null;
		}
		String pageSql = sql + " limit "+ pageModel.getStartRow() + "," + pageModel.getPageSize();
		return this.query(conn, pageSql, params, handler);
	}
}
