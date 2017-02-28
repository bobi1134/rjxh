package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.rjxh.dao.NewsDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.News;
import cn.rjxh.utils.page.PageModel;

public class NewsDaoImpl implements NewsDao {

	@Override
	public List<News> getNews(Connection conn, PageModel pageModel) throws SQLException {
		String sql = "select * from t_news order by date desc";
		QueryRunner queryRunner = new QueryRunner();
			return queryRunner.queryByPage(conn, sql, null, pageModel, new ResultSetHandler<List<News>>() {
				@Override
				public List<News> execute(ResultSet rs) throws SQLException {
					List<News> news = new ArrayList<News>();
					while (rs.next()) {
						News new_ = new News();
						new_.setId(rs.getInt("id"));
						new_.setTitle(rs.getString("title"));
						new_.setContent(rs.getString("content"));
						new_.setDate(rs.getTimestamp("date"));
						new_.setIp(rs.getString("ip"));
						new_.setZan_num(rs.getInt("zan_num"));
						news.add(new_);
					}
					return news;
				}
			});
	}

	@Override
	public News getNew_(Connection conn, String id) throws SQLException {
		String sql = "select * from t_news where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{id}, new ResultSetHandler<News>() {
			@Override
			public News execute(ResultSet rs) throws SQLException {
				News new_ = new News();
				if (rs.next()) {
					new_.setId(rs.getInt("id"));
					new_.setTitle(rs.getString("title"));
					new_.setContent(rs.getString("content"));
					new_.setDate(rs.getTimestamp("date"));
					new_.setIp(rs.getString("ip"));
					new_.setZan_num(rs.getInt("zan_num"));
					return new_;
				}
				return null;
			}
		});
	}

	@Override
	public void addzan(Connection conn, String id, int zan_num_new, String clientIp_new) throws SQLException {
		String sql = "update t_news set ip = ?,  zan_num = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{clientIp_new, Integer.valueOf(zan_num_new), Integer.valueOf(id)});
	}

	@Override
	public int getMaxId(Connection conn) throws SQLException {
		String sql = "select max(id) as count from t_news";
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

	@Override
	public void updateNews(Connection conn, News new_) throws SQLException {
		String sql = "update t_news set title = ?, content = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{new_.getTitle(), new_.getContent(), Integer.valueOf(new_.getId())});
	}

	@Override
	public void addNews(Connection conn, News new_) throws SQLException {
		String sql = "insert into t_news (title, content, date) values(?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{new_.getTitle(), new_.getContent(), new Date()});
	}

	@Override
	public void deleteNews(Connection conn, String id) throws SQLException {
		String sql = "delete from t_news where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}
}
