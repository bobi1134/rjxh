package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.News;
import cn.rjxh.utils.page.PageModel;

public interface NewsDao {

	List<News> getNews(Connection conn, PageModel pageModel)throws SQLException;

	News getNew_(Connection conn, String id)throws SQLException;

	void addzan(Connection conn, String id, int zan_num_new, String clientIp_new)throws SQLException;

	int getMaxId(Connection conn)throws SQLException;

	void updateNews(Connection conn, News new_)throws SQLException;

	void addNews(Connection conn, News new_)throws SQLException;

	void deleteNews(Connection conn, String id)throws SQLException;

}
