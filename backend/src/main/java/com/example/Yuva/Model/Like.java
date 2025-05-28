package com.example.Yuva.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")  // Specify the new column name
    private Long likeId;
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore  // Prevent deep recursion with Post
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore  // Prevent deep recursion with User
    private Users user;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Getters and setters


    public Like() {
    }

    public Like(Post post, Users user) {
        this.post = post;
        this.user = user;
    }

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
