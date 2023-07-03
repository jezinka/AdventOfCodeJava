package aoc.aoc_2015;

import aoc.days.Day;
import aoc.days.aoc_2015.Day03b;
import aoc.days.aoc_2015.Day04a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day04aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"abcdef|609043", "pqrstuv|1048970"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day04a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.valueOf(output), day.getResult());
    }
}