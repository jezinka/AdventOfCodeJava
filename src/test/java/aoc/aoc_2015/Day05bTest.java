package aoc.aoc_2015;

import aoc.days.Day;
import aoc.days.aoc_2015.Day05b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day05bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"qjhvhtzxzqqjkmpb|1", "xxyxx|1", "uurcxstgmygtbstg|0", "ieodomkazucvgmuy|0", "aaa|0"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day05b(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.valueOf(output), day.getResult());
    }
}