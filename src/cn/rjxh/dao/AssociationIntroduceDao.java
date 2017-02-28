package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.AssociationIntroduce;
import cn.rjxh.utils.page.PageModel;

public interface AssociationIntroduceDao {

	List<AssociationIntroduce> getAssociationIntroduces(Connection conn, PageModel pageModel)throws SQLException;

	List<AssociationIntroduce> getAssociationImgIntroduces(Connection conn)throws SQLException;

	AssociationIntroduce getIntroduce(Connection conn, String id)throws SQLException;

	Object updateIntroduce(Connection conn, AssociationIntroduce introduce)throws SQLException;

	void addBaseInfo(Connection conn, AssociationIntroduce introduce)throws SQLException;

	void deleteBaseInfo(Connection conn, String id)throws SQLException;

	void addImgInfo(Connection conn, String imgtitle, String newFileName)throws SQLException;

	void deleteImgInfo(Connection conn, String id)throws SQLException;

}
