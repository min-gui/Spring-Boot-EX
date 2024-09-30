package com.demo.api.controller;

import com.demo.api.model.res.TestResponse;
import com.demo.api.service.TestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = MainTestController.class)
class MainTestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TestService testService;

    @Test
    public void test_result_code_검증() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/test2")
                        .param("request", "testRequest") // 요청 파라미터 설정
                        .contentType(MediaType.APPLICATION_JSON)) // Content-Type 설정
                .andExpect(MockMvcResultMatchers.status().isOk()) // 응답 상태 코드가 200인지 확인
                .andExpect(MockMvcResultMatchers.jsonPath("$.resultCode").value("000"));

     }

}