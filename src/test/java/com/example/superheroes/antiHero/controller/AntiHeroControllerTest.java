package com.example.superheroes.antiHero.controller;

import com.example.superheroes.antiHero.entity.AntiHeroEntity;
import com.example.superheroes.antiHero.service.AntiHeroService;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AntiHeroControllerTest {

    @MockBean
    private AntiHeroService service;

    @Autowired
    private MockMvc mockMvc;

    private final Faker faker = new Faker();
    private List<AntiHeroEntity> antiHeroesFixture;

    @BeforeEach()
    public void setUp() {
        var antiHero1 = new AntiHeroEntity();
        antiHero1.setId(UUID.randomUUID());
        antiHero1.setFirstName(faker.name().firstName());
        antiHero1.setLastName(faker.name().lastName());
        antiHero1.setHouse(faker.gameOfThrones().house());
        antiHero1.setKnownAs(faker.superhero().name());

        var antiHero2 = new AntiHeroEntity();
        antiHero2.setId(UUID.randomUUID());
        antiHero2.setFirstName(faker.name().firstName());
        antiHero2.setLastName(faker.name().lastName());
        antiHero2.setHouse(faker.gameOfThrones().house());
        antiHero2.setKnownAs(faker.superhero().name());

        antiHeroesFixture = List.of(antiHero1, antiHero2);
    }

    @Test
    void getAntiHeroes_NoJWT_status403() throws Exception {
        given(service.findAllAntiHeroes()).willReturn(antiHeroesFixture);

        mockMvc.perform(get("/api/v1/anti-heroes"))
                .andExpect(status().isForbidden());
    }
}
