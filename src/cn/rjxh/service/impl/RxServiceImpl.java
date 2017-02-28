package cn.rjxh.service.impl;

import java.sql.Connection;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import net.sf.json.JSONObject;
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
import cn.rjxh.dto.Remark;
import cn.rjxh.dto.SubRemark;
import cn.rjxh.dto.Tz;
import cn.rjxh.dto.User;
import cn.rjxh.exception.RxException;
import cn.rjxh.service.RxService;
import cn.rjxh.service.proxy.Transcation;
import cn.rjxh.utils.consts.WebConstant;
import cn.rjxh.utils.page.PageModel;

public class RxServiceImpl implements RxService {
	
	private Connection conn;
	public void setConnection(Connection connection){
		this.conn = connection;
	}
	
	/** index.jsp */
	private HPBannerDao hPBannerDao;
	private HPSkillTalkDao hPSkillTalkDao;
	private HPHotAnsweringDao hPHotAnsweringDao;
	private HPTrainingActivitieDao hPTrainingActivitieDao;
	/** introduce.jsp */
	private AssociationIntroduceDao associationIntroduceDao;
	private NewsDao newsDao;
	/*********style.jsp*********/
	private DepartmentStyleDao departmentStyleDao;
	/*********contact.jsp*********/
	private ContactDao contactDao;
	private BBSDao bbsDao;
	private UserDao userDao;
	public RxServiceImpl(){
		hPBannerDao = new HPBannerDaoImpl();
		hPSkillTalkDao = new HPSkillTalkDaoImpl();
		hPHotAnsweringDao = new HPHotAnsweringDaoImpl();
		hPTrainingActivitieDao = new HPTrainingActivitieDaoImpl(); 
		
		associationIntroduceDao = new AssociationIntroduceDaoImpl();
		newsDao = new NewsDaoImpl();
		
		departmentStyleDao = new DepartmentStyleDaoImpl();
		
		contactDao = new ContactDaoImpl();
		bbsDao = new BBSDaoImpl();
		userDao = new UserDaoImpl();
	}
	

	/*********index.jsp*********/
	/**
	 * 获取所有Banner图
	 */
	@Transcation(readOnly=true)
	public List<HPBanner> getBanners() {
		try {
			return hPBannerDao.getBanners(conn);
		} catch (Exception e) {
			throw new RxException("index.jsp-->获取banner图时出现异常！");
		}
	}
	
	@Transcation(readOnly=true)
	public List<HPSkillTalk> getSkills() {
		try {
			List<HPSkillTalk> skills = hPSkillTalkDao.getSkills(conn);
			for(HPSkillTalk skill : skills){
				skill.setCategory_sub(Arrays.asList(skill.getCategory().split(",")));
				skill.setCategory_sub_size(skill.getCategory_sub().size());
			}
			return skills;
		} catch (Exception e) {
			throw new RxException("index.jsp-->获取技术交流模块时出现异常！");
		}
	}
	
	@Transcation(readOnly=true)
	public List<HPHotAnswering> getHotAnswerings() {
		try {
			return hPHotAnsweringDao.getHotAnswerings(conn);
		} catch (Exception e) {
			throw new RxException("index.jsp-->获取热点答疑模块时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public List<HPTrainingActivitie> getTrainingActivities() {
		try {
			return hPTrainingActivitieDao.getTrainingActivities(conn);
		} catch (Exception e) {
			throw new RxException("index.jsp-->获取培训和活动模块时出现异常！");
		}
	}

	
	/*********introduce.jsp*********/
	@Transcation(readOnly=true)
	public List<AssociationIntroduce> getAssociationIntroduces(PageModel pageModel) {
		try {
			return associationIntroduceDao.getAssociationIntroduces(conn, pageModel);
		} catch (Exception e) {
			throw new RxException("introduce.jsp-->获取部门【文字】简介模块时出现异常！");
		}
	}

	@Override
	public List<AssociationIntroduce> getAssociationImgIntroduces() {
		try {
			return associationIntroduceDao.getAssociationImgIntroduces(conn);
		} catch (Exception e) {
			throw new RxException("introduce.jsp-->获取部门【图片】简介模块时出现异常！");
		}
	}

	/*********style.jsp*********/
	@Transcation(readOnly=true)
	public List<DepartmentStyle> getStyles(String belong, int flag) {
		try {
			return departmentStyleDao.getStyles(conn, belong, flag);
		} catch (Exception e) {
			throw new RxException("style.jsp-->获取部分风采时出现异常！");
		}
	}


	/*********news_content.jsp*********/
	@Transcation(readOnly=true)
	public List<News> getNews(PageModel pageModel) {
		try {
			return newsDao.getNews(conn, pageModel);
		} catch (Exception e) {
			throw new RxException("introduce.jsp-->获取照片墙模块时出现异常！");
		}
	}
	
	@Transcation(readOnly=true)
	public News getNew_(String id) {
		try {
			return newsDao.getNew_(conn, id);
		} catch (Exception e) {
			throw new RxException("news_content.jsp-->根据id获取文章时出现异常！");
		}
	}

	@Transcation(readOnly=false)
	public String addzan(String id,  String clientIp) {
		try {
			JSONObject json = new JSONObject();
			News new_ = newsDao.getNew_(conn, id);
			int zan_num_new = new_.getZan_num()+1;
			String clientIp_new = new_.getIp()+","+clientIp; 
			newsDao.addzan(conn, id, zan_num_new, clientIp_new.toString());
			json.put("flag", true);
			return json.toString();
		} catch (Exception e) {
			throw new RxException("news_content.jsp-->异步加赞时出现异常！");
		}
	}
	
	@Transcation(readOnly=true)
	public int getMaxId() {
		try {
			return newsDao.getMaxId(conn);
		} catch (Exception e) {
			throw new RxException("news.jsp-->获取MaxId时出现异常！");
		}
	}


	/*********contact.jsp*********/
//	@Transcation(readOnly=true)
//	public List<Contact> getContact(boolean group) {
//		try {
//			return contactDao.getContact(conn, group);
//		} catch (Exception e) {
//			throw new RxException("contact.jsp-->获取所有联系方式时出现异常！");
//		}
//	}

	/************hotanswering.jsp************/
	@Transcation(readOnly=true)
	public List<HPHotAnswering> getHotAnswerings(PageModel pageModel, String px) {
		try {
			return  hPHotAnsweringDao.getHotAnswerings(conn, pageModel, px);
		} catch (Exception e) {
			throw new RxException("hotanswering.jsp-->获取所有热点答疑时出现异常！");
		}
	}


	@Transcation(readOnly=true)
	public HPHotAnswering getHotAnswerContent(String id) {
		try {
			return  hPHotAnsweringDao.getHotAnswerContent(conn, id);
		} catch (Exception e) {
			throw new RxException("hotanswering.jsp-->根据id获取相应的热点答疑时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public List<HPTrainingActivitie> getTrainActives(PageModel pageModel, String px) {
		try {
			return hPTrainingActivitieDao.getTrainActives(conn, pageModel, px);
		} catch (Exception e) {
			throw new RxException("trainactive.jsp-->获取所有培训活动时出现异常！");
		}
	}

	@Transcation(readOnly=true)
	public HPTrainingActivitie getTrainActiveContent(String id) {
		try {
			return  hPTrainingActivitieDao.getTrainActiveContent(conn, id);
		} catch (Exception e) {
			throw new RxException("trainactive.jsp-->根据id获取相应的培训活动时出现异常！");
		}
	}


	/***论坛***/
	/**
	 * 【用户】展示所有帖子
	 * @param pageModel
	 * @return
	 */
	@Transcation(readOnly=true)
	public List<Tz> getTz(PageModel pageModel) {
		try {
			return  bbsDao.getTz(conn, pageModel);
		} catch (Exception e) {
			throw new RxException("展示所有帖子时出现异常！");
		}
	}

	/**
	 * 添加帖子
	 * @param title
	 * @param content
	 */
	@Transcation(readOnly=false)
	public void addTz(String title, String content, int userId) {
		try {
			bbsDao.addTz(conn, title, content, userId);
		} catch (Exception e) {
			throw new RxException("添加帖子时出现异常！");
		}
	}


	/**
	 * 根据id获取该帖的相关信息
	 * @param id
	 * @return
	 */
	@Transcation(readOnly=true)
	public Tz getTzById(String id) {
		try {
			return bbsDao.getTzById(conn, id);
		} catch (Exception e) {
			throw new RxException("根据id获取帖子时出现异常！");
		}
	}


	/**
	 * 根据帖子id获取该帖子的所有一级评论，二级评论
	 * @param id
	 * @return
	 */
	@Transcation(readOnly=true)
	public List<Remark> getTzRemark(String id, PageModel pageModel) {
		try {
			//现获取一级评论
			List<Remark> remarks = bbsDao.getTzRemark(conn, id, pageModel);
			//获取二级评论
			for (Remark remark : remarks) {
				remark.setSubRemarks(bbsDao.getSubRemark(conn, remark.getId()));
			}
			for (Remark remark : remarks) {
				List<SubRemark> subRemarks = remark.getSubRemarks();
				for (SubRemark subRemark : subRemarks) {
					System.out.println(""+subRemark.getRemarkUser()+","+subRemark.getRemarkUserId());
					User user = bbsDao.getHfUser(conn, String.valueOf(subRemark.getRemarkUserId()));
					if (!user.getNickname().equals("")) {
						subRemark.setRemarkUser(user.getNickname());
					}else{
						subRemark.setRemarkUser(user.getUsername());
					}
				}
			}
			
			return remarks;
		} catch (Exception e) {
			throw new RxException("根据帖子id获取该帖子的所有一级评论，二级评论时出现异常！");
		}
	}


	/**
	 * 添加一级评论
	 * @param id
	 */
	@Transcation(readOnly=false)
	public void addRemark(String id, String remarkContent) {
		try {
			bbsDao.addRemark(conn, id, remarkContent);
		} catch (Exception e) {
			throw new RxException("根据帖子id添加一级评论时出现异常！");
		}
	}


	/**
	 * 异步添加二级评论
	 * @param hfUserId
	 * @param subRemarkCoent
	 * @return
	 */
	@Transcation(readOnly=false)
	public String addSubRemark(String remarkId, String hfUserId, String subRemarkContent) {
		try {
			System.out.println("remarkId:"+remarkId);
			System.out.println("hfUserId:"+hfUserId);
			System.out.println("subRemarkContent:"+subRemarkContent);
			
			JSONObject json = new JSONObject();
			//先查询hfUserId的username和nickname
			User user = bbsDao.getHfUser(conn, hfUserId);
			if (!user.getNickname().equals("")) {
				bbsDao.addSubRemark(conn, user.getNickname(), hfUserId, remarkId, subRemarkContent);
				json.put("name", user.getNickname());
			}else{
				bbsDao.addSubRemark(conn, user.getUsername(), hfUserId, remarkId, subRemarkContent);
				json.put("name", user.getUsername());
			}
			json.put("tcFlag", "");
			json.put("loginFlag", "");
			return json.toString();
		} catch (Exception e) {
			throw new RxException("异步添加二级评论时出现异常！");
		}
	}


	/**
	 * 获取父类【联系我们子类】信息
	 * @return
	 */
	@Transcation(readOnly=true)
	public List<ContactSub> getSubContact() {
		try {
			return contactDao.getSubContact(conn);
		} catch (Exception e) {
			throw new RxException("...时出现异常！");
		}
	}
	
	/**
	 * 获取父类【联系我们】信息
	 * @return
	 */
	@Transcation(readOnly=true)
	public List<Contact> getParentContact() {
		try {
			return contactDao.getParentContact(conn);
		} catch (Exception e) {
			throw new RxException("...时出现异常！");
		}
	}


	/**
	 * 异步注册用户
	 * @param registerUser
	 * @return
	 */
	@Transcation(readOnly=false)
	public String registerUser(User registerUser, String yzm) {
		try {
			JSONObject json = new JSONObject();
			//先判断username和password是否为空
			System.out.println("registerUser.getUsername():"+registerUser.getUsername());
			if(registerUser.getUsername().equals("")){
				System.out.println("1");
				json.put("input_username", "kong");
			}else if(registerUser.getPassword().equals("")){
				System.out.println("2");
				json.put("input_password", "kong");
			}else if(yzm.equals("")){
				System.out.println("3");
				json.put("input_yzm", "kong");
			}else{
				//再校验用户是否存在！
				System.out.println("注册username："+registerUser.getUsername());
				List<User> users = userDao.getAllUser(conn);
				boolean flag = true;
				for (User u : users) {
					if (registerUser.getUsername().equals(u.getUsername())) {
						json.put("exist", "true");
						//有一个存在都不能注册
						flag = false;
					}
				}
				if(flag == true){
					//最后判断验证码
					String oldCode = (String)ActionContext.getContext().getSession().get(WebConstant.VERIFY_CODE);
					if (yzm.equals(oldCode)) {
						userDao.registerUser(conn, registerUser);
						json.put("zc", "ok");
					}else{
						json.put("yzm", "error");
					}
				}
			}
			return json.toString();
		} catch (Exception e) {
			throw new RxException("注册用户时出现异常！");
		}
	}


	@Transcation(readOnly=false)
	public void updateSelfUser(User updateuser) {
		try {
			userDao.updateSelfUser(conn, updateuser);
		} catch (Exception e) {
			throw new RxException("...时出现异常！");
		}
		
	}


	


	




	


	
	
	
	
}
