package aoc.aoc_2015;

import aoc.days.Day;
import aoc.days.aoc_2015.Day02a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day02aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"2x3x4|58", "1x1x10|43"})
    void resolve_test(String input, String output) {
        //given:
        Day02a day = new Day02a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.valueOf(output), day.getResult());
    }

    @Test
    void resolve_test_list() {
        //given:
        Day day = new Day02a(List.of("2x3x4", "1x1x10"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(101L, day.getResult());
    }
}