package com.example.Yuva.Repo;

import com.example.Yuva.Dto.PostDto;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByUsers_UserId(Long userId);
    List<Post> findByUsers(Users user);

    List<Post> findByUsersUserId(Long userId);
// This is for search controller userId //

}