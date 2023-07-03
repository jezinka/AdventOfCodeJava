package aoc.aoc_2015;

import aoc.days.Day;
import aoc.days.aoc_2015.Day01b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day01bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            ")|1", "()())|5", "()())()|5"
    })
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day01b(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.valueOf(output), day.getResult());
    }
}