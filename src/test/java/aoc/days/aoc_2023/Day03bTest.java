package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03bTest {

    @Test
    void resolve_test() {
        Day day = new Day03b(List.of(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(467835, day.getResult());
    }

}
