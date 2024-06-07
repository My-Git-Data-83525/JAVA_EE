package com.election.Dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.election.entity.User;
import com.election.util.DbUtils;

public class userDao {
	private Connection connection;
	
	public userDao() throws SQLException {
		connection=DbUtils.getConnection();
	}
	public User findByEmail(String email) throws Exception{
		return null;
		
	} 
	public User findById(int id) throws Exception{
		return null;
		
	} 
	public int save(User user) throws Exception{
		return 0;
		
	} 
	public int updateStatus(int userId, boolean voted) throws Exception{
		return userId;
		
	} 
	public int updatePassword(int userId, String newPassword) throws Exception{
		return userId;
		
	} 
	public int deleteById(int id) throws Exception{
		return 0;
		
	}
	public int update(User user) throws Exception{
		return 0;
		
	}

}
