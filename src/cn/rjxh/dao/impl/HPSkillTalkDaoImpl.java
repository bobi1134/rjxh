package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.rjxh.dao.HPSkillTalkDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.HPBanner;
import cn.rjxh.dto.HPSkillTalk;

public class HPSkillTalkDaoImpl implements HPSkillTalkDao {

	@Override
	public List<HPSkillTalk> getSkills(Connection conn) throws SQLException {
		String sql = "select * from t_homepage_skilltalk";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<HPSkillTalk>>() {
			@Override
			public List<HPSkillTalk> execute(ResultSet rs) throws SQLException {
				List<HPSkillTalk> hPSkillTalks = new ArrayList<HPSkillTalk>();
				while (rs.next()) {
					HPSkillTalk hPSkillTalk = new HPSkillTalk();
					hPSkillTalk.setId(rs.getInt("id"));
					hPSkillTalk.setTitle(rs.getString("title"));
					hPSkillTalk.setImage(rs.getString("image"));
					hPSkillTalk.setCategory(rs.getString("category"));
					hPSkillTalks.add(hPSkillTalk);
				}
				return hPSkillTalks;
			}
		});
	}

	@Override
	public HPSkillTalk getSkill(Connection conn, String id)
			throws SQLException {
		String sql = "select * from t_homepage_skilltalk where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<HPSkillTalk>() {
			@Override
			public HPSkillTalk execute(ResultSet rs) throws SQLException {
				while (rs.next()) {
					HPSkillTalk hPSkillTalk = new HPSkillTalk();
					hPSkillTalk.setId(rs.getInt("id"));
					hPSkillTalk.setTitle(rs.getString("title"));
					hPSkillTalk.setImage(rs.getString("image"));
					hPSkillTalk.setCategory(rs.getString("category"));
					return hPSkillTalk;
				}
				return null;
			}
		});
	}

	@Override
	public void updateSkilltalk(Connection conn, String id, String title)
			throws SQLException {
		String sql = "update t_homepage_skilltalk set title = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{title, Integer.valueOf(id)});
	}

	@Override
	public void updateSkilltalk(Connection conn, String id, String title, String newFileName) throws SQLException {
		String sql = "update t_homepage_skilltalk set title = ?, image = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{title, newFileName, Integer.valueOf(id)});
	}

	@Override
	public void addSubSkilltalk(Connection conn, String category, String id)throws SQLException {
		String sql = "update t_homepage_skilltalk set category = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{category, Integer.valueOf(id)});
	}

	@Override
	public void deleteSubSkilltalk(Connection conn, String id, String newCategory) throws SQLException {
		String sql = "update t_homepage_skilltalk set category = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{newCategory, Integer.valueOf(id)});
	}

	@Override
	public void addSkilltalk(Connection conn, String title, String newFileName, String category) throws SQLException {
		String sql = "insert into t_homepage_skilltalk (title, image, category) values(?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{title, newFileName, category});
	}

	@Override
	public void deleteSkilltalk(Connection conn, String id) throws SQLException {
		String sql = "delete from t_homepage_skilltalk where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}


}
