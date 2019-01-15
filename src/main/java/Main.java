import java.sql.Date;
import java.util.ArrayList;

import Database.Database;
import model.Employee;
import model.User;

public class Main {

	public static void main(String[] args) {
		Database db = Database.getInstance();
		
		User user = new User(0,"andre","active","admin");
		user.setPassword("pass");
		Employee emp = new Employee(0, "andre", "Patryk", "Andrejas", "normal", new Date(0));
		emp.setTerminationDate(new Date(0));
		
		//db.reqisterUser(user, emp);
		System.out.println("Users:");
		ArrayList<User> users = new ArrayList<User>();
		users = db.selectUsers(); //("username", "andre");
		for (User user2 : users) {
			System.out.println(user2.getUserID() + " : " + user2.getUsername() +  " : " +user2.getType());
		}
		System.out.println("Employees:");
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees = db.selectFromEmployeesByDifferentString("username", "andre");
		for (Employee employee : employees) {
			System.out.println(employee.getUsername() + " : " + employee.getFirstName() +  " : " + employee.getLastName() + " : " + employee.getTerminationDate());
		} 
		
		//db.checkIfUsernameExist("Andreja");
		

		
	}

}
