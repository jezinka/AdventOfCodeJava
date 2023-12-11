package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day11aTest {

    @Test
    void resolve_test() {
        Day day = new Day11a(List.of(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(374L, day.getResult());
    }
}
