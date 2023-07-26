package aoc.aoc_2015;

import aoc.days.aoc_2015.Day19a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day19aTest {

    @Test
    void resolve() {
        //given:
        Day19a day = new Day19a();
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(4, day.getResult());
    }
}