package io.guiders.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EssayControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void insertPost() throws Exception {

        String requestData = "{\"title\": \"test\", \"content\": \"test\"}";

        mockMvc.perform(post("/essay")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestData))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void getPostList() throws Exception {
        mockMvc.perform(get("/essay"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}