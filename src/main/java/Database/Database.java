package Database;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Employee;
import model.User;

public class Database {

    public static Database Instance = null;
    private ConnectionToDB conncectionToDB;
    private QueriesOnDB queriesOnDB;
    
    public static Database getInstance() {
    	if(Instance == null) {
    		Instance = new Database();
    	}
    	return Instance;
    }
    
    private Database() {
    	this.conncectionToDB = new ConnectionToDB();
    	this.queriesOnDB = new QueriesOnDB(conncectionToDB.getStat(), conncectionToDB.getConn());
    }
   
    public void closeConnection() {
    	this.conncectionToDB.closeConnection();
    	Instance = null;
    }
    
    public ArrayList<User> selectUsers(){
    	return this.queriesOnDB.selectUsers();
    }
    
    public boolean insertUser(String username, String firstName, String lastName, String birthDate) {
    	return this.queriesOnDB.insertUser(username, firstName, lastName, birthDate);
    }
    
    public User selectUser(String username){
    	return this.queriesOnDB.selectUser(username);
    }
    
    public ArrayList<User> selectFromUsersByDifferentString(String column, String data){
    	return this.queriesOnDB.selectFromUsersByDifferentString(column, data);
    }
    
    public boolean reqisterUser(User user, Employee employee) {
    	return this.queriesOnDB.reqisterUser(user, employee);
    }
    
    public ArrayList<Employee> selectFromEmployeesByDifferentString(String column, String data){
    	return this.queriesOnDB.selectFromEmployeesByDifferentString(column, data);
    }
}
