package com.example.Yuva.Controller;

import com.example.Yuva.Model.Like;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Repo.LikeRepo;
import com.example.Yuva.Repo.PostRepo;
import com.example.Yuva.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/likes")
@CrossOrigin(origins = "http://localhost:5173")
public class LikeController {

    @Autowired
    private LikeRepo likeRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UsersRepo userRepo;

    // ✅ Count likes for a post
    @GetMapping("/{postId}/count")
    public Long getLikeCount(@PathVariable Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return likeRepo.countByPost(post);
    }

    // ✅ Check if a user has liked the post
    @GetMapping("/{postId}/liked/{userId}")
    public boolean isPostLikedByUser(@PathVariable Long postId, @PathVariable Long userId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Users user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return likeRepo.existsByPostAndUser(post, user);
    }

    // ✅ Like a post
    @PostMapping("/{postId}/like/{userId}")
    public String likePost(@PathVariable Long postId, @PathVariable Long userId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Users user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        if (!likeRepo.existsByPostAndUser(post, user)) {
            Like like = new Like();
            like.setPost(post);
            like.setUser(user);
            like.setTimestamp(LocalDateTime.now());
            likeRepo.save(like);
            return "Post liked successfully!";
        } else {
            return "Post already liked!";
        }
    }

    // ✅ Unlike a post
    @DeleteMapping("/{postId}/unlike/{userId}")
    public String unlikePost(@PathVariable Long postId, @PathVariable Long userId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Users user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        Optional<Like> like = likeRepo.findByPostAndUser(post, user);
        if (like.isPresent()) {
            likeRepo.delete(like.get());
            return "Post unliked successfully!";
        } else {
            return "Like not found!";
        }
    }
}
