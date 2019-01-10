package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Employee;
import model.User;

public class InsertsDB {
	private Connection conn;
	
	public InsertsDB(Connection conn) {
		this.conn = conn;
	}
	
	public boolean insertUser(String username, String firstName, String lastName, String birthDate) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into users values (NULL, ?, ?, ?, ?);");
			prepStmt.setString(1, username);
            prepStmt.setString(2, firstName);
            prepStmt.setString(3, lastName);
            prepStmt.setString(4, birthDate);
            prepStmt.execute();
		} catch (SQLException e){
			System.err.println("Error during inserting");
			return false;
		}
		
		return true;
	}
	
	public boolean reqisterUser(User user, Employee employee) {
		try {
			PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into users values (NULL, ?, ?, ?, ?);");
			prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
            prepStmt.setString(3, user.getStatus());
            prepStmt.setString(4, user.getType());
            prepStmt.execute();
		} catch (SQLException e){
			System.err.println("Error during inserting: " + e.getMessage());
			return false;
		}
		
		
		try {
			PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into employees values (NULL, ?, ?, ?, ?, ?, ?);");
			prepStmt.setString(1, employee.getUsername());
            prepStmt.setString(2, employee.getFirstName());
            prepStmt.setString(3, employee.getLastName());
            prepStmt.setString(4, employee.getContractType());
            prepStmt.setDate(5, employee.getHireDate());
            prepStmt.setDate(6, employee.getTerminationDate());
            prepStmt.execute();
		} catch (SQLException e){
			System.err.println("Error during inserting: " + e.getMessage());
			return false;
		}
		
		return true;
	}
}
