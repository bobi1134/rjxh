package cn.rjxh.dao.support;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetHandler<T>{
	public T execute(ResultSet rs) throws SQLException;
}
