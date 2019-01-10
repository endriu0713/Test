package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}
