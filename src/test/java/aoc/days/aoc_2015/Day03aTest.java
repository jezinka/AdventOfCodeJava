package aoc.days.aoc_2015;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day03aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {">|2", "^>v<|4", "^v^v^v^v^v|2"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day03a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.valueOf(output), day.getResult());
    }
}