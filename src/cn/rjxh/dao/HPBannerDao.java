package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.HPBanner;

public interface HPBannerDao {

	/**
	 * 获取所有Banner图
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	List<HPBanner> getBanners(Connection conn)throws SQLException;

	HPBanner getBanner(Connection conn, String id)throws SQLException;

	void updateBanner(Connection conn, HPBanner updateBanner)throws SQLException;

	void deleteBanner(Connection conn, String id)throws SQLException;

	void deleteBanner(Connection conn, String newFileName, String title)throws SQLException;

}
