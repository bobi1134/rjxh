package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.rjxh.dao.HPBannerDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.HPBanner;

public class HPBannerDaoImpl implements HPBannerDao {

	/**
	 * 获取所有Banner图
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	@Override
	public List<HPBanner> getBanners(Connection conn) throws SQLException {
		String sql = "select * from t_homepage_banner";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<HPBanner>>() {
			@Override
			public List<HPBanner> execute(ResultSet rs) throws SQLException {
				List<HPBanner> hPBanners = new ArrayList<HPBanner>();
				while (rs.next()) {
					HPBanner hPBanner = new HPBanner();
					hPBanner.setId(rs.getInt("id"));
					hPBanner.setImage(rs.getString("image"));
					hPBanner.setTitle(rs.getString("title"));
					hPBanners.add(hPBanner);
				}
				return hPBanners;
			}
		});
	}

	@Override
	public HPBanner getBanner(Connection conn, String id) throws SQLException {
		String sql = "select * from t_homepage_banner where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<HPBanner>() {
			@Override
			public HPBanner execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					HPBanner hPBanner = new HPBanner();
					hPBanner.setId(rs.getInt("id"));
					hPBanner.setImage(rs.getString("image"));
					hPBanner.setTitle(rs.getString("title"));
					return hPBanner;
				}
				return null;
			}
		});
	}

	@Override
	public void updateBanner(Connection conn, HPBanner updateBanner)
			throws SQLException {
		String sql = "update t_homepage_banner set image = ?, title = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{updateBanner.getImage(),updateBanner.getTitle(),updateBanner.getId()});
	}

	@Override
	public void deleteBanner(Connection conn, String id) throws SQLException {
		String sql = "delete from t_homepage_banner where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

	@Override
	public void deleteBanner(Connection conn, String newFileName, String title)
			throws SQLException {
		String sql = "insert into t_homepage_banner (image,title) values(?,?)";
		new QueryRunner().update(conn, sql, new Object[]{newFileName, title});
	}


}
