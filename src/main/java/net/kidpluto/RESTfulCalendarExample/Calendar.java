package net.kidpluto.RESTfulCalendarExample;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Path("/calendar")
public interface Calendar {

    @GET
    @Path("/view/{calendarid}")
    Response viewCalendar(@PathParam("calendarid") int Id);

    @GET
    @Path("/view/meeting/{meetingid}")
    Response viewMeeting(@PathParam("meetingid") int Id);

    @POST
    @Path("/create/meeting")
    String createMerting(@FormParam("id") int id,
                         @FormParam("start") Date start,
                         @FormParam("finish") Date finish,
                         @FormParam("description") String description,
                         @FormParam("attendees") Set attendees,
                         @Context HttpServletResponse servletResponse) throws IOException;
}

//    @OneToMany
//    private Set<Person> attendees;