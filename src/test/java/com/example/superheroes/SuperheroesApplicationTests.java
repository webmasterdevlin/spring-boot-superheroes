package com.example.superheroes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

@DataJpaTest
class SuperheroesApplicationTests {

    Calculator underTest = new Calculator();

    @Test
    void itShouldAddTwoNumbers() {
        // given
        int x = 10;
        int y = 20;

        // when
        int result = underTest.add(x, y);

        // then
        int expected = 30;
        assertThat(result).isEqualTo(expected);
    }

    static class Calculator {

        int add(int a, int b) {
            return a + b;
        }
    }
}
