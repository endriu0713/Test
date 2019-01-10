package model;

public class User {
	private String username;
	private int userID;
	private String password;
	private String status;
	private String type;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public User(int userID, String username, String status, String type) {
		this.setUserID(userID);
		this.setUsername(username);
		this.setStatus(status);
		this.setType(type);
	}
}
