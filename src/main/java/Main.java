import java.util.ArrayList;

import Database.Database;
import model.User;

public class Main {

	public static void main(String[] args) {
		System.out.println("works");
		Database db = Database.getInstance();
		
		//db.insertUser("username2", "Patryk", "Andrejas", "birthDate");
		
		ArrayList<User> users = db.selectUsers();
		for (User user : users) {
			System.out.println(user.getId() + " - " + user.getUsername() + " - " + user.getFirstName() + " - " + user.getLastName());
		}
		System.out.println("Dwa:");
		User user = db.selectUser("username2");
		System.out.println(user.getId() + " - " + user.getUsername() + " - " + user.getFirstName() + " - " + user.getLastName());
	
		System.out.println("Trzy:");
		ArrayList<User> users2 = db.selectUsers();
		for (User user1 : users2) {
			System.out.println(user1.getId() + " - " + user1.getUsername() + " - " + user1.getFirstName() + " - " + user1.getLastName());
		}
	}

}
