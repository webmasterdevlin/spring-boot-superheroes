package com.example.superheroes.user.controller;

import com.example.superheroes.user.dto.UserDto;
import com.example.superheroes.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private final Faker faker = new Faker();
    private UserDto userFixture;

    @BeforeEach()
    public void setUp() {
        userFixture = new UserDto();

        String name = String.format("%s", faker.name().fullName());
        String email = String.format("%s@startup.ai",
                StringUtils.trimAllWhitespace(name.trim().toLowerCase()));

        userFixture.setEmail(email);
        userFixture.setPassword(faker.internet().password());
        userFixture.setMobileNumber(faker.phoneNumber().cellPhone());
    }

    @Test
    void canRegisterUser() throws Exception {
        ObjectMapper map = new ObjectMapper();
        String jsonString = map.writeValueAsString(userFixture);

        given(userService.createUser(userFixture, userFixture.getPassword()))
                .willReturn(userFixture);

        mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(jsonString))
                .andExpect(status().isCreated());
    }
}
