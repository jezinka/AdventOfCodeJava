package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day06aTest {

    @Test
    void resolve_test() {
        Day day = new Day06a(List.of(
                "Time:      7  15   30",
                "Distance:  9  40  200"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(288, day.getResult());
    }

}
