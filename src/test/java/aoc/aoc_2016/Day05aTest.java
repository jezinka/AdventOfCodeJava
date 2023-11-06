package aoc.aoc_2016;

import aoc.days.Day;
import aoc.days.aoc_2016.Day05a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day05aTest {

    @Test
    void resolve_test() {
        //given:
        Day day = new Day05a(List.of("abc"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals("18f47a30", day.getResult());
    }
}