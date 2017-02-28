package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.rjxh.dao.ContactDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.Contact;
import cn.rjxh.dto.ContactSub;

public class ContactDaoImpl implements ContactDao {

//	@Override
//	public List<Contact> getContact(Connection conn, boolean group) throws SQLException {
//		String sql = "select * from t_contact_sub as b inner join t_contact as a on a.id = b.belongId";
//		if (group == true) {
//			sql = sql + " group by b.belongId";
//		}else{
//			sql = sql + "  order by b.belongId asc";
//		}
//		QueryRunner queryRunner = new QueryRunner();
//		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<Contact>>() {
//			@Override
//			public List<Contact> execute(ResultSet rs) throws SQLException {
//				List<Contact> contacts = new ArrayList<Contact>();
//				while (rs.next()) {
//					Contact contact = new Contact();
//					contact.setId(rs.getInt("id"));
//					contact.setCategory(rs.getString("category"));
//					ContactSub contactSub = new ContactSub();
//					contactSub.setId(rs.getInt("id"));
//					contactSub.setTitle(rs.getString("title"));
//					contactSub.setContent(rs.getString("content"));
//					contactSub.setBelongId(rs.getInt("belongId"));
//					contact.setContactSub(contactSub);
//					contacts.add(contact);
//				}
//				return contacts;
//			}
//		});
//	}

	/**
	 * 跳到修改【联系我们】页面
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	@Override
	public Contact getContact(Connection conn, String id) throws SQLException {
		String sql = "select * from t_contact_sub as b inner join t_contact as a on a.id = b.belongId where b.id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<Contact>() {
			@Override
			public Contact execute(ResultSet rs) throws SQLException {
				while (rs.next()) {
					Contact contact = new Contact();
					contact.setId(rs.getInt("id"));
					contact.setCategory(rs.getString("category"));
					ContactSub contactSub = new ContactSub();
					contactSub.setId(rs.getInt("id"));
					contactSub.setTitle(rs.getString("title"));
					contactSub.setContent(rs.getString("content"));
					contactSub.setBelongId(rs.getInt("belongId"));
					contact.setContactSub(contactSub);
					return contact;
				}
				return null;
			}
		});
	}

	/**
	 * 修改【联系我们】信息
	 * @param conn
	 * @param contactSub
	 * @throws SQLException
	 */
	@Override
	public void updateContact(Connection conn, ContactSub contactSub)throws SQLException {
		String sql = "update t_contact_sub set title = ?, content = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{contactSub.getTitle(), contactSub.getContent(), Integer.valueOf(contactSub.getId())});
	}

	@Override
	public void addContact(Connection conn, String category)throws SQLException {
		String sql = "insert into t_contact (category) values(?)";
		new QueryRunner().update(conn, sql, new Object[]{category});
	}

	@Override
	public int getContactId(Connection conn) throws SQLException {
		String sql = "select MAX(id) from t_contact";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<Integer>() {
			@Override
			public Integer execute(ResultSet rs) throws SQLException {
				int count = 0;
				if (rs.next()) {
					count = rs.getInt(1);
				}
				return count;
			}
		});
	}

	/**
	 * 【联系我们】添加分类
	 * @param conn
	 * @param title
	 * @param content
	 * @param maxId
	 * @throws SQLException
	 */
	@Override
	public void addSubContact(Connection conn, String title, String content, int maxId)throws SQLException {
		String sql = "insert into t_contact_sub (title, content, belongId) values(?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{title, content, maxId});
	}

	@Override
	public void deleteSubContact(Connection conn, String id)throws SQLException {
		String sql = "delete from t_contact_sub where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

	@Override
	public int getContactCount(Connection conn, String id) throws SQLException {
		String sql = "select * from t_contact_sub where belongId = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<Integer>() {
			@Override
			public Integer execute(ResultSet rs) throws SQLException {
				int count = 0;
				while (rs.next()) {
					count ++;
				}
				return count;
			}
		});
	}

	/**
	 * 删除子分类
	 * @param conn
	 * @param id
	 * @throws SQLException
	 */
	@Override
	public void deleteContact(Connection conn, String id) throws SQLException {
		String sql = "delete from t_contact where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

	
	//修改后的
	/**
	 * 获取父类【联系我们子类】信息
	 * @return
	 */
	@Override
	public List<ContactSub> getSubContact(Connection conn) throws SQLException {
		String sql = "select * from t_contact_sub order by belongId asc";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<ContactSub>>() {
			@Override
			public List<ContactSub> execute(ResultSet rs) throws SQLException {
				List<ContactSub> contactSubs = new ArrayList<ContactSub>();
				while (rs.next()) {
					ContactSub contactSub = new ContactSub();
					contactSub.setId(rs.getInt("id"));
					contactSub.setTitle(rs.getString("title"));
					contactSub.setContent(rs.getString("content"));
					contactSub.setBelongId(rs.getInt("belongId"));
					contactSubs.add(contactSub);
				}
				return contactSubs;
			}
		});
	}
	
	/**
	 * 获取所有Banner图
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Contact> getParentContact(Connection conn) throws SQLException {
		String sql = "select * from t_contact order by id asc";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<Contact>>() {
			@Override
			public List<Contact> execute(ResultSet rs) throws SQLException {
				List<Contact> contacts = new ArrayList<Contact>();
				while (rs.next()) {
					Contact contact = new Contact();
					contact.setId(rs.getInt("id"));
					contact.setCategory(rs.getString("category"));
					contacts.add(contact);
				}
				return contacts;
			}
		});
	}

	/**
	 * 获取所有的【联系我们】
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<Contact> getAllContact(Connection conn) throws SQLException {
		String sql = "select * from t_contact_sub as b inner join t_contact as a on a.id = b.belongId order by b.belongId,b.id asc";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<Contact>>() {
			@Override
			public List<Contact> execute(ResultSet rs) throws SQLException {
				List<Contact> contacts = new ArrayList<Contact>();
				while (rs.next()) {
					Contact contact = new Contact();
					contact.setId(rs.getInt("id"));
					contact.setCategory(rs.getString("category"));
					ContactSub contactSub = new ContactSub();
					contactSub.setId(rs.getInt("id"));
					contactSub.setTitle(rs.getString("title"));
					contactSub.setContent(rs.getString("content"));
					contactSub.setBelongId(rs.getInt("belongId"));
					contact.setContactSub(contactSub);
					contacts.add(contact);
				}
				return contacts;
			}
		});
	}


}
