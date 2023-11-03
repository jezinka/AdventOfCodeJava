package aoc.aoc_2016;

import aoc.days.Day;
import aoc.days.aoc_2016.Day03a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day03aTest {

    @Test
    void resolve_test_false() {
        //given:
        Day day = new Day03a(List.of("5 10 25"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(0, day.getResult());
    }

    @Test
    void resolve_test_true() {
        //given:
        Day day = new Day03a(List.of("3 4 5"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1, day.getResult());
    }
}