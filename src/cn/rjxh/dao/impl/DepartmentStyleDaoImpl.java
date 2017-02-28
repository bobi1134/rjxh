package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.rjxh.dao.DepartmentStyleDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.DepartmentStyle;


public class DepartmentStyleDaoImpl implements DepartmentStyleDao {

	@Override
	public List<DepartmentStyle> getStyles(Connection conn, String belong, int flag) throws SQLException {
		String sql = "select * from t_departmentstyle where belong = ? and flag = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{belong, flag},  new ResultSetHandler<List<DepartmentStyle>>() {
			@Override
			public List<DepartmentStyle> execute(ResultSet rs)throws SQLException {
				List<DepartmentStyle> departmentStyles = new ArrayList<DepartmentStyle>();
				while (rs.next()) {
					DepartmentStyle departmentStyle = new DepartmentStyle();
					departmentStyle.setId(rs.getInt("id"));
					departmentStyle.setAbout(rs.getString("about"));
					departmentStyle.setCategory(rs.getString("category"));
					departmentStyle.setIntroduce(rs.getString("introduce"));
					departmentStyle.setBelong(rs.getString("belong"));
					departmentStyle.setFlag(rs.getInt("flag"));
					departmentStyles.add(departmentStyle);
				}
				return departmentStyles;
			}
		});
		
	}

	@Override
	public DepartmentStyle getStylesDg(Connection conn, String belong, int flag)throws SQLException {
		String sql = "select * from t_departmentstyle where belong = ? and flag = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{belong, flag}, new ResultSetHandler<DepartmentStyle>() {
			@Override
			public DepartmentStyle execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					DepartmentStyle departmentStyle = new DepartmentStyle();
					departmentStyle.setId(rs.getInt("id"));
					departmentStyle.setAbout(rs.getString("about"));
					departmentStyle.setCategory(rs.getString("category"));
					departmentStyle.setIntroduce(rs.getString("introduce"));
					departmentStyle.setBelong(rs.getString("belong"));
					departmentStyle.setFlag(rs.getInt("flag"));
					return departmentStyle;
				}
				return null;
			}
		});
	}

	@Override
	public DepartmentStyle getStyle(Connection conn, String id)throws SQLException {
		String sql = "select * from t_departmentstyle where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<DepartmentStyle>() {
			@Override
			public DepartmentStyle execute(ResultSet rs) throws SQLException {
				if (rs.next()) {
					DepartmentStyle departmentStyle = new DepartmentStyle();
					departmentStyle.setId(rs.getInt("id"));
					departmentStyle.setAbout(rs.getString("about"));
					departmentStyle.setCategory(rs.getString("category"));
					departmentStyle.setIntroduce(rs.getString("introduce"));
					departmentStyle.setBelong(rs.getString("belong"));
					departmentStyle.setFlag(rs.getInt("flag"));
					return departmentStyle;
				}
				return null;
			}
		});
	}

	@Override
	public void updateZc(Connection conn, DepartmentStyle style)throws SQLException {
		String sql = "update t_departmentstyle set about = ? where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{style.getAbout(), Integer.valueOf(style.getId())});
	}

	@Override
	public void addSubZc(Connection conn, DepartmentStyle style) throws SQLException{
		String sql = "insert into t_departmentstyle (category, introduce, belong, flag) values(?,?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{style.getCategory(), style.getIntroduce(), style.getBelong(), 2});
	}

	@Override
	public void deleteSubZc(Connection conn, String id) throws SQLException {
		String sql = "delete from t_departmentstyle where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

}
