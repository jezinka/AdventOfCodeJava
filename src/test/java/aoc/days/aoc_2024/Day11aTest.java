package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class Day11aTest {

    @Test
    void test() {
        Day day = new Day11a(List.of("0 1 10 99 999"), 1);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(7L, day.getResult());
    }

    @ParameterizedTest
    @CsvSource(value = {"6|22"/*, "25|55312"*/}, delimiter = '|')
    void test_6(String blinks, String result) {
        Day day = new Day11a(List.of("125 17"), Integer.parseInt(blinks));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.parseLong(result), day.getResult());
    }
}
