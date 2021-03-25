package com.jb.db;

import com.jb.beans.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DBUtils {
	private static final String CHECK_TABLE_EXISTS = 
	"SELECT DISTINCT CASE WHEN object_name = 'PERSON' THEN 1 ELSE 0 END as CheckText FROM all_objects";

	public static int runQuery(String sql) throws SQLException, InterruptedException {
		int result = 0;
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.execute();
		if (sql == CHECK_TABLE_EXISTS) {
			ResultSet resultSet = statement.executeQuery();
			resultSet.next();
			result = resultSet.getInt(1);
		}
		ConnectionPool.getInstance().returnConnection(connection);
		return result;
	}

	public static ResultSet runQueryWithResult(String sql, Map<Integer, Object> map)
			throws SQLException, InterruptedException {
		Connection connection = ConnectionPool.getInstance().getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = null;
		for (Entry<Integer, Object> entry : map.entrySet()) {
			int key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof Integer)
				statement.setInt(key, (int) value);
			else if (value instanceof Float)
				statement.setFloat(key, (float) value);
			else if (value instanceof String)
				statement.setString(key, String.valueOf(value));
			else if (value instanceof Date)
				statement.setDate(key, convert((Date) value));
		}
		if (sql.contains("SELECT"))
			resultSet = statement.executeQuery();
		else
			statement.execute();
		ConnectionPool.getInstance().returnConnection(connection);
		return resultSet;
	}

	public static void printQuery(List<Person> query) throws SQLException {
		List<Person> list = query;
		System.out.println("Query Result:");
		if (list.size() > 0) {
			System.out.println("***********************************");
			list.forEach(System.out::println);
			System.out.println("***********************************" + "\r\n");
		} else
			System.out.println("No matching row exists" + "\r\n");
	}

	public static java.sql.Date convert(Date value) {
		return new java.sql.Date(value.getTime());
	}
}
