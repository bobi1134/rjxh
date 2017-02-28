package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.HPHotAnswering;
import cn.rjxh.utils.page.PageModel;

public interface HPHotAnsweringDao {

	List<HPHotAnswering> getHotAnswerings(Connection conn)throws SQLException;

	List<HPHotAnswering> getHotAnswerings(Connection conn, PageModel pageModel, String px)throws SQLException;

	HPHotAnswering getHotAnswerContent(Connection conn, String id)throws SQLException;

	void updateHotAnswer(Connection conn, HPHotAnswering hotAnswer)throws SQLException;

	void addHotAnswer(Connection conn, HPHotAnswering hotAnswer)throws SQLException;

	void deleteHotAnswer(Connection conn, String id)throws SQLException;

	void syHotAnswer(Connection conn, String id, int sy)throws SQLException;

}
