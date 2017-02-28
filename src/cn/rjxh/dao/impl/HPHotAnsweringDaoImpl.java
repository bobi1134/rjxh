package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.rjxh.dao.HPHotAnsweringDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.HPHotAnswering;
import cn.rjxh.utils.page.PageModel;

public class HPHotAnsweringDaoImpl implements HPHotAnsweringDao {

	@Override
	public List<HPHotAnswering> getHotAnswerings(Connection conn)
			throws SQLException {
		String sql = "select * from t_homepage_hotanswering where sy = 1 limit 0,6";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<HPHotAnswering>>() {
			@Override
			public List<HPHotAnswering> execute(ResultSet rs)
					throws SQLException {
				List<HPHotAnswering> hPHotAnswerings = new ArrayList<HPHotAnswering>();
				while (rs.next()) {
					HPHotAnswering hPHotAnswering = new HPHotAnswering();
					hPHotAnswering.setId(rs.getInt("id"));
					hPHotAnswering.setTitle(rs.getString("title"));
					hPHotAnswering.setContent(rs.getString("content"));
					hPHotAnswerings.add(hPHotAnswering);
				}
				return hPHotAnswerings;
			}
		});
	}

	@Override
	public List<HPHotAnswering> getHotAnswerings(Connection conn, PageModel pageModel, String px) throws SQLException {
		String sql = "";
		if (px != null) {
			sql = "select * from t_homepage_hotanswering order by sy asc ,date desc";
		}else{
			
			sql = "select * from t_homepage_hotanswering order by date desc";
		}
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.queryByPage(conn, sql, null, pageModel, new ResultSetHandler<List<HPHotAnswering>>() {
			@Override
			public List<HPHotAnswering> execute(ResultSet rs)throws SQLException {
				List<HPHotAnswering> hPHotAnswerings = new ArrayList<HPHotAnswering>();
				while (rs.next()) {
					HPHotAnswering hPHotAnswering = new HPHotAnswering();
					hPHotAnswering.setId(rs.getInt("id"));
					hPHotAnswering.setTitle(rs.getString("title"));
					hPHotAnswering.setContent(rs.getString("content"));
					hPHotAnswering.setDate(rs.getTimestamp("date"));
					hPHotAnswering.setSy(rs.getInt("sy"));
					hPHotAnswerings.add(hPHotAnswering);
				}
				return hPHotAnswerings;
			}
		});
	}

	@Override
	public HPHotAnswering getHotAnswerContent(Connection conn, String id)throws SQLException {
		String sql = "select * from t_homepage_hotanswering where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<HPHotAnswering>() {
			@Override
			public HPHotAnswering execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					HPHotAnswering hPHotAnswering = new HPHotAnswering();
					hPHotAnswering.setId(rs.getInt("id"));
					hPHotAnswering.setTitle(rs.getString("title"));
					hPHotAnswering.setContent(rs.getString("content"));
					hPHotAnswering.setDate(rs.getTimestamp("date"));
					return hPHotAnswering;
				}
				return null;
			}
		});
	}

	@Override
	public void updateHotAnswer(Connection conn, HPHotAnswering hotAnswer) throws SQLException {
		String sql = "update t_homepage_hotanswering set title = ?, content = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{hotAnswer.getTitle(), hotAnswer.getContent(), Integer.valueOf(hotAnswer.getId())});
	}

	@Override
	public void addHotAnswer(Connection conn, HPHotAnswering hotAnswer) throws SQLException {
		String sql = "insert into t_homepage_hotanswering (title, content, date, sy) values(?, ?, ?, ?)";
		new QueryRunner().update(conn, sql, new Object[]{hotAnswer.getTitle(), hotAnswer.getContent(), new Date(), 2});
	}

	@Override
	public void deleteHotAnswer(Connection conn, String id) throws SQLException {
		String sql = "delete from t_homepage_hotanswering where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

	@Override
	public void syHotAnswer(Connection conn, String id, int sy)throws SQLException {
		String sql = "update t_homepage_hotanswering set sy = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(sy), Integer.valueOf(id)});
	}


}
