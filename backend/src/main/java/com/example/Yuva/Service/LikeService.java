package com.example.Yuva.Service;

public interface LikeService {
    String toggleLike(Long postId, Long userId);
    Long getLikeCount(Long postId);
}
