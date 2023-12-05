package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03aTest {

    @Test
    void resolve_test() {
        Day day = new Day03a(List.of(
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
        Assertions.assertEquals(4361, day.getResult());
    }

}
