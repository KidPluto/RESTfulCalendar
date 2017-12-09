package net.kidpluto.RESTfulCalendarExample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/calendar")
public interface GetCalendarInterface {

    @GET
    @Path("{calendarid}")
    Response getCalendar( @PathParam("calendarid") String Id);
}

