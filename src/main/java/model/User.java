package model;

import java.sql.Date;

public class User {
	private String username;
	private int id;
	private String firstName;
	private String lastName;
	private String birthDate;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getBirthDay() {
		return birthDate;
	}
	
	public void setBirthDay(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public User(int id, String username, String firstName, String lastName, String birthDate) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
		this.setUsername(username);
		this.birthDate = birthDate;
	}
}
