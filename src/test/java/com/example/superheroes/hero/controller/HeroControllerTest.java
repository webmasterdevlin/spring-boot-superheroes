package com.example.superheroes.hero.controller;

import com.example.superheroes.hero.model.Hero;
import com.example.superheroes.hero.service.HeroService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@AllArgsConstructor
public class HeroControllerTest {
    @MockBean
    private final HeroService heroService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void canReturnHeroes() throws Exception {
        given(heroService.findAllHeroes()).willReturn(List.of(new Hero()));

        mockMvc.perform(get("/api/v1/heroes")).andExpect(status().isOk());
    }
}
