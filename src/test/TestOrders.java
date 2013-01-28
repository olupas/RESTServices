package test;

/**
 * Created with IntelliJ IDEA.
 * User: olupas
 * Date: 1/25/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import model.order.Order;
import model.order.OrderRequest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.Date;

public class TestOrders {

    public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        // Get JSON
        System.out.println("ORDERS" + service.path("rest/api/").path("orders").accept(MediaType.APPLICATION_JSON).get(String.class));
        // PUT
        System.out.println("ORDER STATUS:" + service.path("rest/api/").path("orders").path("12345").accept(MediaType.TEXT_PLAIN).put(String.class));
        // Get JSON for application

        Order o = new Order();
        o.setOrderDate(new Date());
        o.setOrderNumber(12345);

        OrderRequest request = new OrderRequest();
        request.setOrder(o);

        System.out.println("UPDATE ORDER:" + service.path("rest/api/").path("orders").path("12345.xml").entity(request).accept(MediaType.TEXT_PLAIN).post(String.class));
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:9090/jaxrs/").build();
    }

}
