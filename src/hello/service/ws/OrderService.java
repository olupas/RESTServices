package hello.service.ws;

/**
 * Created with IntelliJ IDEA.
 * User: olupas
 * Date: 1/25/13
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */

import model.order.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.Date;

@Path("/api/orders")
public class OrderService {

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public OrdersResponse getOrders() {

        OrdersResponse response = new OrdersResponse();
        Customer customer = new Customer();
        LineItem lineItem1;
        LineItem lineItem2;

        // customer
        customer.setCustomerNumber(12345);
        customer.setFirstName("Ryan");
        customer.setLastName("de Laplante");
        response.setCustomer(customer);

        // first order
        Order order1 = new Order();
        order1.setOrderNumber(54321);
        order1.setOrderDate(new Date());

        lineItem1 = new LineItem();
        lineItem1.setSku(77777);
        lineItem1.setDescription("winning lottery ticket");
        lineItem1.setQuantity((short) 10);
        lineItem1.setUnitPrice(5.00F);

        lineItem2 = new LineItem();
        lineItem2.setSku(12121212);
        lineItem2.setDescription("Real World Java EE Patterns Rethinking " +
                "Best Practices");
        lineItem2.setQuantity((short) 1);
        lineItem2.setUnitPrice(40.40F);

        order1.setLineItems(new LineItem[]{lineItem1, lineItem2});
        response.getOrders().add(order1);

        // second order
        Order order2 = new Order();
        order2.setOrderNumber(12345);
        order2.setOrderDate(new Date());

        lineItem1 = new LineItem();
        lineItem1.setSku(787878);
        lineItem1.setDescription("JavaServer Faces 2.0, The Complete " +
                "Reference");
        lineItem1.setQuantity((short) 10);
        lineItem1.setUnitPrice(31.49F);

        lineItem2 = new LineItem();
        lineItem2.setSku(1111111);
        lineItem2.setDescription("Beginning Java EE 6 with GlassFish 3, " +
                "Second Edition");
        lineItem2.setQuantity((short) 1);
        lineItem2.setUnitPrice(41.73F);

        order2.setLineItems(new LineItem[]{lineItem1, lineItem2});
        response.getOrders().add(order2);

        return response;
    }


    @PUT
    @Path("{orderNumber}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response checkOrder(@PathParam("orderNumber") String orderNumber) throws OrderNotFoundException {

        ResponseBuilder response;

        if ("12345".equals(orderNumber)) {
            response = Response.status(Response.Status.ACCEPTED).entity(
                    "Saved changes to order '" + orderNumber + "'.");
        } else {
            throw new OrderNotFoundException("Order number '" + orderNumber + "' does not exist.");
        }
        return response.build();
    }


    @POST
    @Path("{orderNumber}.xml")
    @Produces(MediaType.TEXT_PLAIN)
    public Response updateOrder(@PathParam("orderNumber") String orderNumber, OrderRequest request) throws OrderNotFoundException {

        ResponseBuilder response;

        if ("1235".equals(orderNumber)) {
            response = Response.status(Response.Status.ACCEPTED).entity("Saved changes to order '" + request.getOrder().getOrderNumber() + "'.");
        } else {
            throw new OrderNotFoundException("Order number '" + orderNumber +
                    "' does not exist.");
        }
        return response.build();
    }


}

