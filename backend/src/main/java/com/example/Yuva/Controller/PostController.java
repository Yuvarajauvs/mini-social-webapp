package com.example.Yuva.Controller;

import com.example.Yuva.Dto.PostDto;
import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Model.PostDTO;
import com.example.Yuva.Model.PostRequest;
import com.example.Yuva.Service.PostService;
import com.example.Yuva.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    // Create a new post
    @PostMapping("/create")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostRequest postRequest) {
        PostDTO postDTO = postService.createPostFromRequest(postRequest);
        return ResponseEntity.ok(postDTO);
    }

    // Get all posts
    @GetMapping("/all")
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        List<PostDTO> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get post by ID
    @GetMapping("/{pid}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long pid) {
        PostDTO postDTO = postService.getPostById(pid);
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(postService.getPostsByUserId(userId));
    }

    @GetMapping("/api/search")
    public ResponseEntity<?> searchUsers(@RequestParam("query") String query) {
        // Find users by name
        List<UsersDto> users = userService.searchByName(query);

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "User not found"));
        }

        // Assume the first user in the list is the one we want (if there are multiple users, you can modify this logic)
        UsersDto user = users.get(0);

        // Fetch posts by userId (you can use a method in your PostService or directly in the controller)
        List<PostDTO> posts = postService.getPostsByUserId(user.getUserId());

        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "No posts found for this user"));
        }

        // Return posts as the response
        return ResponseEntity.ok(posts);
    }

}