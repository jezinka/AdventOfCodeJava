package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day11bTest {

    @Test
    void resolve10_test() {
        Day day = new Day11b(List.of(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."), 10);

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1030L, day.getResult());
    }

    @Test
    void resolve100_test() {
        Day day = new Day11b(List.of(
                "...#......",
                ".......#..",
                "#.........",
                "..........",
                "......#...",
                ".#........",
                ".........#",
                "..........",
                ".......#..",
                "#...#....."), 100);

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(8410L, day.getResult());
    }
}
