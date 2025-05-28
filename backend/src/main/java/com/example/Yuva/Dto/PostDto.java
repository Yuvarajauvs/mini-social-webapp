package com.example.Yuva.Dto;

import com.example.Yuva.Model.Like;

import java.time.LocalDateTime;
import java.util.Set;

public class PostDto {

    private Long pid;
    private String title;
    private String about;
    private String username;
    private Long userId;
    private Integer likeCount; // This will store the number of likes
    private LocalDateTime createdAt;

    // Other fields, getters, and setters...

    // Method to set the like count based on the Set<Like>
    public void setLikeCount(Set<Like> likes) {
        this.likeCount = (likes != null) ? likes.size() : 0; // Set like count based on size of the Set
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
