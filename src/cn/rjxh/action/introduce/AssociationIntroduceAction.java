package cn.rjxh.action.introduce;

import java.io.File;
import java.util.List;

import cn.rjxh.dto.AssociationIntroduce;
import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.News;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;
import cn.rjxh.utils.page.PageModel;

import com.opensymphony.xwork2.ActionSupport;

public class AssociationIntroduceAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	List<HPBanner> banners; 
	List<AssociationIntroduce> associationIntroduces; 
	List<AssociationIntroduce> associationImgIntroduces; 
	List<News> news; 
	PageModel pageModel = new PageModel();
	AssociationIntroduce introduce;
	String id;
	String updateFlag;
	String addFlag;
	String imgtitle;
	File image;
	String imageFileName;
	
	
	public String introduce(){
		banners = rxService.getBanners();
		pageModel.setPageSize(20);
		associationIntroduces = rxService.getAssociationIntroduces(pageModel);
		associationImgIntroduces = rxService.getAssociationImgIntroduces();
		return SUCCESS;
	}
	
	public String updateBaseInfoPage(){
		introduce = adminService.getIntroduce(id);
		return SUCCESS;
	}
	
	public String updateBaseInfo(){
		try {
			adminService.updateIntroduce(introduce);
			setUpdateFlag("success");
		} catch (Exception e) {
			setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	public String addBaseInfo(){
		try {
			adminService.addBaseInfo(introduce);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteBaseInfo(){
		try {
			adminService.deleteBaseInfo(id);
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	public String addImgInfo(){
		try {
			adminService.addImgInfo(imgtitle, image, imageFileName);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteImgInfo(){
		try {
			adminService.deleteImgInfo(id);
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
	public List<AssociationIntroduce> getAssociationIntroduces() {
		return associationIntroduces;
	}
	public void setAssociationIntroduces(
			List<AssociationIntroduce> associationIntroduces) {
		this.associationIntroduces = associationIntroduces;
	}
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	public List<AssociationIntroduce> getAssociationImgIntroduces() {
		return associationImgIntroduces;
	}
	public void setAssociationImgIntroduces(
			List<AssociationIntroduce> associationImgIntroduces) {
		this.associationImgIntroduces = associationImgIntroduces;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public AssociationIntroduce getIntroduce() {
		return introduce;
	}
	public void setIntroduce(AssociationIntroduce introduce) {
		this.introduce = introduce;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getImgtitle() {
		return imgtitle;
	}
	public void setImgtitle(String imgtitle) {
		this.imgtitle = imgtitle;
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
}

