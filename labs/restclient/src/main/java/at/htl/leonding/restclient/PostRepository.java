package at.htl.leonding.restclient;

import at.htl.leonding.restclient.entity.Post;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.stream.Stream;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {

    @Override
    public void persist(Post post) {
        PanacheRepository.super.persist(post);
    }

    @Override
    public void persist(Stream<Post> entities) {
        PanacheRepository.super.persist(entities);
    }
}
