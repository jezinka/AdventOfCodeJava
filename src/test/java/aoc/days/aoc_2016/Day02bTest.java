package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day02bTest {

    @Test
    void resolve_test() {
        //given:
        Day day = new Day02b(List.of("ULL",
                "RRDDD",
                "LURDL",
                "UUUUD"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals("5DB3", day.getResult());
    }
}