package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day05bTest {

    @Test
    void resolve_test() {
        //given:
        Day day = new Day05b(List.of("abc"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals("05ace8e3", day.getResult());
    }
}