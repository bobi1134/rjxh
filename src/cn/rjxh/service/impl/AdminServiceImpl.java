package cn.rjxh.service.impl;

import java.io.File;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

import cn.rjxh.dao.AssociationIntroduceDao;
import cn.rjxh.dao.BBSDao;
import cn.rjxh.dao.ContactDao;
import cn.rjxh.dao.DepartmentStyleDao;
import cn.rjxh.dao.HPBannerDao;
import cn.rjxh.dao.HPHotAnsweringDao;
import cn.rjxh.dao.HPSkillTalkDao;
import cn.rjxh.dao.HPTrainingActivitieDao;
import cn.rjxh.dao.NewsDao;
import cn.rjxh.dao.UserDao;
import cn.rjxh.dao.impl.AssociationIntroduceDaoImpl;
import cn.rjxh.dao.impl.BBSDaoImpl;
import cn.rjxh.dao.impl.ContactDaoImpl;
import cn.rjxh.dao.impl.DepartmentStyleDaoImpl;
import cn.rjxh.dao.impl.HPBannerDaoImpl;
import cn.rjxh.dao.impl.HPHotAnsweringDaoImpl;
import cn.rjxh.dao.impl.HPSkillTalkDaoImpl;
import cn.rjxh.dao.impl.HPTrainingActivitieDaoImpl;
import cn.rjxh.dao.impl.NewsDaoImpl;
import cn.rjxh.dao.impl.UserDaoImpl;
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
import cn.rjxh.exception.RxException;
import cn.rjxh.service.AdminService;
import cn.rjxh.service.proxy.Transcation;
import cn.rjxh.utils.consts.WebConstant;
import cn.rjxh.utils.page.PageModel;

public class AdminServiceImpl implements AdminService {

	private Connection conn;
	public void setConnection(Connection connection){
		this.conn = connection;
	}
	
	private UserDao userDao;
	private HPBannerDao hPBannerDao;
	private HPSkillTalkDao hPSkillTalkDao;
	private HPHotAnsweringDao hPHotAnsweringDao;
	private HPTrainingActivitieDao hPTrainingActivitieDao;
	private AssociationIntroduceDao associationIntroduceDao;
	private DepartmentStyleDao departmentStyleDao;
	private NewsDao newsDao;
	private ContactDao contactDao;
	private BBSDao bbsDao;
	public AdminServiceImpl(){
		userDao = new UserDaoImpl();
		hPBannerDao = new HPBannerDaoImpl();
		hPSkillTalkDao = new HPSkillTalkDaoImpl();
		hPHotAnsweringDao = new HPHotAnsweringDaoImpl();
		hPTrainingActivitieDao = new HPTrainingActivitieDaoImpl();
		newsDao = new NewsDaoImpl();
		associationIntroduceDao = new AssociationIntroduceDaoImpl();
		departmentStyleDao = new DepartmentStyleDaoImpl();
		contactDao = new ContactDaoImpl();
		bbsDao = new BBSDaoImpl();
	}
	
	/******用户登陆******/
	@Transcation(readOnly=true)
	public User login(User user) {
		try {
			User u = userDao.login(conn, user);
			if (u != null) {
				ActionContext.getContext().getSession().put(WebConstant.SESSION_USER, u);
			}
			return u;
		} catch (Exception e) {
			throw new RxException("用户登陆时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public List<User> getUser(PageModel pageModel, User searchuser) {
		try {
			return userDao.getUser(conn, pageModel, searchuser);
		} catch (Exception e) {
			throw new RxException("多条件查询用户时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public User getUser(int id) {
		try {
			return userDao.getUser(conn, id);
		} catch (Exception e) {
			throw new RxException("按照id获取单个用户时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateUser(User updateuser) {
		try {
			if(updateuser.getRole()==0){
				updateuser.setRole(1);
			}
			userDao.updateUser(conn, updateuser);
		} catch (Exception e) {
			throw new RxException("按照id修改单个用户时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addUser(User adduser) {
		try {
			userDao.addUser(conn, adduser);
		} catch (Exception e) {
			throw new RxException("添加用户时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteUser(String deleteId) {
		try {
			userDao.deleteUser(conn, deleteId);
		} catch (Exception e) {
			throw new RxException("删除用户时出现异常！");
		}
	}
	
	/******后台系统******/
	@Transcation(readOnly=true)
	public HPBanner getBanner(String id) {
		try {
			return hPBannerDao.getBanner(conn, id);
		} catch (Exception e) {
			throw new RxException("根据id获取单个Banner图时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateBanner(HPBanner updateBanner, File image, String imageFileName) {
		try {
			//先删除本地文件
			String sjkFileName = hPBannerDao.getBanner(conn, String.valueOf(updateBanner.getId())).getImage();
			String absolutelyPath = ServletActionContext.getServletContext().getRealPath("/");
			String ccPath = absolutelyPath+File.separator+"rx"+File.separator+"images";
			File file = new File(ccPath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(sjkFileName)) {
						files[i].delete();
						break;
					}
				}
			}
			//再上传文件
			String newFileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imageFileName);
			FileUtils.copyFile(image, new File(ccPath+File.separator+newFileName));
			
			updateBanner.setImage(newFileName);
			hPBannerDao.updateBanner(conn, updateBanner);
		} catch (Exception e) {
			throw new RxException("根据id修改单个Banner图时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteBanner(String id) {
		try {
			//先删除服务器文件
			String sjkFileName = hPBannerDao.getBanner(conn, id).getImage();;
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			File file = new File(ccPath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(sjkFileName)) {
						files[i].delete();
						break;
					}
				}
			}
			hPBannerDao.deleteBanner(conn, id);
		} catch (Exception e) {
			throw new RxException("根据id删除单个Banner图时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addBanner(File image, String imageFileName, String title) {
		try {
			//先上传文件
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			String newFileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imageFileName);
			FileUtils.copyFile(image, new File(ccPath+File.separator+newFileName));
			hPBannerDao.deleteBanner(conn, newFileName, title);
		} catch (Exception e) {
			throw new RxException("添加单个Banner图时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public HPSkillTalk getSkill(String id) {
		try {
			HPSkillTalk hPSkillTalk = hPSkillTalkDao.getSkill(conn, id);
			if(!hPSkillTalk.getCategory().equals("")){
				hPSkillTalk.setCategory_sub(Arrays.asList(hPSkillTalk.getCategory().split(",")));
				hPSkillTalk.setCategory_sub_size(hPSkillTalk.getCategory_sub().size());
			}else{
				hPSkillTalk.setCategory_sub_size(0);
			}
			return hPSkillTalk;
		} catch (Exception e) {
			throw new RxException("根据id获取单个技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public void updateSkilltalk(String id, String title) {
		try {
			hPSkillTalkDao.updateSkilltalk(conn, id, title);
		} catch (Exception e) {
			throw new RxException("根据id修改单个技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateSkilltalk(String id, String title, File image, String imageFileName) {
		try {
			//先删除旧文件
			String sjkFileName = hPSkillTalkDao.getSkill(conn, id).getImage();
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			File file = new File(ccPath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(sjkFileName)) {
						files[i].delete();
						break;
					}
				}
			}
			String newFileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imageFileName);
			FileUtils.copyFile(image, new File(ccPath+File.separator+newFileName));
			hPSkillTalkDao.updateSkilltalk(conn, id, title, newFileName);
		} catch (Exception e) {
			throw new RxException("根据id修改单个技术交流(带图片更改)时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addSubSkilltalk(String id, String category) {
		try {
			String sjk = hPSkillTalkDao.getSkill(conn, id).getCategory();
			String newCategory = "";
			if (!sjk.equals("")) {
				newCategory = sjk+","+category;
			}else{
				newCategory = category;
			}
			hPSkillTalkDao.addSubSkilltalk(conn, newCategory, id);
		} catch (Exception e) {
			throw new RxException("添加子类技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteSubSkilltalk(String id, String category) {
		try {
			String newCategory = "";
			String str = hPSkillTalkDao.getSkill(conn, id).getCategory();
			String[] categorys = hPSkillTalkDao.getSkill(conn, id).getCategory().split(",");
			for (int i = 0; i < categorys.length; i++) {
				if(categorys[i].equals(category)){
					if(i==0){
						if (categorys.length==1) {
							newCategory = "";
						}else{
							newCategory = str.substring(category.length()+1, str.length());
						}
					}else if(i==categorys.length-1){
						newCategory = str.substring(0, str.length() - category.length()-1);
					}else{
						String s1, s2;
						s1 = str.substring(0, str.indexOf(category)-1);
						s2 = str.substring(str.indexOf(category)+category.length(), str.length());
						newCategory = s1 + s2;
					}
				}
			}
			hPSkillTalkDao.deleteSubSkilltalk(conn, id,  newCategory);
		} catch (Exception e) {
			throw new RxException("删除子类技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addSkilltalk(String title, String category, File image, String imageFileName) {
		try {
			//先上传图片文件
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			String newFileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imageFileName);
			FileUtils.copyFile(image, new File(ccPath+File.separator+newFileName));
			hPSkillTalkDao.addSkilltalk(conn, title, newFileName, category);
		} catch (Exception e) {
			throw new RxException("添加技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteSkilltalk(String id) {
		try {
			//先删除服务器文件
			String sjkFileName = hPSkillTalkDao.getSkill(conn, id).getImage();
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			File file = new File(ccPath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(sjkFileName)) {
						files[i].delete();
						break;
					}
				}
			}
			hPSkillTalkDao.deleteSkilltalk(conn, id);
		} catch (Exception e) {
			throw new RxException("删除技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateHotAnswer(HPHotAnswering hotAnswer) {
		try {
			hPHotAnsweringDao.updateHotAnswer(conn, hotAnswer);
		} catch (Exception e) {
			throw new RxException("修改技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addHotAnswer(HPHotAnswering hotAnswer) {
		try {
			hPHotAnsweringDao.addHotAnswer(conn, hotAnswer);
		} catch (Exception e) {
			throw new RxException("添加技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteHotAnswer(String id) {
		try {
			hPHotAnsweringDao.deleteHotAnswer(conn, id);
		} catch (Exception e) {
			throw new RxException("删除技术交流时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void syHotAnswer(String id, int sy) {
		try {
			hPHotAnsweringDao.syHotAnswer(conn, id, sy);
		} catch (Exception e) {
			throw new RxException("设置技术交流输液显示时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateTrainactive(HPTrainingActivitie trainActive) {
		try {
			hPTrainingActivitieDao.updateTrainactive(conn, trainActive);
		} catch (Exception e) {
			throw new RxException("修改培训与活动时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addTrainactive(HPTrainingActivitie trainActive) {
		try {
			hPTrainingActivitieDao.addTrainactive(conn, trainActive);
		} catch (Exception e) {
			throw new RxException("添加培训与活动时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteTrainactive(String id) {
		try {
			hPTrainingActivitieDao.deleteTrainactive(conn, id);
		} catch (Exception e) {
			throw new RxException("删除培训与活动时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void syTrainactive(String id, int sy) {
		try {
			hPTrainingActivitieDao.syTrainactive(conn, id, sy);
		} catch (Exception e) {
			throw new RxException("设置首页培训与活动时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateNews(News new_) {
		try {
			newsDao.updateNews(conn, new_);
		} catch (Exception e) {
			throw new RxException("修改最新动态时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addNews(News new_) {
		try {
			newsDao.addNews(conn, new_);
		} catch (Exception e) {
			throw new RxException("添加最新动态时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteNews(String id) {
		try {
			newsDao.deleteNews(conn, id);
		} catch (Exception e) {
			throw new RxException("删除最新动态时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public AssociationIntroduce getIntroduce(String id) {
		try {
			return associationIntroduceDao.getIntroduce(conn, id);
		} catch (Exception e) {
			throw new RxException("获取单个协会简介时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateIntroduce(AssociationIntroduce introduce) {
		try {
			associationIntroduceDao.updateIntroduce(conn, introduce);
		} catch (Exception e) {
			throw new RxException("修改单个协会简介时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addBaseInfo(AssociationIntroduce introduce) {
		try {
			associationIntroduceDao.addBaseInfo(conn, introduce);
		} catch (Exception e) {
			throw new RxException("添加单个协会简介时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteBaseInfo(String id) {
		try {
			associationIntroduceDao.deleteBaseInfo(conn, id);
		} catch (Exception e) {
			throw new RxException("删除单个协会简介时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addImgInfo(String imgtitle, File image, String imageFileName) {
		try {
			//先上传文件
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			String newFileName = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(imageFileName);
			FileUtils.copyFile(image, new File(ccPath+File.separator+newFileName));
			associationIntroduceDao.addImgInfo(conn, imgtitle, newFileName);
		} catch (Exception e) {
			throw new RxException("添加单个照片墙时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteImgInfo(String id) {
		try {
			//先删除文件
			String sjkFileName = associationIntroduceDao.getIntroduce(conn, id).getImage();
			String ccPath = ServletActionContext.getServletContext().getRealPath("/")+File.separator+"rx"+File.separator+"images";
			File file = new File(ccPath);
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].getName().equals(sjkFileName)) {
						files[i].delete();
						break;
					}
				}
			}
			associationIntroduceDao.deleteImgInfo(conn, id);
		} catch (Exception e) {
			throw new RxException("删除单个照片墙时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public DepartmentStyle getStylesDg(String belong, int flag) {
		try {
			return departmentStyleDao.getStylesDg(conn, belong, flag);
		} catch (Exception e) {
			throw new RxException("根据belong和falg获取单个部门风采时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public DepartmentStyle getStyle(String id) {
		try {
			return departmentStyleDao.getStyle(conn, id);
		} catch (Exception e) {
			throw new RxException("根据id获取单个部门风采时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void updateZc(DepartmentStyle style) {
		try {
			departmentStyleDao.updateZc(conn, style);
		} catch (Exception e) {
			throw new RxException("根据id修改【父】部门风采时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void addSubZc(DepartmentStyle style) {
		try {
			departmentStyleDao.addSubZc(conn, style);
		} catch (Exception e) {
			throw new RxException("根据【子】部门风采时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public void deleteSubZc(String id) {
		try {
			departmentStyleDao.deleteSubZc(conn, id);
		} catch (Exception e) {
			throw new RxException("根据id删除【子】部门风采时出现异常！");
		}
	}

	/**
	 * 跳到修改【联系我们】页面
	 * @param id
	 * @return
	 */
	@Transcation(readOnly=true)
	public Contact getContact(String id) {
		try {
			return contactDao.getContact(conn, id);
		} catch (Exception e) {
			throw new RxException("根据id获取联系方式时出现异常！");
		}
	}

	/**
	 * 修改【联系我们】信息
	 * @param contactSub
	 */
	@Transcation(readOnly=false)
	public void updateContact(ContactSub contactSub) {
		try {
			contactDao.updateContact(conn, contactSub);
		} catch (Exception e) {
			throw new RxException("根据id修改联系方式时出现异常！");
		}
	}

	/**
	 * 【联系我们】添加分类
	 * @param category
	 * @param title
	 * @param content
	 */
	@Transcation(readOnly=false)
	public void addFl(String category, String title, String content) {
		try {
			contactDao.addContact(conn, category);
			int maxId = contactDao.getContactId(conn);
			contactDao.addSubContact(conn, title, content, maxId);
		} catch (Exception e) {
			throw new RxException("【联系方式】添加分类时出现异常！");
		}
	}

	/**
	 * 添加子内容
	 * @param belongId
	 * @param title
	 * @param content
	 */
	@Transcation(readOnly=false)
	public void addBt(String belongId, String title, String content) {
		try {
			contactDao.addSubContact(conn, title, content, Integer.valueOf(belongId));
		} catch (Exception e) {
			throw new RxException("【联系方式】添加标题时出现异常！");
		}
	}

	/**
	 * 删除子分类
	 * @param id
	 * @param belongId
	 */
	@Transcation(readOnly=false)
	public void deleteSubContact(String id, String belongId) {
		try {
			contactDao.deleteSubContact(conn, id);
			int count = contactDao.getContactCount(conn, belongId);
			if (count<1) {
				contactDao.deleteContact(conn, belongId);
			}
		} catch (Exception e) {
			throw new RxException("【联系方式】删除标题时出现异常！");
		}
	}

	
	
	/**
	 * 获取所有的【联系我们】
	 * @return
	 */
	@Transcation(readOnly=true)
	public List<Contact> getAllContact() {
		try {
			return contactDao.getAllContact(conn);
		} catch (Exception e) {
			throw new RxException("...时出现异常！");
		}
	}

	/**
	 * 设置是否置顶
	 */
	@Transcation(readOnly=false)
	public void setZd(int zd, int id) {
		try {
			bbsDao.setZd(conn, zd, id);
		} catch (Exception e) {
			throw new RxException("设置是否置顶时出现异常！");
		}
		
	}

	/**
	 * 删除帖子
	 * @param id
	 */
	@Transcation(readOnly=false)
	public void deleteTz(String id) {
		try {
			bbsDao.deleteTz(conn, id);
		} catch (Exception e) {
			throw new RxException("删除帖子时出现异常！");
		}
	}



}
