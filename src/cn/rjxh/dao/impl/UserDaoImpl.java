package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;





import java.util.ArrayList;
import java.util.List;

import cn.rjxh.dao.UserDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.User;
import cn.rjxh.utils.page.PageModel;

public class UserDaoImpl implements UserDao{

	@Override
	public User login(Connection connection, User user) throws SQLException {
		String sql = "select * from t_user where BINARY(username) = ? and BINARY(password) = ? ";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(connection, sql, new Object[]{user.getUsername(), user.getPassword()}, new ResultSetHandler<User>() {

			@Override
			public User execute(ResultSet rs) throws SQLException {
				User user = new User();
				if(rs.next()) {
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setNickname(rs.getString("nickname"));
					user.setEmail(rs.getString("email"));
					user.setSex(rs.getInt("sex"));
					user.setAcademe(rs.getString("academe"));
					user.setGrade(rs.getString("grade"));
					user.setHobby(rs.getString("hobby"));
					user.setRemark(rs.getString("remark"));
					user.setRole(rs.getShort("role"));
					return user;
				}
				return null;
			}
			
		});
		
	}

	@Override
	public List<User> getUser(Connection conn, PageModel pageModel, User searchuser) throws SQLException {
		String sql = "select * from t_user where 1 = 1";
		List<Object> params = new ArrayList<Object>();
		if(searchuser.getUsername()!=null){
			sql = sql + " and username like ?";
			params.add("%" + searchuser.getUsername() + "%");
		}
		if(searchuser.getNickname()!=null){
			sql = sql + " and nickname like ?";
			params.add("%" + searchuser.getNickname() + "%");
		}
		if(searchuser.getAcademe()!=null){
			sql = sql + " and academe like ?";
			params.add("%" + searchuser.getAcademe() + "%");
		}
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.queryByPage(conn, sql, params.toArray(), pageModel, new ResultSetHandler<List<User>>() {
			@Override
			public List<User> execute(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setNickname(rs.getString("nickname"));
					user.setEmail(rs.getString("email"));
					user.setSex(rs.getInt("sex"));
					user.setAcademe(rs.getString("academe"));
					user.setGrade(rs.getString("grade"));
					user.setHobby(rs.getString("hobby"));
					user.setRemark(rs.getString("remark"));
					user.setRole(rs.getShort("role"));
					users.add(user);
				}
				return users;
			}
		});
	}

	@Override
	public User getUser(Connection conn, int id) throws SQLException {
		String sql = "select * from t_user where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{id}, new ResultSetHandler<User>() {
			@Override
			public User execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					user.setNickname(rs.getString("nickname"));
					user.setEmail(rs.getString("email"));
					user.setSex(rs.getInt("sex"));
					user.setAcademe(rs.getString("academe"));
					user.setGrade(rs.getString("grade"));
					user.setHobby(rs.getString("hobby"));
					user.setRemark(rs.getString("remark"));
					user.setRole(rs.getShort("role"));
					return user;
				}
				return null;
			}
		});
	}

	@Override
	public void updateUser(Connection conn, User updateuser) throws SQLException {
		String sql = "update t_user set password = ?, nickname = ?, email = ?, sex = ?, academe = ?, grade = ?, hobby = ?, remark = ?, role = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{updateuser.getPassword(),
														 updateuser.getNickname(),
														 updateuser.getEmail(),
														 updateuser.getSex(),
														 updateuser.getAcademe(),
														 updateuser.getGrade(),
														 updateuser.getHobby(),
														 updateuser.getRemark(),
														 updateuser.getRole(),
														 updateuser.getId()});
	}

	@Override
	public void addUser(Connection conn, User adduser) throws SQLException {
		String sql = "insert into t_user (username, password, nickname, email, sex, academe, grade, hobby, remark, role) values(?,?,?,?,?,?,?,?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{adduser.getUsername(),
													     adduser.getPassword(),
													     adduser.getNickname(),
													     adduser.getEmail(),
													     Integer.valueOf(adduser.getSex()),
													     adduser.getAcademe(),
													     adduser.getGrade(),
													     adduser.getHobby(),
													     adduser.getRemark(),
													     Integer.valueOf(adduser.getRole())});
	}

	@Override
	public void deleteUser(Connection conn, String deleteId)throws SQLException {
		String sql = "delete from t_user where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(deleteId)});
	}

	@Override
	public void registerUser(Connection conn, User registerUser)throws SQLException {
		String sql = "insert into t_user (username, password, role) values(?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{registerUser.getUsername(), registerUser.getPassword(), 2});
	}

	
	@Override
	public void updateSelfUser(Connection conn, User updateuser) throws SQLException {
		String sql = "update t_user set password = ?, nickname = ?, email = ?, sex = ?, academe = ?, grade = ?, hobby = ?, remark = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{updateuser.getPassword(),
														 updateuser.getNickname(),
														 updateuser.getEmail(),
														 updateuser.getSex(),
														 updateuser.getAcademe(),
														 updateuser.getGrade(),
														 updateuser.getHobby(),
														 updateuser.getRemark(),
														 updateuser.getId()});
	}

	@Override
	public List<User> getAllUser(Connection conn) throws SQLException {
		String sql = "select * from t_user";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<User>>() {
			@Override
			public List<User> execute(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				while (rs.next()) {
					User user = new User();
					user.setUsername(rs.getString("username"));
					users.add(user);
				}
				return users;
			}
		});
	}

}
