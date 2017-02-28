package cn.rjxh.action.bbs;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.rjxh.dto.Remark;
import cn.rjxh.dto.Tz;
import cn.rjxh.dto.User;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;
import cn.rjxh.utils.consts.WebConstant;
import cn.rjxh.utils.imgsrc.AllFilesName;
import cn.rjxh.utils.imgsrc.ImgSrc;
import cn.rjxh.utils.page.PageModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BBSAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	
	List<Tz> tzs;
	PageModel pageModel = new PageModel();
	String title;
	String content;
	String addFlag;
	String tcTip;
	String loginTip;
	Tz tz;
	String id;
	List<Remark> remarks;
	String remarkContent;
	String subRemarkContent;
	String hfUserId;
	String remarkId;

	/**
	 * 查询所有帖子
	 * @return
	 */
	public String bbs(){
		//bbs.jsp页面的数据
		pageModel.setPageSize(20);
		tzs = rxService.getTz(pageModel);
		return SUCCESS;
	}
	
	/**
	 * 添加帖子
	 * @return
	 */
	public String addTz(){
		try {
			User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
			//先判断标题、内容是否为空
			if (title == null || title.equals("")) {
				setTcTip("标题和内容不能为空！");
			}
			if (content == null || content.equals("")) {
				setTcTip("标题和内容不能为空！");
			}
			if(tcTip == null || tcTip.equals("")){
				//再判断用户是否登录
				if (user == null) {
					setLoginTip("您还未登录！");
				}
				//若没提示信息，则添加
				if(loginTip == null || loginTip.equals("")){
					rxService.addTz(title, content, user.getId());
					setAddFlag("success");
				}
			}
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}

	/**
	 * 根据id获取该帖的相关信息
	 * @return
	 */
	public String getTzById(){
		//帖子本身
		tz = rxService.getTzById(id);
		//评论、二级评论
//		System.out.println("tzId:"+id);
		remarks = rxService.getTzRemark(id, pageModel);
//		System.out.println("size():"+remarks.size());
		return SUCCESS;
	}
	
	/**
	 * 添加一级评论
	 * @return
	 */
	public String addRemark(){
		try {
			User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
			if(remarkContent==null || remarkContent.equals("") ){
				setTcTip("评论内容不能为空！");
			}
			if(tcTip==null || tcTip.equals("")){
				if (user == null) {
					setLoginTip("您还未登录！");
				}
				if(loginTip == null || loginTip.equals("")){
					rxService.addRemark(id, remarkContent);
					setAddFlag("success");
				}
			}
		} catch (Exception e) {
			setAddFlag("error");
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
	
	/**
	 * 异步添加二级评论
	 * @return
	 */
	public String addSubRemark(){
		System.out.println("***************进*****************");
		System.out.println("subRemarkContent:"+subRemarkContent);
		User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
		if(subRemarkContent==null || subRemarkContent.equals("")){
			JSONObject json = new JSONObject();
			json.put("tcFlag", "评论内容不能为空！");
			return toPageJson(json.toString());
		}
		if(tcTip==null || tcTip.equals("")){
			System.out.println("判断用户。。。");
			if (user == null) {
				JSONObject json = new JSONObject();
				json.put("loginFlag", "您还未登录！");
				return toPageJson(json.toString());
			}
			if(loginTip == null || loginTip.equals("")){
				System.out.println("---------------添加中...------------");
				return toPageJson(rxService.addSubRemark(remarkId, hfUserId, subRemarkContent));
			}
		}
		return NONE;
	}
	
	
	/**
	 * 取消置顶
	 * @return
	 */
	public String qxZd(){
		try {
			adminService.setZd(2, Integer.valueOf(id));
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	/**
	 * 设置置顶
	 * @return
	 */
	public String szZd(){
		try {
			adminService.setZd(1, Integer.valueOf(id));
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	/**
	 * 删除帖子
	 * @return
	 */
	public String deleteTz(){
		try {
			adminService.deleteTz(id);
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	/**
	 * 管理员添加帖子
	 * @return
	 */
	public String glyAddTz(){
		try {
			User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
			rxService.addTz(title, content, user.getId());
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*** setter and getter method ***/
	public List<Tz> getTzs() {
		return tzs;
	}
	public void setTzs(List<Tz> tzs) {
		this.tzs = tzs;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public String getAddFlag() {
		return addFlag;
	}
	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}
	public String getTcTip() {
		return tcTip;
	}
	public void setTcTip(String tcTip) {
		this.tcTip = tcTip;
	}
	public String getLoginTip() {
		return loginTip;
	}
	public void setLoginTip(String loginTip) {
		this.loginTip = loginTip;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Tz getTz() {
		return tz;
	}
	public void setTz(Tz tz) {
		this.tz = tz;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Remark> getRemarks() {
		return remarks;
	}
	public void setRemarks(List<Remark> remarks) {
		this.remarks = remarks;
	}
	public String getRemarkContent() {
		return remarkContent;
	}
	public void setRemarkContent(String remarkContent) {
		this.remarkContent = remarkContent;
	}
	public String getHfUserId() {
		return hfUserId;
	}
	public void setHfUserId(String hfUserId) {
		this.hfUserId = hfUserId;
	}
	public String getRemarkId() {
		return remarkId;
	}
	public void setRemarkId(String remarkId) {
		this.remarkId = remarkId;
	}
	public String getSubRemarkContent() {
		return subRemarkContent;
	}
	public void setSubRemarkContent(String subRemarkContent) {
		this.subRemarkContent = subRemarkContent;
	}
}
