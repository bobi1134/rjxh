package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import cn.rjxh.dao.BBSDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.Remark;
import cn.rjxh.dto.SubRemark;
import cn.rjxh.dto.Tz;
import cn.rjxh.dto.User;
import cn.rjxh.utils.consts.WebConstant;
import cn.rjxh.utils.page.PageModel;

public class BBSDaoImpl implements BBSDao {

	/**
	 * 【用户】展示所有帖子
	 * @param conn
	 * @param pageModel
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Tz> getTz(Connection conn, PageModel pageModel)throws SQLException {
		String sql = "select * from t_bbs_tz as a inner join t_user as b on a.userId = b.id order by a.zd, a.date desc";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.queryByPage(conn, sql, null, pageModel, new ResultSetHandler<List<Tz>>() {
			@Override
			public List<Tz> execute(ResultSet rs) throws SQLException {
				List<Tz> tzs = new ArrayList<Tz>();
				while (rs.next()) {
					Tz tz = new Tz();
					tz.setId(rs.getInt("id"));
					tz.setTitle(rs.getString("title"));
					tz.setMessage(rs.getString("content"));
					tz.setDate(rs.getTimestamp("date"));
					tz.setZd(rs.getInt("zd"));
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					tz.setUser(user);
					tzs.add(tz);
				}
				return tzs;
			}
		});
	}

	/**
	 * 添加帖子
	 * @param conn
	 * @param title
	 * @param content
	 * @return
	 * @throws SQLException
	 */
	@Override
	public void addTz(Connection conn, String title, String content, int userId)throws SQLException {
		String sql = "insert into t_bbs_tz (title,content,date,zd,userId) values(?,?,?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{title,content,new Date(),2,userId});
	}

	/**
	 * 根据id获取相应的帖子
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Tz getTzById(Connection conn, String id) throws SQLException {
		String sql = "select * from t_bbs_tz as a inner join t_user as b on a.userId = b.id where a.id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<Tz>() {
			@Override
			public Tz execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					Tz tz = new Tz();
					tz.setId(rs.getInt("id"));
					tz.setTitle(rs.getString("title"));
					tz.setMessage(rs.getString("content"));;
					tz.setDate(rs.getTimestamp("date"));
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					tz.setUser(user);
					return tz;
				}
				return null;
			}
		});
	}

	/**
	 * 根据帖子id获取该帖子的所有一级评论
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Remark> getTzRemark(Connection conn, String id, PageModel pageModel)	throws SQLException {
		String sql = "select * from t_bbs_remark as a inner join t_bbs_tz as b on a.tzId = b.id inner join t_user as c on a.userId = c.id where b.id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.queryByPage(conn, sql, new Object[]{Integer.valueOf(id)}, pageModel, new ResultSetHandler<List<Remark>>() {
			@Override
			public List<Remark> execute(ResultSet rs) throws SQLException {
				List<Remark> remarks = new ArrayList<Remark>();
				while (rs.next()) {
					Remark remark = new Remark();
					remark.setId(rs.getInt("id"));
					remark.setContent(rs.getString("content"));
					remark.setDate(rs.getTimestamp("date"));
					remark.setUserId(rs.getInt("userId"));
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					remark.setUser(user);
					remarks.add(remark);
				}
				return remarks;
			}
		});
	}

	/**
	 * 根据帖子id获取该帖子的所有二级评论
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<SubRemark> getSubRemark(Connection conn, int id)throws SQLException {
		
		String sql = "select * from t_bbs_subremark as a inner join t_bbs_remark as b on a.remarkId = b.id inner join t_user as c on a.userId = c.id where a.remarkId =?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<List<SubRemark>>() {
			@Override
			public List<SubRemark> execute(ResultSet rs) throws SQLException {
				List<SubRemark> subRemarks = new ArrayList<SubRemark>();
				while (rs.next()) {
					SubRemark subRemark = new SubRemark();
					subRemark.setId(rs.getInt("id"));
					subRemark.setContent(rs.getString("content"));
					subRemark.setDate(rs.getTimestamp("date"));
					subRemark.setRemarkUser(rs.getString("remarkUser"));
					subRemark.setUserId(rs.getInt("userId"));
					subRemark.setRemarkUserId(rs.getInt("remarkUserId"));
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					subRemark.setUser(user);
					subRemarks.add(subRemark);
				}
				return subRemarks;
			}
		});
	}

	/**
	 * 添加一级评论
	 * @param id
	 * @param content
	 * @throws SQLException
	 */
	@Override
	public void addRemark(Connection conn, String id, String remarkContent) throws SQLException {
		String sql = "insert into t_bbs_remark (content, date, userId, tzId) values(?,?,?,?)";
		User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
		new QueryRunner().update(conn, sql, new Object[]{remarkContent, new Date(), user.getId(), Integer.valueOf(id)});
	}

	/**
	 * 根据回复id来查询该用户的username和nickname，要存进t_bbs_subremark表数据库中的！
	 * @param conn
	 * @param hfUserId
	 * @return
	 * @throws SQLException
	 */
	@Override
	public User getHfUser(Connection conn, String hfUserId) throws SQLException {
		String sql = "select * from t_user where id = ?";
		QueryRunner queryRunner = new QueryRunner(); 
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(hfUserId)}, new ResultSetHandler<User>() {
			@Override
			public User execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					User user = new User();
					user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					return user;
				}
				return null;
			}
		});
	}

	@Override
	public void addSubRemark(Connection conn, String nickname_username, String hfUserId, String remarkId, String subRemarkContent) throws SQLException {
		String sql = "insert into t_bbs_subremark (content, date, remarkUser, remarkUserId, userId, remarkId) values(?,?,?,?,?,?)";
		User user = (User)ActionContext.getContext().getSession().get(WebConstant.SESSION_USER);
		new QueryRunner().update(conn, sql, new Object[]{subRemarkContent,
														 new Date(),
														 nickname_username,
														 Integer.valueOf(hfUserId),
														 user.getId(),
														 Integer.valueOf(remarkId)});
	}

	@Override
	public void setZd(Connection conn, int zd, int id) throws SQLException {
		String sql = "update t_bbs_tz set zd = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{zd, id});
	}

	/**
	 * 删除帖子
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	@Override
	public void deleteTz(Connection conn, String id) throws SQLException {
		String sql = "delete from t_bbs_tz where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}


}
