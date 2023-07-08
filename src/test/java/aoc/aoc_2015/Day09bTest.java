package aoc.aoc_2015;

import aoc.days.aoc_2015.Day09b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day09bTest {

    @Test
    void resolve_all() {
        //given:
        Day09b day = new Day09b(
                List.of("London to Dublin = 464",
                        "London to Belfast = 518",
                        "Dublin to Belfast = 141"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(982, day.getResult());
    }
}