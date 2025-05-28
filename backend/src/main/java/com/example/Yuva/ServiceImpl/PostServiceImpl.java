package com.example.Yuva.ServiceImpl;

import com.example.Yuva.Dto.PostDto;
import com.example.Yuva.Exception.PostNotFoundException;
import com.example.Yuva.Exception.UserNotFoundException;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.PostDTO;
import com.example.Yuva.Model.PostRequest;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Repo.PostRepo;
import com.example.Yuva.Repo.UsersRepo;
import com.example.Yuva.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public PostDTO createPostFromRequest(PostRequest postRequest) {
        // Fetch the user
        Users user = usersRepo.findById(postRequest.getUserId())
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + postRequest.getUserId()));

        // Create post and set user and timestamp
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setAbout(postRequest.getAbout());
        post.setUsers(user);
        post.setCreatedAt(LocalDateTime.now()); // set time manually

        Post savedPost = postRepo.save(post);

        return new PostDTO(
                savedPost.getPid(),
                savedPost.getTitle(),
                savedPost.getAbout(),
                user.getUsername(),
                savedPost.getCreatedAt()
        );
    }
    @Override
    public List<PostDTO> getAllPosts() {
        return postRepo.findAll().stream()
                .map(post -> new PostDTO(post.getPid(), post.getTitle(), post.getAbout(),
                        post.getUsers().getUsername(), post.getCreatedAt(), post.getUsers().getUserId()))
                .collect(Collectors.toList());
    }




    @Override //getPostsByUser
    public PostDTO getPostById(Long pid) {
        Post post = postRepo.findById(pid)
                .orElseThrow(() -> new PostNotFoundException("Post not found"));
        return new PostDTO(post.getPid(), post.getTitle(), post.getAbout(),
                post.getUsers().getUsername(), post.getCreatedAt());
    }

    @Override //getPostsByUserId
    public List<PostDTO> getPostsByUserId(Long userId) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        List<Post> posts = postRepo.findByUsers(user); // or use findByUsersUserId(userId)
        return posts.stream().map(post -> new PostDTO(
                post.getPid(),
                post.getTitle(),
                post.getAbout(),
                post.getUsers().getUsername(),
                post.getCreatedAt(),
                post.getUsers().getUserId()
        )).toList();
    }

    @Override
    public List<PostDTO> getUserPostsByUserId(Long userId) {
        List<Post> posts = postRepo.findByUsersUserId(userId);
        return posts.stream().map(post -> new PostDTO(
                post.getPid(),
                post.getTitle(),
                post.getAbout(),
                post.getUsers().getUsername(),
                post.getCreatedAt(),
                post.getUsers().getUserId()
        )).toList();
    }


    public PostDto convertToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setPid(post.getPid());
        dto.setTitle(post.getTitle());
        dto.setAbout(post.getAbout());
        dto.setUsername(post.getUsers().getUsername());
        dto.setUserId(post.getUsers().getUserId());
        dto.setLikeCount(post.getLikes() != null ? post.getLikes().size() : 0); // ✅ Like count
        dto.setCreatedAt(post.getCreatedAt());
        return dto;
    }




//    public List<PostDTO> GetUserPostsByUserId(Long userId) {  // getPostsByUserId
//        Users user = usersRepo.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//
//        List<Post> posts = postRepo.findByUsers(user);
//        return posts.stream().map(post -> new PostDTO(
//                post.getPid(),
//                post.getTitle(),
//                post.getAbout(),
//                post.getUsers().getUsername(),
//                post.getCreatedAt(),
//                post.getUsers().getUserId()
//        )).toList();
//
//    }

//    @Override
//    public UsersDto getUserByPostId(Long pid) {
//        // Fetch post by id
//        Post post = postRepo.findById(pid)
//                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + pid));
//
//        // Check if post's user is null
//        if (post.getUsers() == null) {
//            throw new ResourceNotFoundException("User associated with post is null");
//        }        Users users = post.getUsers();
//        System.out.println("Hello " + users);
//        return new UsersDto(users);
//
//        // Return the user details from post's user
//    //    return new UsersDto(post.getUsers());
//    }

}
