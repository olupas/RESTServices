package test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 22.01.2013
 * Time: 23:06
 * To change this template use File | Settings | File Templates.
 */
public class TestHelloService {

      public static void main(String[] args) {
        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(getBaseURI());
        // Fluent interfaces
        System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(ClientResponse.class).toString());
        // Get plain text
        System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_PLAIN).get(String.class));
        // Get XML
        System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_XML).get(String.class));
        // The HTML
        System.out.println(service.path("rest").path("hello").accept(MediaType.TEXT_HTML).get(String.class));

      }

      private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost:8080/jaxrs").build();
      }

}
