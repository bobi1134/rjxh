package cn.rjxh.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.rjxh.dao.AssociationIntroduceDao;
import cn.rjxh.dao.support.QueryRunner;
import cn.rjxh.dao.support.ResultSetHandler;
import cn.rjxh.dto.AssociationIntroduce;
import cn.rjxh.utils.page.PageModel;

public class AssociationIntroduceDaoImpl implements AssociationIntroduceDao {

	@Override
	public List<AssociationIntroduce> getAssociationIntroduces(Connection conn, PageModel pageModel) throws SQLException {
		String sql = "select * from t_associationintroduce where flag = 1";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.queryByPage(conn, sql, null, pageModel, new ResultSetHandler<List<AssociationIntroduce>>() {
			@Override
			public List<AssociationIntroduce> execute(ResultSet rs)
					throws SQLException {
				List<AssociationIntroduce> associationIntroduces = new ArrayList<AssociationIntroduce>();
				while (rs.next()) {
					AssociationIntroduce associationIntroduce = new AssociationIntroduce();
					associationIntroduce.setId(rs.getInt("id"));
					associationIntroduce.setTitle(rs.getString("title"));
					associationIntroduce.setContent(rs.getString("content"));
					associationIntroduces.add(associationIntroduce);
				}
				return associationIntroduces;
			}
		});
	}

	@Override
	public List<AssociationIntroduce> getAssociationImgIntroduces(Connection conn) throws SQLException {
		String sql = "select * from t_associationintroduce where flag = 2";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, null, new ResultSetHandler<List<AssociationIntroduce>>() {
			@Override
			public List<AssociationIntroduce> execute(ResultSet rs)
					throws SQLException {
				List<AssociationIntroduce> associationIntroduces = new ArrayList<AssociationIntroduce>();
				while (rs.next()) {
					AssociationIntroduce associationIntroduce = new AssociationIntroduce();
					associationIntroduce.setId(rs.getInt("id"));
					associationIntroduce.setImage(rs.getString("image"));
					associationIntroduce.setImgtitle(rs.getString("imgtitle"));
					associationIntroduces.add(associationIntroduce);
				}
				return associationIntroduces;
			}
		});
	}

	@Override
	public AssociationIntroduce getIntroduce(Connection conn, String id)throws SQLException {
		String sql = "select * from t_associationintroduce where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.query(conn, sql, new Object[]{Integer.valueOf(id)}, new ResultSetHandler<AssociationIntroduce>() {
			@Override
			public AssociationIntroduce execute(ResultSet rs)throws SQLException {
				if (rs.next()) {
					AssociationIntroduce associationIntroduce = new AssociationIntroduce();
					associationIntroduce.setId(rs.getInt("id"));
					associationIntroduce.setTitle(rs.getString("title"));
					associationIntroduce.setContent(rs.getString("content"));
					associationIntroduce.setImage(rs.getString("image"));
					return associationIntroduce;
				}
				return null;
			}
		});
	}

	@Override
	public Object updateIntroduce(Connection conn, AssociationIntroduce introduce) throws SQLException {
		String sql = "update t_associationintroduce set title = ?, content = ? where id = ?";
		QueryRunner queryRunner = new QueryRunner();
		return queryRunner.update(conn, sql, new Object[]{introduce.getTitle(), introduce.getContent(), Integer.valueOf(introduce.getId())});
	}

	@Override
	public void addBaseInfo(Connection conn, AssociationIntroduce introduce) throws SQLException {
		String sql = "insert into t_associationintroduce (title,content,flag) values(?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{introduce.getTitle(), introduce.getContent(), 1}); 	
	}

	@Override
	public void deleteBaseInfo(Connection conn, String id) throws SQLException {
		String sql = "delete from t_associationintroduce where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}

	@Override
	public void addImgInfo(Connection conn, String imgtitle, String newFileName)throws SQLException {
		String sql = "insert into t_associationintroduce (image, imgtitle, flag) values(?,?,?)";
		new QueryRunner().update(conn, sql, new Object[]{newFileName, imgtitle, 2});
	}

	@Override
	public void deleteImgInfo(Connection conn, String id) throws SQLException {
		String sql = "delete from t_associationintroduce where id = ?";
		new QueryRunner().update(conn, sql, new Object[]{Integer.valueOf(id)});
	}


}
