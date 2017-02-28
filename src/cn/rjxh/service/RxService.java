package cn.rjxh.service;

import java.util.List;

import cn.rjxh.dto.AssociationIntroduce;
import cn.rjxh.dto.Contact;
import cn.rjxh.dto.ContactSub;
import cn.rjxh.dto.DepartmentStyle;
import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.HPHotAnswering;
import cn.rjxh.dto.HPSkillTalk;
import cn.rjxh.dto.HPTrainingActivitie;
import cn.rjxh.dto.News;
import cn.rjxh.dto.Remark;
import cn.rjxh.dto.Tz;
import cn.rjxh.dto.User;
import cn.rjxh.utils.page.PageModel;

public interface RxService {
	
	/******面向用户前台系统******/
	/*********index.jsp*********/
	/**
	 * 获取所有Banner图
	 * @return
	 */
	List<HPBanner> getBanners();

	List<HPSkillTalk> getSkills();

	List<HPHotAnswering> getHotAnswerings();

	List<HPTrainingActivitie> getTrainingActivities();

	/*********introduce.jsp*********/
	List<AssociationIntroduce> getAssociationIntroduces(PageModel pageModel);
	
	List<AssociationIntroduce> getAssociationImgIntroduces();

	/*********style.jsp*********/
	List<DepartmentStyle> getStyles(String belong, int flag);

	/*********news_content.jsp*********/
	List<News> getNews(PageModel pageModel);
	
	News getNew_(String id);
	
	int getMaxId();

	String addzan(String id, String clientIp);

	/*********contact.jsp*********/
//	List<Contact> getContact(boolean group);

	/************hotanswering.jsp************/
	List<HPHotAnswering> getHotAnswerings(PageModel pageModel, String px);

	HPHotAnswering getHotAnswerContent(String id);

	List<HPTrainingActivitie> getTrainActives(PageModel pageModel, String px);

	HPTrainingActivitie getTrainActiveContent(String id);

	/***论坛***/
	/**
	 * 【用户】展示所有帖子
	 * @param pageModel
	 * @return
	 */
	List<Tz> getTz(PageModel pageModel);

	/**
	 * 添加帖子
	 * @param title
	 * @param content
	 */
	void addTz(String title, String content, int userId);

	/**
	 * 根据id获取该帖的相关信息
	 * @param id
	 * @return
	 */
	Tz getTzById(String id);

	/**
	 * 根据帖子id获取该帖子的所有一级评论，二级评论
	 * @param id
	 * @return
	 */
	List<Remark> getTzRemark(String id, PageModel pageModel);

	/**
	 * 添加一级评论
	 * @param id
	 */
	void addRemark(String id, String remarkContent);

	/**
	 * 异步添加二级评论
	 * @param hfUserId
	 * @param subRemarkCoent
	 * @return
	 */
	String addSubRemark(String remarkId, String hfUserId, String subRemarkContent);

	/**
	 * 获取父类【联系我们子类】信息
	 * @return
	 */
	List<ContactSub> getSubContact();

	/**
	 * 获取父类【联系我们】信息
	 * @return
	 */
	List<Contact> getParentContact();

	/**
	 * 异步注册用户
	 * @param registerUser
	 * @return
	 */
	String registerUser(User registerUser, String yzm);

	void updateSelfUser(User updateuser);


	

}
