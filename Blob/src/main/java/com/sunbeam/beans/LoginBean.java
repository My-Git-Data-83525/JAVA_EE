package com.sunbeam.beans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;
	public LoginBean(){
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int Login() {
		System.out.println(email+" "+password);
		try(UserDao userDao=new UserDao()){
			user=userDao.findByEmailAndPassword(email, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	

}
