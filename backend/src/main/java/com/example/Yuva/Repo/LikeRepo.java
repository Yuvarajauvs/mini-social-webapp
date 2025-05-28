package com.example.Yuva.Repo;

import com.example.Yuva.Model.Like;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Long> {
    boolean existsByPostAndUser(Post post, Users user);
    Optional<Like> findByPostAndUser(Post post, Users user);
    Long countByPost(Post post);
}
