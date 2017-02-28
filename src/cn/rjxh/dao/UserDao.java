package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.User;
import cn.rjxh.utils.page.PageModel;

public interface UserDao {

	User login(Connection conn, User user)throws SQLException;

	List<User> getUser(Connection conn, PageModel pageModel, User searchuser)throws SQLException;

	User getUser(Connection conn, int id)throws SQLException;

	void updateUser(Connection conn, User updateuser)throws SQLException;

	void addUser(Connection conn, User adduser)throws SQLException;

	void deleteUser(Connection conn, String deleteId)throws SQLException;

	void registerUser(Connection conn, User registerUser)throws SQLException;

	void updateSelfUser(Connection conn, User updateuser)throws SQLException;

	List<User> getAllUser(Connection conn)throws SQLException;


}
