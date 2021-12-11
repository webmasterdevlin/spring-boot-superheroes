package com.example.superheroes.villain.controller;

import com.example.superheroes.villain.model.Villain;
import com.example.superheroes.villain.service.VillainService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AllArgsConstructor
public class VillainControllerTest {
    @MockBean
    private final VillainService villainService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void canReturnAllVillains() throws Exception {
        given(villainService.findAllVillains()).willReturn(List.of(new Villain()));

        mockMvc.perform(get("/api/v1/villains")).andExpect(status().isOk());
    }
}
