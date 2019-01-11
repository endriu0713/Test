package Database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Employee;
import model.User;

public class SelectsDB {
	private Statement stat;
    private Connection conn;
	
    public SelectsDB(Statement stat, Connection conn) {
    	this.stat = stat;
    	this.conn = conn;
	}
	
	public ArrayList<User> selectUsers(){
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM users order by username;");
			int userID;
			String username, status, type;
			while(result.next()) {
				userID = result.getInt("userID");
				username = result.getString("username");
				status = result.getString("status");
				type = result.getString("type");
				users.add(new User(userID,username,status,type));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return users;
	}
	
	public boolean checkIfUsernameExist(String Username){
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM users where username == '" + Username + "';");
			if(result.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.err.println("Error during selecting User: " + e.getMessage());
			return false;
		}
	}
	
	public ArrayList<User> selectFromUsersByDifferentString(String column, String data){
		ArrayList<User> users = new ArrayList<User>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM users where " + column + " =='" + data + "';");
			int userID;
			String status, username, type;
			while(result.next()) {
				userID = result.getInt("userID");
				username = result.getString("username");
				status = result.getString("status");
				type = result.getString("type");
				users.add(new User(userID,username,status, type));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return users;
	}

	public ArrayList<Employee> selectFromEmployeesByDifferentString(String column, String data){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			ResultSet result = stat.executeQuery("SELECT * FROM employees where " + column + " like '%" + data + "%';");
			int employeeID;
			String username, firstName, lastName, contractType;
			Date hireDate, terminationDate;
			while(result.next()) {
				employeeID = result.getInt("employeeID");
				username = result.getString("username");
				firstName = result.getString("firstName");
				lastName = result.getString("lastName");
				contractType = result.getString("contractType");
				hireDate = result.getDate("hireDate");
				terminationDate = result.getDate("terminationDate");
				Employee emp = new Employee(employeeID, username, firstName, lastName, contractType, hireDate);
				emp.setTerminationDate(terminationDate);
				employees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return employees;
	}
}
