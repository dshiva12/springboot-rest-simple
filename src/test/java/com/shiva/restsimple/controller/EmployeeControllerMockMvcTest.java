package com.shiva.restsimple.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Approach 1: Test using MockMvc to perform REST calls
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getTest() throws Exception {
        this.mockMvc.perform(get("/api/v1/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString().equalsIgnoreCase("working");
    }
}