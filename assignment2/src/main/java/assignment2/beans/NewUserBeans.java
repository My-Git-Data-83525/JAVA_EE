package assignment2.beans;

import java.sql.Date;

import assignment2.dao.UserDao;
import assignment2.dao.UserDaoImpl;
import assignment2.pojo.User;

public class NewUserBeans {
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	private int status;
	User user = new User();

	public int getStatus() {
		return status;
	}

	public void setStatus() {
		this.status = 0;
	}

	public String getRole() {
		return role;
	}

	public void setRole() {
		this.role = "voter";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private String role;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public NewUserBeans() {

	}

	public int RegisterUser() {
		int num = 0;

		Date dateOfBirth = Date.valueOf(date);
		System.out.println(dateOfBirth);
		try (UserDao userDao = new UserDaoImpl()) {
			user = new User(firstName, lastName, email, password,dateOfBirth, status, role);
			num = userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}

}
