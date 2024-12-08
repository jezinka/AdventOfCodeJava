package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day08bTest {

    @Test
    void test() {
        Day day = new Day08b(List.of(
                "............",
                "........0...",
                ".....0......",
                ".......0....",
                "....0.......",
                "......A.....",
                "............",
                "............",
                "........A...",
                ".........A..",
                "............",
                "............"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(34, day.getResult());
    }

}
