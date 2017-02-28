package cn.rjxh.action.news;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.News;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;
import cn.rjxh.utils.ip.IpUtil;
import cn.rjxh.utils.page.PageModel;

import com.opensymphony.xwork2.ActionSupport;

public class NewsAction extends ActionSupport implements ServletRequestAware{
	private static final long serialVersionUID = 1L;
	
	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	List<HPBanner> banners;
	List<News> news;
	PageModel pageModel = new PageModel();
	News new_;
	String id; 
	String clientIp; 
	News new_prev;
	News new_next;
	String addFlag;
	String updateFlag;
	
	
	/** 获取请求 */
	HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}
	
	public String news(){
		banners = rxService.getBanners();
		pageModel.setPageSize(20);
		news = rxService.getNews(pageModel);
		return SUCCESS;
	}
	
	public String content(){
		banners = rxService.getBanners();
		new_ = rxService.getNew_(id);
		//上一页
		int nowId = Integer.valueOf(id);
		for (int i = nowId-1; i >= 1; i--) {
			new_prev = rxService.getNew_(String.valueOf(i));
			if(new_prev != null){
				break;
			}
		}
		//下一页
		int maxId = rxService.getMaxId();
		for (int i = nowId+1; i <= maxId; i++) {
			new_next = rxService.getNew_(String.valueOf(i));
			if(new_next != null){
				break;
			}
		}
		
		/** ip限制点赞 */
		clientIp = IpUtil.getIp(request);
		if(new_.getIp() != null){
			String[] localIps = new_.getIp().split(",");
			for (String s :localIps) {
				if (clientIp.equals(s)) {
					this.setClientIp("exist");
				}else{
					this.setClientIp(clientIp);
				}
			}
		}else{
			this.setClientIp(clientIp);
		}
		return SUCCESS;
	}

	
	/** 异步通用方法 */
	public String toPageJson(String json){
		try {
			//输出json数据到页面上
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println(json);
			//打印测试json值
			System.out.println("json:  "+json);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NONE;
	}
	
	/**************后台管理系统***************/
	public String updateNewsPage(){
		new_ = rxService.getNew_(id);
		return SUCCESS;
	}
	
	public String updateNews(){
		try {
			adminService.updateNews(new_);
			setUpdateFlag("success");
		} catch (Exception e) {
			setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	public String addNews(){
		try {
			adminService.addNews(new_);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteNews(){
		try {
			adminService.deleteNews(id);
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	public String addzan(){
		return toPageJson(rxService.addzan(id, clientIp));
	}

	public List<HPBanner> getBanners() {
		return banners;
	}
	public void setBanners(List<HPBanner> banners) {
		this.banners = banners;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public News getNew_() {
		return new_;
	}
	public void setNew_(News new_) {
		this.new_ = new_;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public News getNew_prev() {
		return new_prev;
	}
	public void setNew_prev(News new_prev) {
		this.new_prev = new_prev;
	}
	public News getNew_next() {
		return new_next;
	}
	public void setNew_next(News new_next) {
		this.new_next = new_next;
	}
	public String getAddFlag() {
		return addFlag;
	}
	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
}
