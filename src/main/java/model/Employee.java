package model;

import java.sql.Date;

public class Employee {
	private int employeeID;
	private String username;
	private String firstName;
	private String lastName;
	private String contractType;
	private Date hireDate;
	private Date terminationDate;
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	public Date getHireDate() {
		return hireDate;
	}
	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	public Date getTerminationDate() {
		return terminationDate;
	}
	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}
	
	public Employee(int employeeID, String username, String firstName, String lastName, String contractType, Date hireDate) {
		this.employeeID = employeeID;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contractType = contractType;
		this.hireDate = hireDate;
	}
}
