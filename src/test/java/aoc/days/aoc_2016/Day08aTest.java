package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day08aTest {

    @Test
    void resolve_test() {
        //given:
        Day day = new Day08a(List.of("rect 3x2", "rotate column x=1 by 1", "rotate row y=0 by 4", "rotate column x=1 by 1"), 7, 3);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(6L, day.getResult());
    }
}