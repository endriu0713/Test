package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionToDB {
    private static final String DRIVER =  "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:Database.db";
    private Connection conn;
    private Statement stat;
    
    public ConnectionToDB() {
        try {
            Class.forName(ConnectionToDB.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Wrong configuration of JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem during opening connection");
            e.printStackTrace();
        }
	}
   
    public Statement getStat() {
		return stat;
	}
    
    public Connection getConn() {
		return conn;
	}
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
}
