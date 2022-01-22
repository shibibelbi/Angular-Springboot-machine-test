package com.project.app.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Login {

	// data fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loginId;
	private String userName;
	private String password;
	private String user;

	// One to One User
	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL)
	private Employee employee;

	// default constructor
	public Login() {
		super();
	}

	// Parameterized constructor
	public Login(int loginId, String userName, String password, String user, Employee employee) {
		super();
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.user = user;
		this.employee = employee;
	}

	// Getters and Setters
	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@JsonBackReference
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Login [loginId=" + loginId + ", userName=" + userName + ", password=" + password + ", user=" + user
				+ ", employee=" + employee + "]";
	}

}
