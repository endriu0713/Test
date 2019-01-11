package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Employee;
import model.User;

public class InsertsDB {
	private Statement stat;
    private Connection conn;
	
    public InsertsDB(Statement stat, Connection conn) {
    	this.stat = stat;
    	this.conn = conn;
	}
	
	private String generateUsername(User user, Employee employee) {
		SelectsDB db = new SelectsDB(stat, conn);
		String generatedUsername = employee.getLastName().substring(0,(employee.getLastName().length()-1)) + employee.getFirstName().charAt(0);
		boolean generatedUsernameExist = db.checkIfUsernameExist(generatedUsername);
		System.out.println(generatedUsername + " : " + generatedUsernameExist);
		for(int index=0; generatedUsernameExist; index++) {
			generatedUsername = employee.getLastName().substring(0,(employee.getLastName().length()-1)) + employee.getFirstName().charAt(0) + index;
			System.out.println(generatedUsername + " :::: " + generatedUsernameExist);
			generatedUsernameExist = db.checkIfUsernameExist(generatedUsername);
		}
		return generatedUsername;
	}
	
	public boolean reqisterUser(User user, Employee employee) {
		String generatedUsername = this.generateUsername(user, employee);
		employee.setUsername(generatedUsername);
		user.setUsername(generatedUsername);
		try {
			PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into users values (NULL, ?, ?, ?, ?);");
			prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getPassword());
            prepStmt.setString(3, user.getStatus());
            prepStmt.setString(4, user.getType());
            prepStmt.execute();
		} catch (SQLException e){
			System.err.println("Error during inserting u: " + e.getMessage());
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
