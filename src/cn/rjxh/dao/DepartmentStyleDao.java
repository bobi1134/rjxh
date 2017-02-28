package cn.rjxh.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import cn.rjxh.dto.DepartmentStyle;

public interface DepartmentStyleDao {

	List<DepartmentStyle> getStyles(Connection conn, String belong, int flag)throws SQLException;

	DepartmentStyle getStylesDg(Connection conn, String belong, int flag)throws SQLException;

	DepartmentStyle getStyle(Connection conn, String id)throws SQLException;

	void updateZc(Connection conn, DepartmentStyle style)throws SQLException;

	void addSubZc(Connection conn, DepartmentStyle style)throws SQLException;

	void deleteSubZc(Connection conn, String id)throws SQLException;

}
