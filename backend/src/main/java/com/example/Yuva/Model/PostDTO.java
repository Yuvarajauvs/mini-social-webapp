package com.example.Yuva.Model;

import java.time.LocalDateTime;

public class PostDTO {

    private Long pid;
    private String title;
    private String about;
    private String username;
    private Long likeCount;
    private Long userId;
    private LocalDateTime createdAt;

    // ✅ Full Constructor (use this if all data is required)
    public PostDTO(Long pid, String title, String about, String username, Long likeCount, Long userId, LocalDateTime createdAt) {
        this.pid = pid;
        this.title = title;
        this.about = about;
        this.username = username;
        this.likeCount = likeCount;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public PostDTO(Long pid, String title, String about, String username, LocalDateTime createdAt) {
        this.pid = pid;
        this.title = title;
        this.about = about;
        this.username = username;
        this.createdAt = createdAt;

    }

    public PostDTO(Long pid, String title, String about, String username, LocalDateTime createdAt, Long userId) {
        this.pid = pid;
        this.title = title;
        this.about = about;
        this.username = username;
        this.userId = userId;
        this.createdAt = createdAt;
    }


    // ✅ Getters and Setters
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

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
