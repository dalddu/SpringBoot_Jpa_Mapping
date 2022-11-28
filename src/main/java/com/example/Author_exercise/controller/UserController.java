package com.example.Author_exercise.controller;

import com.example.Author_exercise.domain.Response;
import com.example.Author_exercise.domain.dto.UserDto;
import com.example.Author_exercise.domain.dto.UserJoinRequest;
import com.example.Author_exercise.domain.dto.UserJoinResponse;
import com.example.Author_exercise.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> join(@RequestBody UserJoinRequest userJoinRequest) {
        UserDto userDto = userService.join(userJoinRequest);
        return  Response.success(new UserJoinResponse(userDto.getUserName(),userDto.getEmail()));

    }
}