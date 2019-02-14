package com.htzg.unittest.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class HelloControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private HelloController helloController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    void helloWorld() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello world!"));
    }

    @Test
    void json() throws Exception{
        MvcResult mvcResult = mockMvc.perform(get("/hello/json").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", Matchers.is("greetings")))
                .andExpect(jsonPath("$.value", Matchers.is("hello world!")))
                .andExpect(jsonPath("$.list", Matchers.hasSize(2)))
                .andExpect(jsonPath("$.list", Matchers.containsInAnyOrder("greetings", "hello world!")))
                .andExpect(jsonPath("$.hello.title", Matchers.is("greetings")))
                .andReturn();
        ;
        String result = mvcResult.getResponse().getContentAsString();

    }
}