package com.example.Yuva.ServiceImpl;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Exception.InvalidCredentialsException;
import com.example.Yuva.Model.LoginRequestDTO;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Repo.PostRepo;
import com.example.Yuva.Repo.UsersRepo;
import com.example.Yuva.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepo userRepo;
    @Autowired
    private PostRepo postRepo;

    @Override
    public String registerUser(UsersDto userDTO) {
        if (userRepo.findByEmail(userDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists!");
        }
        Users user = new Users();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setName(userDTO.getName());
        user.setPhone(userDTO.getPhone());
        user.setAbout(userDTO.getAbout());
        userRepo.save(user);
        return "User registered successfully";
    }

    @Override
    public Users authenticate(LoginRequestDTO loginRequestDTO) {
        Users user = userRepo.findByEmail(loginRequestDTO.getEmail());
        if (user != null && user.getPassword().equals(loginRequestDTO.getPassword())) {
            return user;
        }
        throw new InvalidCredentialsException("Invalid credentials");
    }

    @Override
    public UsersDto getUserById(Long userId) { //getUserById
        Users user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UsersDto(user);
    }

    @Override
    public List<UsersDto> searchByName(String query) {
        if (query !=null && !query.isEmpty()) {
            return userRepo.searchByName(query);
        }
        return null;
    }


  public List<UsersDto> searchByUsername(String query) {
        if (query != null && !query.isEmpty()) {
            return userRepo.searchByUsername(query);
        }
        return Collections.emptyList();
    }
    // Method to get posts for a specific user by userId
    public List<Post> getPostsByUserId(Long userId) {
        return postRepo.findByUsersUserId(userId);
    }


//    @Override
//    public Users findById(Long userId) {
//        return userRepo.findById(userId)
//                .orElseThrow(() -> new RuntimeException("User not found"));
//    }
////
//    public List<Users> searchUser(String query) {
//        return userRepo.searchByName(query);
//    }


}
