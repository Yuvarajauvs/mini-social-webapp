package com.example.Yuva.ServiceImpl;

import com.example.Yuva.Model.Like;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Repo.LikeRepo;
import com.example.Yuva.Repo.PostRepo;
import com.example.Yuva.Repo.UsersRepo;
import com.example.Yuva.Service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepo likeRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UsersRepo userRepo;

    @Override
    public String toggleLike(Long postId, Long userId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Users user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        return likeRepo.findByPostAndUser(post, user).map(existingLike -> {
            likeRepo.delete(existingLike);
            return "Unliked";
        }).orElseGet(() -> {
            Like newLike = new Like(post, user);
            newLike.setTimestamp(LocalDateTime.now());
            likeRepo.save(newLike);
            return "Liked";
        });
    }

    @Override
    public Long getLikeCount(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return likeRepo.countByPost(post);
    }
}
