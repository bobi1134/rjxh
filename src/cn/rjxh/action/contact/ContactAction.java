package cn.rjxh.action.contact;

import java.util.List;

import cn.rjxh.dto.Contact;
import cn.rjxh.dto.ContactSub;
import cn.rjxh.dto.HPBanner;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;

import com.opensymphony.xwork2.ActionSupport;

public class ContactAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	List<HPBanner> banners;
	List<Contact> contacts;
	//List<Contact> contactSubs;
	List<Contact> contactParents;
	List<ContactSub> contactSubs;
	Contact subContact;
	String id;
	String updateFlag;
	String addFlag;
	ContactSub contactSub;
	String category;
	String title;
	String content;
	String belongId;

	/**
	 * 获取所有联系我们信息
	 * @return
	 */
	public String contact(){
		/**
		 * 获取所有Banner图
		 */
		banners = rxService.getBanners();
		//contacts = rxService.getContact(true);
		//修改后的
		/**
		 * 获取父类【联系我们】信息
		 */
		contactParents = rxService.getParentContact();
		/**
		 * 获取父类【联系我们子类】信息
		 */
		contactSubs = rxService.getSubContact();
		return SUCCESS;
	}
	
	/**
	 * 获取所有的【联系我们】
	 * @return
	 */
	public String getContact(){
//		contacts = rxService.getContact(false);
		contacts = adminService.getAllContact();
		return SUCCESS;
	}
	
	/**
	 * 跳到修改【联系我们】页面
	 * @return
	 */
	public String updateContactPage(){
		subContact = adminService.getContact(id);
		return SUCCESS;
	}
	
	/**
	 * 修改【联系我们】信息
	 * @return
	 */
	public String updateContact(){
		try {
			adminService.updateContact(contactSub);
			setUpdateFlag("success");
		} catch (Exception e) {
			setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	/**
	 * 【联系我们】添加分类
	 * @return
	 */
	public String addFl(){
		try {
			adminService.addFl(category, title, content);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	/**
	 * 【联系我们】跳到子内容信息
	 * @return
	 */
	public String addBtPage(){
		//contacts = rxService.getContact(true);
		contactParents = rxService.getParentContact();
		return SUCCESS;
	}
	
	/**
	 * 添加子内容
	 * @return
	 */
	public String addBt(){
		try {
			adminService.addBt(belongId, title, content);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	/**
	 * 删除子分类
	 * @return
	 */
	public String deleteSubContact(){
		try {
			adminService.deleteSubContact(id, belongId);
		} catch (Exception e) {
		}
		return SUCCESS;
	}

	
	
	
	
	
	
	public List<HPBanner> getBanners() {
		return banners;
	}
	public void setBanners(List<HPBanner> banners) {
		this.banners = banners;
	}
	public String getBelongId() {
		return belongId;
	}

	public void setBelongId(String belongId) {
		this.belongId = belongId;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
//	public List<Contact> getContactSubs() {
//		return contactSubs;
//	}
//	public void setContactSubs(List<Contact> contactSubs) {
//		this.contactSubs = contactSubs;
//	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Contact getSubContact() {
		return subContact;
	}
	public void setSubContact(Contact subContact) {
		this.subContact = subContact;
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
	public ContactSub getContactSub() {
		return contactSub;
	}
	public void setContactSub(ContactSub contactSub) {
		this.contactSub = contactSub;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public List<ContactSub> getContactSubs() {
		return contactSubs;
	}
	public void setContactSubs(List<ContactSub> contactSubs) {
		this.contactSubs = contactSubs;
	}

	public List<Contact> getContactParents() {
		return contactParents;
	}

	public void setContactParents(List<Contact> contactParents) {
		this.contactParents = contactParents;
	}
}
