package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day04aTest {

    @Test
    void test() {
        Day day = new Day04a(List.of(
                "MMMSXXMASM",
                "MSAMXMSMSA",
                "AMXSXMAAMM",
                "MSAMASMSMX",
                "XMASAMXAMM",
                "XXAMMXXAMA",
                "SMSMSASXSS",
                "SAXAMASAAA",
                "MAMMMXMMMM",
                "MXMXAXMASX"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(18, day.getResult());
    }

}
