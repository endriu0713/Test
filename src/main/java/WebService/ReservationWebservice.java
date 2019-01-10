package WebService;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import Database.Database;
import model.User;

@Path("/reservation")
public class ReservationWebservice {
    @GET
    public Response listReservations() {
    	Database baza = Database.getInstance();
    	ArrayList<User> users = baza.selectUsers();
    	//baza.insertUser("username", "firstName", "lastName");
    	String data = "Puste!";
		for (User user : users) {
			data = user.getUsername();
		}
		
        return Response.ok(users).build();
    }
}