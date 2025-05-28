package com.example.Yuva.Dto;
import com.example.Yuva.Model.Users;
public class UsersDto {
    private Long userId;
    private String email;
    private String username;
    private String name;
    private String phone;
    private String about;
    private String password;

    public Long getUserId() { return userId;  }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone;  }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public UsersDto() { }

    public UsersDto(Long userId, String email, String username, String name, String phone, String about, String password) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.about = about;
        this.password = password;
    }
    public UsersDto(Users user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.name = user.getName();
        this.phone = user.getPhone();
        this.about = user.getAbout();
        // Password usually not exposed in DTO, but if you need it, uncomment:
        // this.password = user.getPassword();
    }

}

//
//import com.example.Yuva.Model.Users;
//
//public class UsersDto {
//
//    private Long userId;
//    private String email;
//    private String username;
//    private String name;
//    private String phone;
//    private String about;
//    private String password;
//
//    public UsersDto(Long userId, String username, String about) {
//    }
//
////    public UsersDto(Long userId, String email, String username, String name, String phone, String about, String password) {
////        this.userId = userId;
////        this.email = email;
////        this.username = username;
////        this.name = name;
////        this.phone = phone;
////        this.about = about;
////        this.password = password;
////    }
////
//
//    // ✅ FIXED constructor
//    public UsersDto(Users user) {
//        this.userId = user.getUserId();
//        this.email = user.getEmail();
//        this.username = user.getUsername();
//        this.name = user.getName();
//        this.phone = user.getPhone();
//        this.about = user.getAbout();
//        this.password = user.getPassword();
//    }
//
//
//    public UsersDto(String error, String userNotFound) {
//    }
//
//
//
//    // Getters and Setters
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
//
//    public String getAbout() {
//        return about;
//    }
//
//    public void setAbout(String about) {
//        this.about = about;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//}
