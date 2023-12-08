package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day08bTest {

    @Test
    void resolve_test() {
        Day day = new Day08b(List.of(
                "LR",
                "",
                "11A = (11B, XXX)",
                "11B = (XXX, 11Z)",
                "11Z = (11B, XXX)",
                "22A = (22B, XXX)",
                "22B = (22C, 22C)",
                "22C = (22Z, 22Z)",
                "22Z = (22B, 22B)",
                "XXX = (XXX, XXX)"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(6L, day.getResult());
    }
}
