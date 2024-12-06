package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day06aTest {

    @Test
    void test() {
        Day day = new Day06a(List.of(
                "....#.....",
                ".........#",
                "..........",
                "..#.......",
                ".......#..",
                "..........",
                ".#..^.....",
                "........#.",
                "#.........",
                "......#..."));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(41, day.getResult());
    }

}
