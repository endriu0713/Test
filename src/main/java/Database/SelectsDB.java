package Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

public class SelectsDB {
	private Statement stat;
	
	public SelectsDB(Statement stat) {
		this.stat = stat;
	}
	
	public ArrayList<User> selectUsers(){
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM users;");
			int id;
			String firstName, lastName, username, birthDate;
			while(result.next()) {
				id = result.getInt("id");
				username = result.getString("username");
				firstName = result.getString("firstName");
				lastName = result.getString("lastName");
				birthDate = result.getString("birthDate");
				users.add(new User(id,username,firstName,lastName,birthDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return users;
	}
	
	public User selectUser(String Username){
		User user;
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM users where username =='" + Username + "';");
			int id;
			String firstName, lastName, username, birthDate;
			id = result.getInt("id");
			username = result.getString("username");
			firstName = result.getString("firstName");
			lastName = result.getString("lastName");
			birthDate = result.getString("birthDate");
			user = new User(id,username,firstName,lastName,birthDate);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return user;
	}
	
	public ArrayList<User> selectFromUsersByDifferentString(String column, String data){
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM users where " + column + " =='" + data + "';");
			int id;
			String firstName, lastName, username, birthDate;
			while(result.next()) {
				id = result.getInt("id");
				username = result.getString("username");
				firstName = result.getString("firstName");
				lastName = result.getString("lastName");
				birthDate = result.getString("birthDate");
				users.add(new User(id,username,firstName,lastName,birthDate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return users;
	}

}
