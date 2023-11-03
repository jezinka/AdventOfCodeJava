package aoc.aoc_2016;

import aoc.days.Day;
import aoc.days.aoc_2016.Day02a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day02aTest {

    @Test
    void resolve_test() {
        //given:
        Day day = new Day02a(List.of("ULL",
                "RRDDD",
                "LURDL",
                "UUUUD"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals("1985", day.getResult());
    }
}