package net.kidpluto.RESTfulCalendarExample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/calendar")
public class GetCalendar implements GetCalendarInterface {

    @GET
    @Path("{calendarid}")
    public Response getCalendar( @PathParam("calendarid") String Id) {
        String output = "Jersey says, the Calendar Id you have requested is : " + Id;
        return Response.status(200).entity( output).build();
    }
}

