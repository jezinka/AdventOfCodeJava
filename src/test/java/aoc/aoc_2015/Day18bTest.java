package aoc.aoc_2015;

import aoc.days.aoc_2015.Day18b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static aoc.aoc_2015.Day18aTest.GRID;

class Day18bTest {

    @Test
    void resolve() {
        //given:
        Day18b day = new Day18b(GRID);
        day.setSteps(5);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(17L, day.getResult());
    }
}