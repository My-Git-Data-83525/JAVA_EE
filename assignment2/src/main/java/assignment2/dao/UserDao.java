package assignment2.dao;

import java.sql.Date;

import assignment2.pojo.*;

public interface UserDao extends AutoCloseable {

	User findByEmail(String email) throws Exception;

	User findById(int id) throws Exception;

	int save(User user,Date date) throws Exception;

	int updateStatus(int userId, boolean voted) throws Exception;

	int updatePassword(int userId, String newPassword) throws Exception;

	int deleteById(int id) throws Exception;

	int update(User user) throws Exception;

}