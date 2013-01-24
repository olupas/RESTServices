package hello.service.ws;

import model.Todo;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 22.01.2013
 * Time: 23:10
 * To change this template use File | Settings | File Templates.
 */
@Path("/todo")
public class TodoService {
    // This method is called if XMLis request
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_XML)
    public Todo getXML() {
        Todo todo = new Todo();
        todo.setSummary("This is my first todo");
        todo.setDescription("This is my first todo");
        return todo;
    }

    // This can be used to test the integration with the browser
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Todo getHTML() {
        Todo todo = new Todo();
        todo.setSummary("This is my first todo");
        todo.setDescription("This is my first todo");
        return todo;
    }

    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response newTodo(@FormParam("id") String id, @Context HttpServletResponse servletResponse) throws IOException {
        return Response.ok("HTTP post request with " + id).build();
    }

    @GET
    @Path("{id : \\d+}") //support digit only
    public Response getUserById(@PathParam("id") String id) {

        return Response.status(200).entity("getUserById is called, id : " + id).build();
    }

    @GET
    @Path("/books/{isbn : \\d+}")
    public Response getUserBookByISBN(@PathParam("isbn") String isbn) {

        return Response.ok("getUserBookByISBN is called, isbn : " + isbn, MediaType.TEXT_XML).build();

    }



}