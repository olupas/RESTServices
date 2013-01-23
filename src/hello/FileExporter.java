package hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Ovidiu Lupas
 * Date: 23.01.2013
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 */
@Path("/exporter")
public class FileExporter {

    @GET
    @Path("/pdf/{fileName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getPdfFile(@PathParam("fileName") String fileName) {

        File file = new File("C://Docs//" + fileName + ".pdf");
        if (!file.exists()) {
            return Response.serverError().build();
        }
        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=fileName.pdf");
        return response.build();

    }

    @GET
    @Path("/zip/{fileName}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getZipFile(@PathParam("fileName") String fileName) {

        File file = new File("C://Docs//" + fileName + ".zip");

        if (!file.exists()) {
            return Response.serverError().build();
        }
        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=fileName.pdf");
        return response.build();

    }

}
