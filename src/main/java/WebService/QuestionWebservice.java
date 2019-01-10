package WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/question")
public class QuestionWebservice {
	
    @GET
    public Response question() {
        return Response.ok("cos sie zmieni? :D ").build();
    }
	
}