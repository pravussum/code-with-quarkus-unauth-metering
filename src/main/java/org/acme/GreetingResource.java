package org.acme;

import io.smallrye.mutiny.Uni;
import javax.annotation.security.DenyAll;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello(@PathParam("id") String id) {
        return Uni.createFrom().item("Hello from RESTEasy Reactive: " + id);
    }


	@GET
	@Path("/authenticated/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@DenyAll
	public Uni<String> helloAuthenticated(@PathParam("id") String id) {
		return Uni.createFrom().item("Hello from RESTEasy Reactive: " + id);
	}
}