package aoc.days.aoc_2015;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day06aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"turn on 0,0 through 9,9|100", "toggle 0,0 through 9,9|100", "turn off 499,499 through 500,500|0"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day06a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.valueOf(output), day.getResult());
    }
}