package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	public static Connection getConnection() throws SQLException{
		String jdbcURL = "jdbc:mariadb://localhost/librettovoti?user=root&password=11223344";
		Connection conn = DriverManager.getConnection(jdbcURL);
		return conn;
	}

}
