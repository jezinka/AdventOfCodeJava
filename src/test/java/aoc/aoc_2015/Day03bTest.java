package aoc.aoc_2015;

import aoc.days.Day;
import aoc.days.aoc_2015.Day03b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day03bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"^v|3", "^>v<|3", "^v^v^v^v^v|11"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day03b(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.valueOf(output), day.getResult());
    }
}