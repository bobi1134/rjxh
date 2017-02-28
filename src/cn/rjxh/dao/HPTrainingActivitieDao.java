package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.HPTrainingActivitie;
import cn.rjxh.utils.page.PageModel;

public interface HPTrainingActivitieDao {

	List<HPTrainingActivitie> getTrainingActivities(Connection conn)throws SQLException;

	List<HPTrainingActivitie> getTrainActives(Connection conn, PageModel pageModel, String px)throws SQLException;

	HPTrainingActivitie getTrainActiveContent(Connection conn, String id)throws SQLException;

	void updateTrainactive(Connection conn, HPTrainingActivitie trainActive)throws SQLException;

	void addTrainactive(Connection conn, HPTrainingActivitie trainActive)throws SQLException;

	void deleteTrainactive(Connection conn, String id)throws SQLException;

	void syTrainactive(Connection conn, String id, int sy)throws SQLException;

}
