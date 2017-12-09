package net.kidpluto.RESTfulCalendarExample;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

@Path("/calendar")
public interface Calendar {

    @GET
    @Path("/view/{calendarid}")
    @Produces(MediaType.APPLICATION_XML)
    Response viewCalendar(
            @PathParam("calendarid") int id);

    @GET
    @Path("/view/meeting/{meetingid}")
    @Produces(MediaType.APPLICATION_XML)
    Response viewMeeting(
            @PathParam("meetingid") int id);

    @GET
    @Path("/attendees/{calendarid}")
    @Produces(MediaType.APPLICATION_XML)
    Response attendeesAvailability(
            @PathParam("calendarid") int id,
            @QueryParam("attendees") Set attendees);

    @POST
    @Path("/create/meeting")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String createMeeting(@FormParam("calenderId") int calendarId,
                         @FormParam("start") Date start,
                         @FormParam("finish") Date finish,
                         @FormParam("description") String description,
                         @FormParam("attendees") Set attendees,
                         @Context HttpServletResponse servletResponse) throws IOException;

    @PUT
    @Path("/update/meeting")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String updateMeeting(@FormParam("calenderId") int calendarId,
                         @FormParam("meetingId") int meetingId,
                         @FormParam("start") Date start,
                         @FormParam("finish") Date finish,
                         @FormParam("description") String description,
                         @FormParam("attendees") Set attendees,
                         @Context HttpServletResponse servletResponse) throws IOException;

    @PUT
    @Path("/sync/calendars")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    String syncCalendars(@FormParam("calenderOneId") int calendarOneId,
                         @FormParam("calendarTwoId") int calendarTwoId,
                         @Context HttpServletResponse servletResponse) throws IOException;
}
