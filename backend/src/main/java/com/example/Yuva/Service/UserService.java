package com.example.Yuva.Service;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Model.LoginRequestDTO;
import com.example.Yuva.Model.Post;
import com.example.Yuva.Model.Users;

import java.util.List;

public interface UserService {
    String registerUser(UsersDto userDTO); // Create new account
    Users authenticate(LoginRequestDTO loginRequestDTO);  // login metthod
    UsersDto getUserById(Long userId);  // Search particular user by using userid
   List<UsersDto> searchByName(String query);

   // Search Controller methods

    List<Post> getPostsByUserId(Long userId);

    List<UsersDto> searchByUsername(String query);

//    Users findById(Long userId);

//    List<Users> searchUser(String query);
}
