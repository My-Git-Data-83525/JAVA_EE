package assignment2.beans;

import assignment2.dao.UserDao;
import assignment2.dao.UserDaoImpl;
import assignment2.pojo.User;

public class LoginBean {
	private String email;
	private String password;
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LoginBean() {
	}

	public void Login() {
		User user = null;
		try (UserDao userDao = new UserDaoImpl()) {
			user = userDao.findByEmail(email);
			if (user.getPassword().equals(password)) {
				this.user = user;
			} else {
				this.user = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
