package cn.rjxh.action.departmentstyle;

import java.util.List;

import cn.rjxh.dto.DepartmentStyle;
import cn.rjxh.dto.HPBanner;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.RxService;
import cn.rjxh.service.impl.AdminServiceImpl;
import cn.rjxh.service.impl.RxServiceImpl;
import cn.rjxh.service.proxy.ProxyFactory;

import com.opensymphony.xwork2.ActionSupport;

public class DepartmentStyleAction extends ActionSupport{
	private static final long serialVersionUID = 1L;

	RxService rxService = ProxyFactory.getProxy(new RxServiceImpl());
	AdminService adminService = ProxyFactory.getProxy(new AdminServiceImpl());
	List<HPBanner> banners; 
	List<DepartmentStyle> xxjj_about; 
	List<DepartmentStyle> xxjj_category; 
	List<DepartmentStyle> bgs_about; 
	List<DepartmentStyle> bgs_category; 
	List<DepartmentStyle> jsb_about; 
	List<DepartmentStyle> jsb_category; 
	List<DepartmentStyle> wlb_about; 
	List<DepartmentStyle> wlb_category; 
	List<DepartmentStyle> zzb_about; 
	List<DepartmentStyle> zzb_category; 
	
	DepartmentStyle xxjj_about_dg;
	//DepartmentStyle xxjj_category_dg;
	DepartmentStyle bgs_about_dg;
	//DepartmentStyle bgs_category_dg;
	DepartmentStyle jsb_about_dg;
	//DepartmentStyle jsb_category_dg;
	DepartmentStyle wlb_about_dg;
	//DepartmentStyle wlb_category_dg;
	DepartmentStyle zzb_about_dg;
	//DepartmentStyle zzb_category_dg;
	
	DepartmentStyle style;
	String id;
	String addFlag;
	String updateFlag;
	List<DepartmentStyle> subStyles;
	String zc;
	
	/**
	 * 获取所有的部门风采
	 * @return
	 */
	public String style(){
		banners = rxService.getBanners();
		xxjj_about = rxService.getStyles("xhjj", 1);
		xxjj_category = rxService.getStyles("xhjj", 2);
		bgs_about = rxService.getStyles("bgs", 1);
		bgs_category = rxService.getStyles("bgs", 2);
		jsb_about = rxService.getStyles("jsb", 1);
		jsb_category = rxService.getStyles("jsb", 2);
		wlb_about = rxService.getStyles("wlb", 1);
		wlb_category = rxService.getStyles("wlb", 2);
		zzb_about = rxService.getStyles("zzb", 1);
		zzb_category = rxService.getStyles("zzb", 2);
		return SUCCESS;
	}
	
	public String style_ht(){
		xxjj_about_dg = adminService.getStylesDg("xhjj", 1);
		//xxjj_category = rxService.getStyles("xhjj", 2);
		
		bgs_about_dg = adminService.getStylesDg("bgs", 1);
		//bgs_category = rxService.getStyles("bgs", 2);
		
		jsb_about_dg = adminService.getStylesDg("jsb", 1);
		//jsb_category = rxService.getStyles("jsb", 2);
		
		wlb_about_dg = adminService.getStylesDg("wlb", 1);
		//wlb_category = rxService.getStyles("wlb", 2);
		
		zzb_about_dg = adminService.getStylesDg("zzb", 1);
		//zzb_category = rxService.getStyles("zzb", 2);
		return SUCCESS;
	}
	
	public String updateZcPage(){
		style = adminService.getStyle(id);
		return SUCCESS;
	}
	
	public String updateZc(){
		try {
			adminService.updateZc(style);
			setUpdateFlag("success");
		} catch (Exception e) {
			setUpdateFlag("error");
		}
		return SUCCESS;
	}
	
	public String subZcPage(){
		subStyles = rxService.getStyles(zc, 2);
		return SUCCESS;
	}
	
	public String addSubZcPage(){
		setZc(zc);
		return SUCCESS;
	}
	
	public String addSubZc(){
		try {
			adminService.addSubZc(style);
			setZc(style.getBelong());
			setAddFlag("success");
		} catch (Exception e) {
			setAddFlag("error");
		}
		return SUCCESS;
	}
	
	public String deleteSubZc(){
		try {
			adminService.deleteSubZc(id);
			setZc(style.getBelong());
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
	public List<DepartmentStyle> getXxjj_about() {
		return xxjj_about;
	}
	public void setXxjj_about(List<DepartmentStyle> xxjj_about) {
		this.xxjj_about = xxjj_about;
	}
	public List<DepartmentStyle> getXxjj_category() {
		return xxjj_category;
	}
	public void setXxjj_category(List<DepartmentStyle> xxjj_category) {
		this.xxjj_category = xxjj_category;
	}
	public List<DepartmentStyle> getBgs_about() {
		return bgs_about;
	}
	public void setBgs_about(List<DepartmentStyle> bgs_about) {
		this.bgs_about = bgs_about;
	}
	public List<DepartmentStyle> getBgs_category() {
		return bgs_category;
	}
	public void setBgs_category(List<DepartmentStyle> bgs_category) {
		this.bgs_category = bgs_category;
	}
	public List<DepartmentStyle> getJsb_about() {
		return jsb_about;
	}
	public void setJsb_about(List<DepartmentStyle> jsb_about) {
		this.jsb_about = jsb_about;
	}
	public List<DepartmentStyle> getJsb_category() {
		return jsb_category;
	}
	public void setJsb_category(List<DepartmentStyle> jsb_category) {
		this.jsb_category = jsb_category;
	}
	public List<DepartmentStyle> getWlb_about() {
		return wlb_about;
	}
	public void setWlb_about(List<DepartmentStyle> wlb_about) {
		this.wlb_about = wlb_about;
	}
	public List<DepartmentStyle> getWlb_category() {
		return wlb_category;
	}
	public void setWlb_category(List<DepartmentStyle> wlb_category) {
		this.wlb_category = wlb_category;
	}
	public List<DepartmentStyle> getZzb_about() {
		return zzb_about;
	}
	public void setZzb_about(List<DepartmentStyle> zzb_about) {
		this.zzb_about = zzb_about;
	}
	public List<DepartmentStyle> getZzb_category() {
		return zzb_category;
	}
	public void setZzb_category(List<DepartmentStyle> zzb_category) {
		this.zzb_category = zzb_category;
	}
	public DepartmentStyle getXxjj_about_dg() {
		return xxjj_about_dg;
	}
	public void setXxjj_about_dg(DepartmentStyle xxjj_about_dg) {
		this.xxjj_about_dg = xxjj_about_dg;
	}
	public DepartmentStyle getBgs_about_dg() {
		return bgs_about_dg;
	}
	public void setBgs_about_dg(DepartmentStyle bgs_about_dg) {
		this.bgs_about_dg = bgs_about_dg;
	}
	public DepartmentStyle getJsb_about_dg() {
		return jsb_about_dg;
	}
	public void setJsb_about_dg(DepartmentStyle jsb_about_dg) {
		this.jsb_about_dg = jsb_about_dg;
	}
	public DepartmentStyle getWlb_about_dg() {
		return wlb_about_dg;
	}
	public void setWlb_about_dg(DepartmentStyle wlb_about_dg) {
		this.wlb_about_dg = wlb_about_dg;
	}
	public DepartmentStyle getZzb_about_dg() {
		return zzb_about_dg;
	}
	public void setZzb_about_dg(DepartmentStyle zzb_about_dg) {
		this.zzb_about_dg = zzb_about_dg;
	}
	public DepartmentStyle getStyle() {
		return style;
	}
	public void setStyle(DepartmentStyle style) {
		this.style = style;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public List<DepartmentStyle> getSubStyles() {
		return subStyles;
	}
	public void setSubStyles(List<DepartmentStyle> subStyles) {
		this.subStyles = subStyles;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
}
