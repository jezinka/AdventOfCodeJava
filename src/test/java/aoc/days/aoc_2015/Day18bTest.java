package aoc.days.aoc_2015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day18bTest {

    @Test
    void resolve() {
        //given:
        Day18b day = new Day18b(Day18aTest.GRID);
        day.setSteps(5);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(17L, day.getResult());
    }
}