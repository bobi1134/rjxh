package cn.rjxh.action.hotanswer;

import java.util.List;

import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.HPHotAnswering;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;
import cn.rjxh.utils.page.PageModel;

import com.opensymphony.xwork2.ActionSupport;

public class HotAnswerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	
	List<HPHotAnswering> hotAnswerings;
	List<HPBanner> banners; 
	PageModel pageModel = new PageModel();
	HPHotAnswering hotAnswer;
	String id;
	String updateFlag;
	String addFlag;
	String sy;
	String px;

	public String hotanswer(){
		banners = rxService.getBanners();
		pageModel.setPageSize(10);
		hotAnswerings = rxService.getHotAnswerings(pageModel, px);
		return SUCCESS;
	}
	
	public String content(){
		banners = rxService.getBanners();
		hotAnswer = rxService.getHotAnswerContent(id);
		return SUCCESS;
	}
	
	public String updateHotAnswer(){
		try {
			adminService.updateHotAnswer(hotAnswer);
			this.setUpdateFlag("success");
		} catch (Exception e) {
			this.setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	public String addHotAnswer(){
		try {
			adminService.addHotAnswer(hotAnswer);
			this.setAddFlag("success");
		} catch (Exception e) {
			this.setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteHotAnswer(){
		try {
			adminService.deleteHotAnswer(id);
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	public String szsyHotAnswer(){
		try {
			if (Integer.valueOf(sy)==1) {
				adminService.syHotAnswer(id, 2);
			}else{
				adminService.syHotAnswer(id, 1);
			}
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	public String qxsyHotAnswer(){
		try {
			if (Integer.valueOf(sy)==1) {
				adminService.syHotAnswer(id, 2);
			}else{
				adminService.syHotAnswer(id, 1);
			}
		} catch (Exception e) {
		}
		return SUCCESS;
	}
	
	
	
	
	public List<HPHotAnswering> getHotAnswerings() {
		return hotAnswerings;
	}
	public void setHotAnswerings(List<HPHotAnswering> hotAnswerings) {
		this.hotAnswerings = hotAnswerings;
	}
	public List<HPBanner> getBanners() {
		return banners;
	}
	public void setBanners(List<HPBanner> banners) {
		this.banners = banners;
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
	public HPHotAnswering getHotAnswer() {
		return hotAnswer;
	}
	public void setHotAnswer(HPHotAnswering hotAnswer) {
		this.hotAnswer = hotAnswer;
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
