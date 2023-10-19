package at.htl.leonding.restclient.boundary;

import at.htl.leonding.restclient.PostRepository;
import at.htl.leonding.restclient.entity.Post;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.Location;
import io.quarkus.qute.Template;
import io.quarkus.qute.TemplateInstance;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("/post")
public class PostResource {

    @Inject
    PostRepository postRepository;
    @RestClient
    PostService postService;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance post(Post post);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance get(@PathParam("id") Long id) {
        //var post = postRepository.findById(id);
        return Templates.post(new Post(1L,1L,"t","b"));
    }

    @GET
    @Path("/id/{id}")
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response id(Long id) {
        return Response.ok(insertOrUpdate(id)).build();
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

    @GET
    @Path("/body/{body}")
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Post> body(String body) {
        return postService.getByBody(body);
    }

    private Post insertOrUpdate(Long id) {
        Post post = postService.getById(id).iterator().next();
        if (postRepository.findById(id) != null){
            postRepository.update("userId = ?1, body = ?2, title = ?3 WHERE id = ?4", post.getUserId(), post.getBody(), post.getTitle(), id);
        }else {
            postRepository.persist(post);
        }
        return post;
    }
}
