package WebService;
import java.sql.Date;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import Database.Database;
import model.Employee;
import model.User;

@Path("/reservation")
public class ReservationWebservice {
    @GET
    public Response listReservations() {
    	Database baza = Database.getInstance();
    	
    	User user = new User(0,"andre","active","admin");
		user.setPassword("pass");
		Employee emp = new Employee(0, "andre", "Patryk", "Andrejas", "normal", new Date(0));
		emp.setTerminationDate(new Date(0));
		baza.reqisterUser(user, emp);
    	
    	
    	ArrayList<User> users = baza.selectUsers();
    	//baza.insertUser("username", "firstName", "lastName");
    	/*String data = "Puste!";
		for (User user : users) {
			data = user.getUsername();
		}*/
		
        return Response.ok(users).build();
    }
}