package cn.rjxh.action.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.rjxh.dto.User;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;
import cn.rjxh.utils.consts.WebConstant;
import cn.rjxh.utils.page.PageModel;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	User loginuser;
	String loginFlag;
	List<User> users;
	PageModel pageModel = new PageModel();
	User searchuser;
	User updateuser;
	String updateFlag;
	String addFlag;
	User adduser;
	String checkUsername;
	String deleteId;
	String deleteFlag;
	String self;
	User registerUser;
	String yzm;
	String id;
	
	
	public String login(){
		User user = adminService.login(loginuser);
		if (user != null) {
			return SUCCESS;
		}else{
			this.setLoginFlag("login_error");
			return ERROR;
		}
	}
	
	public String getUser(){
		pageModel.setPageSize(20);
		if(searchuser==null){
			searchuser = new User();
		}
		users = adminService.getUser(pageModel, searchuser);
		return SUCCESS;
	}
	
	public String updateUserPage(){
		//点击【个人名称】信息进来的！
		if (self!=null && !self.equals("")) {
			User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
			//不是admin用户，是admin本人则不设置值
			if (!user.getUsername().equals("admin")) {
				this.setSelf("1");
			}
		}
		updateuser = adminService.getUser(updateuser.getId());
		return SUCCESS;
	}
	
	public String updateUser(){
		try {
			adminService.updateUser(updateuser);
			User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
			//不是admin用户，是admin本人则不设置值
			if (!user.getUsername().equals("admin")) {
				this.setSelf("1");
			}
			this.setUpdateFlag("修改成功！");
		} catch (Exception e) {
			this.setUpdateFlag("修改失败！");
		}
		return SUCCESS;
	}
	
	public String addUserPage(){
		return SUCCESS;
	}
	
	public String addUser(){
		try {
			adminService.addUser(adduser);
			this.setAddFlag("添加成功！");
		} catch (Exception e) {
			this.setAddFlag("添加失败！");
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
	
	public String checkUsername(){
		users = adminService.getUser(pageModel, new User());
		JSONObject json = new JSONObject();
		for (User user : users) {
			if (user.getUsername().equals(checkUsername)) {
				json.put("exist", "true");
			}
		}
		return toPageJson(json.toString());
	}
	
	public String deleteUser(){
		try {
			adminService.deleteUser(deleteId);
			setDeleteFlag("删除成功！");
		} catch (Exception e) {
			setDeleteFlag("删除失败！");
		}
		return SUCCESS;
	}
	
	
	/**
	 * 异步注册用户
	 * @return
	 */
	public String registerUser(){
//		users = adminService.getUser(pageModel, new User());
//		JSONObject json = new JSONObject();
//		for (User user : users) {
//			if (user.getUsername().equals(checkUsername)) {
//				json.put("exist", "true");
//			}
//		}
		return toPageJson(rxService.registerUser(registerUser, yzm));
	}
	
	public String getSelfInfo(){
		System.out.println("------------");
		updateuser = adminService.getUser(Integer.valueOf(id));
		System.out.println(updateuser.getId()+",,,,,,,,,,");
		return SUCCESS;
	}
	
	public String updateSelfUser(){
		try {
			rxService.updateSelfUser(updateuser);
			setUpdateFlag("修改成功！");
		} catch (Exception e) {
			setUpdateFlag("error");
		}
		return SUCCESS;
	}

	public String loginout(){
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	
	
	
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public User getLoginuser() {
		return loginuser;
	}
	public void setLoginuser(User loginuser) {
		this.loginuser = loginuser;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public User getSearchuser() {
		return searchuser;
	}
	public void setSearchuser(User searchuser) {
		this.searchuser = searchuser;
	}
	public User getUpdateuser() {
		return updateuser;
	}
	public void setUpdateuser(User updateuser) {
		this.updateuser = updateuser;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	public String getAddFlag() {
		return addFlag;
	}
	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}
	public User getAdduser() {
		return adduser;
	}
	public void setAdduser(User adduser) {
		this.adduser = adduser;
	}
	public String getCheckUsername() {
		return checkUsername;
	}
	public void setCheckUsername(String checkUsername) {
		this.checkUsername = checkUsername;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getDeleteId() {
		return deleteId;
	}
	public void setDeleteId(String deleteId) {
		this.deleteId = deleteId;
	}
	public String getSelf() {
		return self;
	}
	public void setSelf(String self) {
		this.self = self;
	}
	public User getRegisterUser() {
		return registerUser;
	}
	public void setRegisterUser(User registerUser) {
		this.registerUser = registerUser;
	}
	public String getYzm() {
		return yzm;
	}
	public void setYzm(String yzm) {
		this.yzm = yzm;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
