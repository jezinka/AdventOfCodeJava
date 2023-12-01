package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day01bTest {

    @Test
    void resolve_test() {
        Day day = new Day01b(List.of(
                "two1nine",
                "eightwothree",
                "abcone2threexyz",
                "xtwone3four",
                "4nineeightseven2",
                "zoneight234",
                "7pqrstsixteen"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(281, day.getResult());
    }

}
