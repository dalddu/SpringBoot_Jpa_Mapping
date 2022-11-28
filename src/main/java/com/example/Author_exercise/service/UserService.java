package com.example.Author_exercise.service;

import com.example.Author_exercise.domain.dto.UserDto;
import com.example.Author_exercise.domain.dto.UserJoinRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public UserDto join(UserJoinRequest request) {
        return new UserDto("","","");
    }
}