package Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Employee;
import model.User;

public class QueriesOnDB {
    private Statement stat;
    private Connection conn;
    private SelectsDB selectsDB;
    private InsertsDB insertsDB;
    
    public QueriesOnDB(Statement stat, Connection conn) {
    	this.stat = stat;
    	this.conn = conn;
		createTables();
		createQueries();
	}
    
    private void createQueries() {
    	selectsDB = new SelectsDB(stat);
    	insertsDB = new InsertsDB(conn);
    }
    
    private boolean createTables()  {
        //String createUsers = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username varchar(255) UNIQUE, firstName varchar(255), lastName varchar(255), birthDate varchar(255))";
        String createUsers = "CREATE TABLE IF NOT EXISTS users (userID INTEGER PRIMARY KEY AUTOINCREMENT, username varchar(255) UNIQUE,  password varchar(255), status varchar(10), type char(10))";
        String createEmployees = "CREATE TABLE IF NOT EXISTS employees (employeeID INTEGER PRIMARY KEY AUTOINCREMENT, username varchar(255) UNIQUE,  firstName varchar(255), lastName varchar(255), contractType varchar(255), hireDate date, terminationDate date)";
               try {
            //stat.execute(createCzytelnicy);
            stat.execute(createUsers);
            stat.execute(createEmployees);
        } catch (SQLException e) {
            System.err.println("Error during tables creation or open");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public Statement getStat() {
		return stat;
	}
    
    public ArrayList<User> selectUsers(){
    	return this.selectsDB.selectUsers();
    }
    
    public boolean insertUser(String username, String firstName, String lastName, String birthDate) {
    	return this.insertsDB.insertUser(username, firstName, lastName, birthDate);
    }
    
    public User selectUser(String username){
    	return this.selectsDB.selectUser(username);
    }
    
    public ArrayList<User> selectFromUsersByDifferentString(String column, String data){
    	return this.selectsDB.selectFromUsersByDifferentString(column, data);
    }
    
    public boolean reqisterUser(User user, Employee employee) {
    	return this.insertsDB.reqisterUser(user, employee);
    }
    
    public ArrayList<Employee> selectFromEmployeesByDifferentString(String column, String data){
    	return this.selectsDB.selectFromEmployeesByDifferentString(column, data);
    }
}
