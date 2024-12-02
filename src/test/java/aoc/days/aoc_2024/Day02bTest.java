package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day02bTest {

    @Test
    void test() {
        Day day = new Day02b(List.of("7 6 4 2 1",
                "1 2 7 8 9",
                "9 7 6 2 1",
                "1 3 2 4 5",
                "8 6 4 4 1",
                "1 3 6 7 9"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(4L, day.getResult());
    }

}
