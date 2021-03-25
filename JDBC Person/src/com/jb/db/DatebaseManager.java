package com.jb.db;

import java.sql.Connection;
import java.sql.SQLException;

public class DatebaseManager {

	private static final String CREATE_TABLE_PERSON = 
	  "CREATE TABLE PERSON \r\n"
	+ "(Id INT GENERATED ALWAYS AS IDENTITY \r\n"
	+ "(START WITH 1 INCREMENT BY 1) NOT NULL, \r\n"
	+ "name VARCHAR(35) NOT NULL, \r\n"
	+ "city VARCHAR(35) NOT NULL, \r\n"
	+ "birthday DATE NOT NULL, \r\n"
	+ "hobby VARCHAR(35) NOT NULL, \r\n"
	+ "PRIMARY KEY (Id))\r\n";
	
	private static final String DROP_TABLE_PERSON = "DROP TABLE PERSON";
	private static final String CHECK_TABLE_EXISTS = 
	"SELECT DISTINCT CASE WHEN object_name = 'PERSON' THEN 1 ELSE 0 END as CheckText FROM all_objects";
	
	private static void createTable() throws SQLException, InterruptedException {
		DBUtils.runQuery(CREATE_TABLE_PERSON);
	}

	private static void dropTable() throws SQLException, InterruptedException {
		DBUtils.runQuery(DROP_TABLE_PERSON);
	}

	public static void dropAndCreate() throws SQLException, InterruptedException {
		Connection connection =ConnectionPool.getInstance().getConnection();
		if (DBUtils.runQuery(CHECK_TABLE_EXISTS) == 1)
			dropTable();
		createTable();
		ConnectionPool.getInstance().returnConnection(connection);
	}

}
