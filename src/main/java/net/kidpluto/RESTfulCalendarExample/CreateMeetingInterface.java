package net.kidpluto.RESTfulCalendarExample;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/Create")
public interface CreateMeetingInterface {

    @POST
    @Path("/meeting")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    String createTheMeeting(@FormParam("id") int id,
                             @FormParam("name") String name,
                             @FormParam("profession") String profession,
                             @Context HttpServletResponse servletResponse) throws IOException;
}