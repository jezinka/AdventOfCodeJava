package aoc.days.aoc_2015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day10aTest {

    @Test
    void resolve() {
        //given:
        Day10a day = new Day10a(List.of("1"));
        day.setRounds(5);

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals("312211".length(), day.getResult());
    }
}