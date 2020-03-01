package io.guiders.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureWebMvc
class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void join() throws Exception {

        mockMvc.perform(post("/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .param("{ \"email\": \"chtlstjd01@gmail.com\", \"name\": \"sam\", \"password\": \"1111\" }"))
                .andDo(print())
                .andExpect(status().isCreated());

    }

}