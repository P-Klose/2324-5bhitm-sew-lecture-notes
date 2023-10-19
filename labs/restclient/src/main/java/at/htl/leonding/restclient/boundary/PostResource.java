package at.htl.leonding.restclient.boundary;

import at.htl.leonding.restclient.entity.Post;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Set;

@Path("/post")
public class PostResource {

    @RestClient
    PostService postService;

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Post> id(Long id) {
        return postService.getById(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getAll() {
        return postService.getAll();
    }

    @GET
    @Path("/title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Post> title(String title) {
        return postService.getByTitle(title);
    }
}
