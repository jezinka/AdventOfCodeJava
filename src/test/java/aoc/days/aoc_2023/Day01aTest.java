package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day01aTest {

    @Test
    void resolve_test() {
        Day day = new Day01a(List.of("1abc2",
                "pqr3stu8vwx",
                "a1b2c3d4e5f",
                "treb7uchet"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(142, day.getResult());
    }

}
