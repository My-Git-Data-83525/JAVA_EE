package com.election.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {
	public final static String DB_URL="jdbc:mysql://localhost:3306/election_db";
	public final static String USER_NAME="root";
	public final static String PASSWORD="manager";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		
	}
}

