package com.example.Yuva.Controller;

import com.example.Yuva.Dto.UsersDto;
import com.example.Yuva.Exception.InvalidCredentialsException;
import com.example.Yuva.Model.LoginRequestDTO;
import com.example.Yuva.Model.Users;
import com.example.Yuva.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UsersDto userDTO) {
        try {
            String message = userService.registerUser(userDTO);
            return ResponseEntity.ok(message);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequestDTO) {
        try {
            Users user = userService.authenticate(loginRequestDTO);
            return ResponseEntity.ok(user); // Return the user object on successful login
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.status(401).body("Invalid credentials: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Login failed: " + e.getMessage());
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable Long userId) {
        UsersDto userDto = userService.getUserById(userId);
        return ResponseEntity.ok(userDto);
    }


    @GetMapping("/api/search")
    public ResponseEntity<?> searchUsers(@RequestParam("query") String query) {
        List<UsersDto> users = userService.searchByName(query);

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("message", "User not found"));
        }

        return ResponseEntity.ok(users);
    }
//    @GetMapping("/user/{id}")
//    public ResponseEntity<Users> getUserDetails(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.getUserById(id));
//    }



}
