package assignment2.dao;


import java.sql.Connection;
import java.sql.SQLException;

import assignment2.utils.*;

public class Dao implements AutoCloseable {
	protected Connection con;
	public Dao() throws Exception {
		con = assignment2.utils.DbUtil.getConnection();
	}
	public void close() {
		try {
			if(con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
