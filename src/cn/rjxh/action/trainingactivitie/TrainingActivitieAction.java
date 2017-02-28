package cn.rjxh.action.trainingactivitie;

import java.util.List;

import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.HPTrainingActivitie;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;
import cn.rjxh.utils.page.PageModel;

import com.opensymphony.xwork2.ActionSupport;

public class TrainingActivitieAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	
	List<HPBanner> banners; 
	List<HPTrainingActivitie> trainActives;
	PageModel pageModel = new PageModel();
	HPTrainingActivitie trainActive;
	String id;
	String updateFlag;
	String addFlag;
	String sy;
	String px;
	
	public String trainactive(){
		banners = rxService.getBanners();
		pageModel.setPageSize(20);
		trainActives = rxService.getTrainActives(pageModel, px);
		return SUCCESS;
	}
	
	public String content(){
		banners = rxService.getBanners();
		trainActive = rxService.getTrainActiveContent(id);
		return SUCCESS;
	}
	
	public String updateTrainactive(){
		try {
			adminService.updateTrainactive(trainActive);
			setUpdateFlag("success");
		} catch (Exception e) {
			setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	public String addTrainactive(){
		try {
			adminService.addTrainactive(trainActive);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteTrainactive(){
		try {
			adminService.deleteTrainactive(id);
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String szsyTrainactive(){
		try {
			if (Integer.valueOf(sy)==1) {
				adminService.syTrainactive(id, 2);
			}else{
				adminService.syTrainactive(id, 1);
			}
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	public String qxsyTrainactive(){
		try {
			if (Integer.valueOf(sy)==1) {
				adminService.syTrainactive(id, 2);
			}else{
				adminService.syTrainactive(id, 1);
			}
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
	public List<HPTrainingActivitie> getTrainActives() {
		return trainActives;
	}
	public void setTrainActives(List<HPTrainingActivitie> trainActives) {
		this.trainActives = trainActives;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
	}
	public HPTrainingActivitie getTrainActive() {
		return trainActive;
	}
	public void setTrainActive(HPTrainingActivitie trainActive) {
		this.trainActive = trainActive;
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
	public String getSy() {
		return sy;
	}
	public void setSy(String sy) {
		this.sy = sy;
	}
	public String getPx() {
		return px;
	}
	public void setPx(String px) {
		this.px = px;
	}
}
