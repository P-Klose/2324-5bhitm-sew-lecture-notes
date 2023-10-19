package at.htl.leonding.restclient.boundary;

import at.htl.leonding.restclient.entity.Post;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.util.List;
import java.util.Set;

@Path("/posts")
@RegisterRestClient(configKey = "posts-api")
public interface PostService {

    @GET
    Set<Post> getById(@QueryParam("id") Long id);

    @GET
    List<Post> getAll();

    @GET
    Set<Post> getByTitle(@QueryParam("title") String title);
    @GET
    Set<Post> getByBody(@QueryParam("body") String body);

}
