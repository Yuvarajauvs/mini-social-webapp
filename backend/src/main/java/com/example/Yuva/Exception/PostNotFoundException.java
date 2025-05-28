package com.example.Yuva.Exception;

public class PostNotFoundException extends RuntimeException{
     public PostNotFoundException(String message){
        super(message);
    }
}
