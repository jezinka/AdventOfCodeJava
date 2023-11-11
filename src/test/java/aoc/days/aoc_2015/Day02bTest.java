package aoc.days.aoc_2015;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day02bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"2x3x4|34", "1x1x10|14"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day02b(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.valueOf(output), day.getResult());
    }

    @Test
    void resolve_test_list() {
        //given:
        Day02b day = new Day02b(List.of("2x3x4", "1x1x10"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(48L, day.getResult());
    }
}