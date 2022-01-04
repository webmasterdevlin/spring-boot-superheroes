package com.example.superheroes.villain.controller;

import com.example.superheroes.mockdata.MockData;
import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.service.VillainService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VillainControllerTest {
    @MockBean
    private VillainService villainService;

    @Autowired
    private MockMvc mockMvc;

    private List<Villain> villainsFixture;

    @BeforeEach()
    public void setUp() throws IOException {
        villainsFixture = MockData.getVillains(); // using a json file to mock data
    }

    @Test
    void canReturnAllVillains() throws Exception {
        given(villainService.findAllVillains()).willReturn(villainsFixture);
        mockMvc.perform(get("/api/v1/villains"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(villainsFixture.get(0).getId().toString()));
    }
}
