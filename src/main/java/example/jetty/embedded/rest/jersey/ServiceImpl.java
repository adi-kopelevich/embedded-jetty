package example.jetty.embedded.rest.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by kopelevi on 06/10/2015.
 */
@Path("/service")
public class ServiceImpl {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String simpleGet(){
        return "Hi";
    }
}
