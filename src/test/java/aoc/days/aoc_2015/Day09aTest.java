package aoc.days.aoc_2015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day09aTest {

    @Test
    void resolve_all() {
        //given:
        Day09a day = new Day09a(
                List.of("London to Dublin = 464",
                        "London to Belfast = 518",
                        "Dublin to Belfast = 141"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(605, day.getResult());
    }
}