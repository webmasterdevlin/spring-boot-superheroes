package com.example.superheroes.hero.controller;

import com.example.superheroes.hero.model.Hero;
import com.example.superheroes.hero.service.HeroService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class HeroControllerTest {
    @MockBean
    private HeroService heroService;

    @Autowired
    private MockMvc mockMvc;

    private final Faker faker = new Faker();
    private List<Hero> heroesFixture;

    @BeforeEach()
    public void setUp() {
        var hero1 = new Hero();
        hero1.setId(UUID.randomUUID());
        hero1.setFirstName(faker.name().firstName());
        hero1.setLastName(faker.name().lastName());
        hero1.setHouse(faker.gameOfThrones().house());
        hero1.setKnownAs(faker.superhero().name());

        var hero2 = new Hero();
        hero2.setId(UUID.randomUUID());
        hero2.setFirstName(faker.name().firstName());
        hero2.setLastName(faker.name().lastName());
        hero2.setHouse(faker.gameOfThrones().house());
        hero2.setKnownAs(faker.superhero().name());

        heroesFixture = List.of(hero1, hero2);
    }

    @Test
    void canReturnHeroes() throws Exception {
        given(heroService.findAllHeroes()).willReturn(heroesFixture);

        mockMvc.perform(get("/api/v1/heroes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(heroesFixture.get(0).getId().toString()));
    }
}
