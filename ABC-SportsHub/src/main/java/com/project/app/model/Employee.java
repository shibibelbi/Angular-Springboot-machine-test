package com.project.app.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Employee {

	// data fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int employeeId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private long mblNum;
	private int loginId;

	// One to One Relation
	@OneToOne
	@JoinColumn(name = "loginId", insertable = false, updatable = false)
	private Login login;

	// One to Many Relation
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Visit> visits;

	// Default Constructor
	public Employee() {
		super();
	}

	// Parameterized Constructor
	public Employee(int employeeId, String firstName, String lastName, int age, String gender, String address,
			long mblNum, int loginId, Login login, List<Visit> visits) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.mblNum = mblNum;
		this.loginId = loginId;
		this.login = login;
		this.visits = visits;
	}

	// Getters and Setters
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getMblNum() {
		return mblNum;
	}

	public void setMblNum(long mblNum) {
		this.mblNum = mblNum;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	@JsonBackReference
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@JsonManagedReference
	public List<Visit> getVisits() {
		return visits;
	}

	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", address=" + address + ", mblNum=" + mblNum + ", loginId=" + loginId
				+ ", login=" + login + ", visits=" + visits + "]";
	}

}
