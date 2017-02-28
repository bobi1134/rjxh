package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.HPSkillTalk;

public interface HPSkillTalkDao {

	List<HPSkillTalk> getSkills(Connection conn)throws SQLException;

	HPSkillTalk getSkill(Connection conn, String id)throws SQLException;

	void updateSkilltalk(Connection conn, String id, String title)throws SQLException;

	void updateSkilltalk(Connection conn, String id, String title, String newFileName)throws SQLException;

	void addSubSkilltalk(Connection conn, String category, String id)throws SQLException;

	void deleteSubSkilltalk(Connection conn, String id, String newCategory)throws SQLException;

	void addSkilltalk(Connection conn, String title, String newFileName, String category)throws SQLException;

	void deleteSkilltalk(Connection conn, String id)throws SQLException;

}
