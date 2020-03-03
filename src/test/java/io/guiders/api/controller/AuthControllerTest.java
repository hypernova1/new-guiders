package io.guiders.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void join() throws Exception {

        mockMvc.perform(post("/auth/join")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\": \"hypemova@naver.com\", \"name\": \"sam\", \"password\": \"1111\", \"memberType\" : \"F\" }"))
                .andDo(print())
                .andExpect(status().isCreated());

    }

    @Test
    public void login() throws Exception {
        mockMvc.perform(post("/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"email\": \"chtlstjd01@gmail.com\", \"password\": \"1111\" }"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
