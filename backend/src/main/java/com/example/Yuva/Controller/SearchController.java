package com.example.Yuva.Controller;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SearchController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<?> searchUsers(@RequestParam("query") String query) {
        List<UsersDto> users = userService.searchByUsername(query);

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "User not found"));
        }

        List<Post> posts = new ArrayList<>();
        for (UsersDto user : users) {
            List<Post> userPosts = userService.getPostsByUserId(user.getUserId());
            posts.addAll(userPosts);  // Collect all posts related to the user
        }

        if (posts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "No posts found for this user"));
        }

        return ResponseEntity.ok(posts);  // Return the posts related to the user
    }
}
