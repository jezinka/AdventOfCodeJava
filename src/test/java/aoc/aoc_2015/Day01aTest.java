package aoc.aoc_2015;

import aoc.days.aoc_2015.Day01a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day01aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "(())|0", "()()|0",
            "(((|3", "(()(()(|3", "))(((((|3",
            "())|-1", "))(|-1",
            ")))|-3", ")())())|-3"
    })
    void resolve_test(String input, String output) {
        //given:
        Day01a day = new Day01a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.valueOf(output), day.getResult());
    }
}