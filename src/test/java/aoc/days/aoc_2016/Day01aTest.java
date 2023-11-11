package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day01aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "R2, L3|5",
            "R2, R2, R2|2",
            "R5, L5, R5, R3|12",
    })
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day01a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.valueOf(output), day.getResult());
    }
}