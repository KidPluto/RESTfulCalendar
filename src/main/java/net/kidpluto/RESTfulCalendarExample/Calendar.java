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
    @Produces(MediaType.APPLICATION_XML)
    Response viewCalendar(@PathParam("calendarid") int id);

    @GET
    @Path("/view/meeting/{meetingid}")
    @Produces(MediaType.APPLICATION_XML)
    Response viewMeeting(@PathParam("meetingid") int id);

    @GET
    @Path("/schedule/meeting")
    @Produces(MediaType.APPLICATION_XML)
    Response scheduleMeeting();

    @POST
    @Path("/create/meeting")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String createMeeting(@FormParam("start") Date start,
                         @FormParam("finish") Date finish,
                         @FormParam("description") String description,
                         @FormParam("attendees") Set attendees,
                         @Context HttpServletResponse servletResponse) throws IOException;

    @DELETE
    @Path("/meeting/{meetingid}")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response deleteMeeting(@PathParam("meetingid") int id);

    @POST
    @Path("/update/calendars")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String syncCalendars(@FormParam("calenderOneId") int calendarOneId,
                         @FormParam("calendarTwoId") int calendarTwoId,
                         @Context HttpServletResponse servletResponse) throws IOException;
}
