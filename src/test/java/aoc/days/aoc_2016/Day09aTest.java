package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day09aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "ADVENT|ADVENT",
            "A(1x5)BC|ABBBBBC",
            "(3x3)XYZ|XYZXYZXYZ",
            "(6x1)(1x3)A|(1x3)A",
            "X(8x2)(3x3)ABCY|X(3x3)ABC(3x3)ABCY"
    })
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day09a(List.of(input));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(output.length(), day.getResult());
    }
}