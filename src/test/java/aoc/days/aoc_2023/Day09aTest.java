package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day09aTest {

    @Test
    void resolve_test() {
        Day day = new Day09a(List.of(
                "0 3 6 9 12 15",
                "1 3 6 10 15 21",
                "10 13 16 21 30 45"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(114, day.getResult());
    }
}
