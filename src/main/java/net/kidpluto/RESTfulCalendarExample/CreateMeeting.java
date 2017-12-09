package net.kidpluto.RESTfulCalendarExample;

import org.apache.catalina.User;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/Create")
public class CreateMeeting implements CreateMeetingInterface {

    private static final String SUCCESS_RESULT = "<result>success</result>";
    private static final String FAILURE_RESULT = "<result>failure</result>";

    @POST
    @Path("/meeting")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)

    public String createTheMeeting(@FormParam("id") int id,
                             @FormParam("name") String name,
                             @FormParam("profession") String profession,
                             @Context HttpServletResponse servletResponse) throws IOException {

        return SUCCESS_RESULT;
    }
}