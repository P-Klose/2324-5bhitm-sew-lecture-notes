package at.htl.leonding.restclient;

import at.htl.leonding.restclient.entity.Post;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.stream.Stream;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

}
