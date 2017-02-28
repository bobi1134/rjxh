package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.Contact;
import cn.rjxh.dto.ContactSub;

public interface ContactDao {

//	List<Contact> getContact(Connection conn, boolean group)throws SQLException;

	/**
	 * 跳到修改【联系我们】页面
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	Contact getContact(Connection conn, String id)throws SQLException;

	/**
	 * 修改【联系我们】信息
	 * @param conn
	 * @param contactSub
	 * @throws SQLException
	 */
	void updateContact(Connection conn, ContactSub contactSub)throws SQLException;

	void addContact(Connection conn, String category)throws SQLException;

	int getContactId(Connection conn)throws SQLException;

	/**
	 * 【联系我们】添加分类
	 * @param conn
	 * @param title
	 * @param content
	 * @param maxId
	 * @throws SQLException
	 */
	void addSubContact(Connection conn, String title, String content, int maxId)throws SQLException;

	void deleteSubContact(Connection conn, String id)throws SQLException;

	int getContactCount(Connection conn, String id)throws SQLException;

	/**
	 * 删除子分类
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	void deleteContact(Connection conn, String id)throws SQLException;

	/**
	 * 获取父类【联系我们子类】信息
	 * @return
	 */
	List<ContactSub> getSubContact(Connection conn)throws SQLException;

	/**
	 * 获取所有Banner图
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<Contact> getParentContact(Connection conn)throws SQLException;

	
	/**
	 * 获取所有的【联系我们】
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<Contact> getAllContact(Connection conn)throws SQLException;



}
