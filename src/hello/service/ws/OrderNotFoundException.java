package hello.service.ws;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: olupas
 * Date: 1/25/13
 * Time: 5:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderNotFoundException extends WebApplicationException {
    public OrderNotFoundException(String message) {
        super(Response.status(Response.Status.NOT_FOUND).entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}