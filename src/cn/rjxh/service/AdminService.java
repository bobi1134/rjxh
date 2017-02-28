package cn.rjxh.service;

import java.io.File;
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
import cn.rjxh.dto.User;
import cn.rjxh.utils.page.PageModel;

public interface AdminService {
	
	/******用户登陆******/
	User login(User user);

	List<User> getUser(PageModel pageModel, User searchuser);

	User getUser(int id);

	void updateUser(User updateuser);

	void addUser(User adduser);

	void deleteUser(String deleteId);

	/******Banner图******/
	HPBanner getBanner(String id);

	void updateBanner(HPBanner updateBanner, File image, String imageFileName);

	void deleteBanner(String id);

	void addBanner(File image, String imageFileName, String title);

	HPSkillTalk getSkill(String id);

	void updateSkilltalk(String id, String title);

	void updateSkilltalk(String id, String title, File image, String imageFileName);

	void addSubSkilltalk(String id, String category);

	void deleteSubSkilltalk(String id, String category);

	void addSkilltalk(String title, String category, File image, String imageFileName);

	void deleteSkilltalk(String id);

	void updateHotAnswer(HPHotAnswering hotAnswer);

	void addHotAnswer(HPHotAnswering hotAnswer);

	void deleteHotAnswer(String id);

	void syHotAnswer(String id, int sy);

	void updateTrainactive(HPTrainingActivitie trainActive);

	void addTrainactive(HPTrainingActivitie trainActive);

	void deleteTrainactive(String id);

	void syTrainactive(String id, int sy);

	void updateNews(News new_);

	void addNews(News new_);

	void deleteNews(String id);

	AssociationIntroduce getIntroduce(String id);

	void updateIntroduce(AssociationIntroduce introduce);

	void addBaseInfo(AssociationIntroduce introduce);

	void deleteBaseInfo(String id);

	void addImgInfo(String imgtitle, File image, String imageFileName);

	void deleteImgInfo(String id);

	DepartmentStyle getStylesDg(String belong, int flag);

	DepartmentStyle getStyle(String id);

	void updateZc(DepartmentStyle style);

	void addSubZc(DepartmentStyle style);

	void deleteSubZc(String id);

	/**
	 * 跳到修改【联系我们】页面
	 * @param id
	 * @return
	 */
	Contact getContact(String id);

	/**
	 * 修改【联系我们】信息
	 * @param contactSub
	 */
	void updateContact(ContactSub contactSub);

	/**
	 * 【联系我们】添加分类
	 * @param category
	 * @param title
	 * @param content
	 */
	void addFl(String category, String title, String content);

	/**
	 * 添加子内容
	 * @param belongId
	 * @param title
	 * @param content
	 */
	void addBt(String belongId, String title, String content);

	/**
	 * 删除子分类
	 * @param id
	 * @param belongId
	 */
	void deleteSubContact(String id, String belongId);

	
	/**
	 * 获取所有的【联系我们】
	 * @return
	 */
	List<Contact> getAllContact();

	/**
	 * 设置是否置顶
	 * @param i
	 */
	void setZd(int zd, int id);

	/**
	 * 删除帖子
	 * @param id
	 */
	void deleteTz(String id);

	




}
