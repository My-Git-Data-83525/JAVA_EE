package com.sunbeam.beans;
import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.User;

public class RegisterBean {
	private String fullName;
	private String email;
	private String password;
	private String phoneNo;
	private int count;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public RegisterBean() {
	
	}
	public void Register() {
		System.out.println(fullName+" "+email+" "+password+" "+phoneNo);
		try(UserDao userDao=new UserDao()){
			User u=new User(fullName,email,password,phoneNo);
			count=userDao.save(u);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
