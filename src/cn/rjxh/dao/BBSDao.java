package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.Remark;
import cn.rjxh.dto.SubRemark;
import cn.rjxh.dto.Tz;
import cn.rjxh.dto.User;
import cn.rjxh.utils.page.PageModel;

public interface BBSDao {

	/**
	 * 【用户】展示所有帖子
	 * @param conn
	 * @param pageModel
	 * @return
	 * @throws SQLException
	 */
	List<Tz> getTz(Connection conn, PageModel pageModel)throws SQLException;

	/**
	 * 添加帖子
	 * @param conn
	 * @param title
	 * @param content
	 * @return
	 * @throws SQLException
	 */
	void addTz(Connection conn, String title, String content, int userId)throws SQLException;

	/**
	 * 根据id获取相应的帖子
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Tz getTzById(Connection conn, String id)throws SQLException;

	/**
	 * 根据帖子id获取该帖子的所有一级评论
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<Remark> getTzRemark(Connection conn, String id, PageModel pageModel)throws SQLException;

	/**
	 * 根据帖子id获取该帖子的所有二级评论
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	List<SubRemark> getSubRemark(Connection conn, int id)throws SQLException;

	/**
	 * 添加一级评论
	 * @param id
	 * @param content
	 * @throws SQLException
	 */
	void addRemark(Connection conn, String id, String remarkContent)throws SQLException;

	/**
	 * 根据回复id来查询该用户的username和nickname，要存进t_bbs_subremark表数据库中的！
	 * @param conn
	 * @param hfUserId
	 * @return
	 * @throws SQLException
	 */
	User getHfUser(Connection conn, String hfUserId)throws SQLException;

	/**
	 * 添加二级评论
	 * @param conn
	 * @param nickname
	 * @param hfUserId
	 * @param remarkId
	 * @throws SQLException
	 */
	void addSubRemark(Connection conn, String nickname_username, String hfUserId, String remarkId, String subRemarkContent)throws SQLException;

	/**
	 * 设置是否置顶
	 * @param conn
	 * @param zd
	 * @param id
	 * @throws SQLException
	 */
	void setZd(Connection conn, int zd, int id)throws SQLException;

	/**
	 * 删除帖子
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	void deleteTz(Connection conn, String id)throws SQLException;

}
