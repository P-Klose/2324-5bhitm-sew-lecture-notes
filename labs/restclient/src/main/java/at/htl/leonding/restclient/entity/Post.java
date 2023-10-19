package at.htl.leonding.restclient.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "Post.updateById", query = "UPDATE Post p SET p.userId = :userId, p.body = :body, p.title = :title WHERE p.id = :id")
})

public class Post {

    @Id
    private long userId;
    private long id;
    private String title;
    private String body;

    public Post(long userId, long id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post() {
    }

    public void setPost(Post newPost) {
        this.userId = newPost.getUserId();
        this.id = newPost.getId();
        this.title = newPost.getTitle();
        this.body = newPost.getBody();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
