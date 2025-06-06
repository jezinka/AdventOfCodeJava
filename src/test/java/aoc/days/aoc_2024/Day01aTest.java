package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day01aTest {

    @Test
    void test() {
        Day day = new Day01a(List.of("3   4",
                "4   3",
                "2   5",
                "1   3",
                "3   9",
                "3   3"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(11L, day.getResult());
    }

}
