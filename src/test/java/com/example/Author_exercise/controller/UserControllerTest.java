package com.example.Author_exercise.controller;

import com.example.Author_exercise.domain.dto.UserDto;
import com.example.Author_exercise.domain.dto.UserJoinRequest;
import com.example.Author_exercise.exception.ErrorCode;
import com.example.Author_exercise.exception.HospitalReviewAppException;
import com.example.Author_exercise.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("회원가입 성공")
    void join_success() throws Exception {
        UserJoinRequest userJoinRequest = UserJoinRequest.builder()
                .userName("soonmin")
                .password("1234")
                .email("123@!@3")
                .build();

        when(userService.join(any())).thenReturn(mock(UserDto.class));

        mockMvc.perform(post("/api/v1/users/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userJoinRequest)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원가입 실패")
    void join_fail() throws Exception {
        UserJoinRequest userJoinRequest = UserJoinRequest.builder()
                .userName("soonmin")
                .password("1234")
                .email("123@!@3")
                .build();

        when(userService.join(any())).thenThrow(new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME,""));

        mockMvc.perform(post("/api/v1/users/join")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(userJoinRequest)))
                .andDo(print())
                .andExpect(status().isConflict());
    }
}