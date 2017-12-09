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
    Response viewCalendar(@PathParam("calendarid") int id);

    @GET
    @Path("/view/meeting/{meetingid}")
    Response viewMeeting(@PathParam("meetingid") int id);

    @POST
    @Path("/create/meeting")
    String createMeeting(@FormParam("id") int id,
                         @FormParam("start") Date start,
                         @FormParam("finish") Date finish,
                         @FormParam("description") String description,
                         @FormParam("attendees") Set attendees,
                         @Context HttpServletResponse servletResponse) throws IOException;

    @DELETE
    @Path("/delete/meeting/{meetingid}")
    Response deleteMeeting(@PathParam("meetingid") int id);

    @POST
    @Path("/update/calendars")
    String syncCalendars(@FormParam("calenderOneId") int calendarOneId,
                         @FormParam("calendarTwoId") int calendarTwoId,
                         @Context HttpServletResponse servletResponse) throws IOException;
}
