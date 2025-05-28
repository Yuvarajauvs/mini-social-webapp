package com.example.Yuva.Service;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.PostDTO;
import com.example.Yuva.Model.PostRequest;
import com.example.Yuva.Model.Users;

import java.util.List;

public interface PostService {
    PostDTO createPostFromRequest(PostRequest postRequest);
    List<PostDTO> getAllPosts();  // Get all posts
    PostDTO getPostById(Long pid);  // Get post by ID
    public List<PostDTO> getPostsByUserId(Long userId);

    List<PostDTO> getUserPostsByUserId(Long userId);

//    List<PostDTO> GetUserPostsByUserId (Long userId);

  //  List<Post> findByUsers(Users users);

//   UsersDto getUserByPostId(Long pid);
}
