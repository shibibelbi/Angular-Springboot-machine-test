package com.project.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Visit {
	// data fields
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int visitId;
		private String custName;
		private String contPerson;
		private long MblNum;
		private String interestProduct;
		private String subjectVisit;
		private String description;
		private Date visitTime;
		private boolean isDisabled;
		private boolean isDeleted;
		private int employeeId;

		// Many to One
		@ManyToOne
		@JoinColumn(name = "employeeId", insertable = false, updatable = false)
		private Employee employee;

		// Super class
		public Visit() {
			super();
		}

		// parameterized constructor
		public Visit(int visitId, String custName, String contPerson, long mblNum, String interestProduct,
				String subjectVisit, String description, Date visitTime, boolean isDisabled, boolean isDeleted,
				int employeeId, Employee employee) {
			super();
			this.visitId = visitId;
			this.custName = custName;
			this.contPerson = contPerson;
			MblNum = mblNum;
			this.interestProduct = interestProduct;
			this.subjectVisit = subjectVisit;
			this.description = description;
			this.visitTime = visitTime;
			this.isDisabled = isDisabled;
			this.isDeleted = isDeleted;
			this.employeeId = employeeId;
			this.employee = employee;
		}

		// Getters and Setters
		public int getVisitId() {
			return visitId;
		}

		public void setVisitId(int visitId) {
			this.visitId = visitId;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getContPerson() {
			return contPerson;
		}

		public void setContPerson(String contPerson) {
			this.contPerson = contPerson;
		}

		public long getMblNum() {
			return MblNum;
		}

		public void setMblNum(long mblNum) {
			MblNum = mblNum;
		}

		public String getInterestProduct() {
			return interestProduct;
		}

		public void setInterestProduct(String interestProduct) {
			this.interestProduct = interestProduct;
		}

		public String getSubjectVisit() {
			return subjectVisit;
		}

		public void setSubjectVisit(String subjectVisit) {
			this.subjectVisit = subjectVisit;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getVisitTime() {
			return visitTime;
		}

		public void setVisitTime(Date visitTime) {
			this.visitTime = visitTime;
		}

		public boolean isDisabled() {
			return isDisabled;
		}

		public void setDisabled(boolean isDisabled) {
			this.isDisabled = isDisabled;
		}

		public boolean isDeleted() {
			return isDeleted;
		}

		public void setDeleted(boolean isDeleted) {
			this.isDeleted = isDeleted;
		}

		public int getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(int employeeId) {
			this.employeeId = employeeId;
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
			return "VisitEmployee [visitId=" + visitId + ", custName=" + custName + ", contPerson=" + contPerson
					+ ", MblNum=" + MblNum + ", interestProduct=" + interestProduct + ", subjectVisit=" + subjectVisit
					+ ", description=" + description + ", visitTime=" + visitTime + ", isDisabled=" + isDisabled
					+ ", isDeleted=" + isDeleted + ", employeeId=" + employeeId + ", employee=" + employee + "]";
		}

	}
