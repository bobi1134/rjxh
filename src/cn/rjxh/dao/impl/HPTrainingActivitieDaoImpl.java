package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.rjxh.dao.HPTrainingActivitieDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.HPTrainingActivitie;
import cn.rjxh.utils.page.PageModel;

public class HPTrainingActivitieDaoImpl implements HPTrainingActivitieDao {

	@Override
	public List<HPTrainingActivitie> getTrainingActivities(Connection conn)
			throws SQLException {
		String sql = "select * from t_homepage_trainingactivities where sy = 1 limit 0,6";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<HPTrainingActivitie>>() {
			@Override
			public List<HPTrainingActivitie> execute(ResultSet rs)
					throws SQLException {
				List<HPTrainingActivitie> hPTrainingActivities = new ArrayList<HPTrainingActivitie>();
				while (rs.next()) {
					HPTrainingActivitie hPTrainingActivitie = new HPTrainingActivitie();
					hPTrainingActivitie.setId(rs.getInt("id"));
					hPTrainingActivitie.setTitle(rs.getString("title"));
					hPTrainingActivitie.setContent(rs.getString("content"));
					hPTrainingActivities.add(hPTrainingActivitie);
				}
				return hPTrainingActivities;
			}
		});
	}

	@Override
	public List<HPTrainingActivitie> getTrainActives(Connection conn, PageModel pageModel, String px) throws SQLException {
		String sql = "";
		if (px != null) {
			sql = "select * from t_homepage_trainingactivities order by sy asc, date desc";
		}else{
			sql = "select * from t_homepage_trainingactivities order by date desc";
		}
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.queryByPage(conn, sql, null, pageModel, new ResultSetHandler<List<HPTrainingActivitie>>() {
			@Override
			public List<HPTrainingActivitie> execute(ResultSet rs) throws SQLException {
				List<HPTrainingActivitie> hPTrainingActivities = new ArrayList<HPTrainingActivitie>();
				while (rs.next()) {
					HPTrainingActivitie hPTrainingActivitie = new HPTrainingActivitie();
					hPTrainingActivitie.setId(rs.getInt("id"));
					hPTrainingActivitie.setTitle(rs.getString("title"));
					hPTrainingActivitie.setContent(rs.getString("content"));
					hPTrainingActivitie.setDate(rs.getTimestamp("date"));
					hPTrainingActivitie.setSy(rs.getInt("sy"));
					hPTrainingActivities.add(hPTrainingActivitie);
				}
				return hPTrainingActivities;
			}
		});
	}

	@Override
	public HPTrainingActivitie getTrainActiveContent(Connection conn, String id)throws SQLException {
		String sql = "select * from t_homepage_trainingactivities where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<HPTrainingActivitie>() {
			@Override
			public HPTrainingActivitie execute(ResultSet rs)
					throws SQLException {
				if (rs.next()) {
					HPTrainingActivitie hPTrainingActivitie = new HPTrainingActivitie();
					hPTrainingActivitie.setId(rs.getInt("id"));
					hPTrainingActivitie.setTitle(rs.getString("title"));
					hPTrainingActivitie.setContent(rs.getString("content"));
					hPTrainingActivitie.setDate(rs.getTimestamp("date"));
					return hPTrainingActivitie;
				}
				return null;
			}
		});
	}

	@Override
	public void updateTrainactive(Connection conn, HPTrainingActivitie trainActive) throws SQLException {
		String sql = "update t_homepage_trainingactivities set title = ?, content = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{trainActive.getTitle(), trainActive.getContent(), Integer.valueOf(trainActive.getId())});
	}

	@Override
	public void addTrainactive(Connection conn, HPTrainingActivitie trainActive)throws SQLException {
		String sql = "insert into t_homepage_trainingactivities (title,content,date,sy) values(?,?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{trainActive.getTitle(),trainActive.getContent(),new Date(),2});
	}

	@Override
	public void deleteTrainactive(Connection conn, String id) throws SQLException {
		String sql = "delete from t_homepage_trainingactivities where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

	@Override
	public void syTrainactive(Connection conn, String id, int sy)throws SQLException {
		String sql = "update t_homepage_trainingactivities set sy = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(sy), Integer.valueOf(id)});
	}


}
