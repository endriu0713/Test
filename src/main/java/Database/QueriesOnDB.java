package Database;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
        //String createCzytelnicy = "CREATE TABLE IF NOT EXISTS czytelnicy (id_czytelnika INTEGER PRIMARY KEY AUTOINCREMENT, imie varchar(255), nazwisko varchar(255), pesel int)";
        String createUsers = "CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT, username varchar(255) UNIQUE, firstName varchar(255), lastName varchar(255), birthDate varchar(255))";
        //String createWypozyczenia = "CREATE TABLE IF NOT EXISTS wypozyczenia (id_wypozycz INTEGER PRIMARY KEY AUTOINCREMENT, id_czytelnika int, id_ksiazki int)";
        try {
            //stat.execute(createCzytelnicy);
            stat.execute(createUsers);
            //stat.execute(createWypozyczenia);
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
}
