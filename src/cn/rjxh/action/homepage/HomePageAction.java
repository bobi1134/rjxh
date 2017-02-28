package cn.rjxh.action.homepage;

import java.io.File;
import java.util.List;

import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.HPHotAnswering;
import cn.rjxh.dto.HPSkillTalk;
import cn.rjxh.dto.HPTrainingActivitie;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;

import com.opensymphony.xwork2.ActionSupport;

public class HomePageAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	List<HPBanner> banners; 
	List<HPSkillTalk> skills; 
	List<HPHotAnswering> hotAnswerings; 
	List<HPTrainingActivitie> trainingActivities; 
	
	String id;
	HPBanner updateBanner;
	File image;
	String imageFileName;
	String updateFlag;
	String deleteFlag;
	String addFlag;
	String title;
	
	HPSkillTalk skill;
	String category;
	

	public String welcome(){
		banners = rxService.getBanners();
		skills = rxService.getSkills();
		hotAnswerings = rxService.getHotAnswerings();
		trainingActivities = rxService.getTrainingActivities();
		return SUCCESS;
	}

	/*****banner*******/
	public String getBanner(){
		banners = rxService.getBanners();
		return SUCCESS;
	}
	
	public String updateBannerPage(){
		updateBanner = adminService.getBanner(id);
		return SUCCESS;
	}
	
	public String updateBanner(){
		try {
			adminService.updateBanner(updateBanner, image, imageFileName);
			this.setUpdateFlag("success");;
		} catch (Exception e) {
			this.setUpdateFlag("error");;
		}
		return SUCCESS;
	}
	
	public String deleteBanner(){
		try {
			adminService.deleteBanner(id);
			this.setDeleteFlag("success");
		} catch (Exception e) {
			this.setDeleteFlag("error");
		}
		return SUCCESS;
	}
	
	public String addBanner(){
		try {
			adminService.addBanner(image, imageFileName, title);
			this.setAddFlag("success");
		} catch (Exception e) {
			this.setAddFlag("error");
		}
		return SUCCESS;
	}
	
	/*************skilltalk****************/
	public String getSkilltalk(){
		skills = rxService.getSkills();
		return SUCCESS;
	}
	
	public String updateSkilltalkPage(){
		skill = adminService.getSkill(id);
		return SUCCESS;
	}
	
	public String updateSkilltalk(){
		try {
			if (image==null) {
				System.out.println("文件为空！");
				adminService.updateSkilltalk(id, title);
			}else{
				System.out.println("文件不为空！");
				adminService.updateSkilltalk(id, title, image, imageFileName);
			}
			this.setUpdateFlag("success");
		} catch (Exception e) {
			this.setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	public String addSubSkilltalk(){
		try {
			adminService.addSubSkilltalk(id, category);
			this.setAddFlag("success");
		} catch (Exception e) {
			this.setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteSubSkilltalk(){
		try {
			adminService.deleteSubSkilltalk(id, category);
			this.setDeleteFlag("success");
		} catch (Exception e) {
			this.setDeleteFlag("error");
		}
		return SUCCESS;
	}
	
	public String addSkilltalk(){
		try {
			adminService.addSkilltalk(title, category, image, imageFileName);
			this.setAddFlag("success");
		} catch (Exception e) {
			this.setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteSkilltalk(){
		try {
			adminService.deleteSkilltalk(id);
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
	public List<HPSkillTalk> getSkills() {
		return skills;
	}
	public void setSkills(List<HPSkillTalk> skills) {
		this.skills = skills;
	}
	public List<HPHotAnswering> getHotAnswerings() {
		return hotAnswerings;
	}
	public void setHotAnswerings(List<HPHotAnswering> hotAnswerings) {
		this.hotAnswerings = hotAnswerings;
	}
	public List<HPTrainingActivitie> getTrainingActivities() {
		return trainingActivities;
	}
	public void setTrainingActivities(List<HPTrainingActivitie> trainingActivities) {
		this.trainingActivities = trainingActivities;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public HPBanner getUpdateBanner() {
		return updateBanner;
	}
	public void setUpdateBanner(HPBanner updateBanner) {
		this.updateBanner = updateBanner;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	public String getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(String updateFlag) {
		this.updateFlag = updateFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAddFlag() {
		return addFlag;
	}
	public void setAddFlag(String addFlag) {
		this.addFlag = addFlag;
	}
	public HPSkillTalk getSkill() {
		return skill;
	}
	public void setSkill(HPSkillTalk skill) {
		this.skill = skill;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
