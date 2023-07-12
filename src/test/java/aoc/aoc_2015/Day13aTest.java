package aoc.aoc_2015;

import aoc.days.aoc_2015.Day13a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day13aTest {

    @Test
    void resolve() {
        //given:
        Day13a day = new Day13a();

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(330, day.getResult());
    }
}