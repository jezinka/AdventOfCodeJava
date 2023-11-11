package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day01bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "R8, R4, R4, R8|4"
    })
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day01b(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.valueOf(output), day.getResult());
    }
}