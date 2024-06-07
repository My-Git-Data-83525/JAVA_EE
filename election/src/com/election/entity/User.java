package com.election.entity;

import java.time.LocalDate;

public class User {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private LocalDate dob;
	private boolean status;
	private String role;

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public User(String first_name, String last_name, String email, String password, LocalDate dob, boolean status,
			String role) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "user [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", dob=" + dob + ", status=" + status + ", role=" + role + "]";
	}

}
