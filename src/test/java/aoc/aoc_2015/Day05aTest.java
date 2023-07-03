package aoc.aoc_2015;

import aoc.days.Day;
import aoc.days.aoc_2015.Day05a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day05aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"ugknbfddgicrmopn|1", "aaa|1", "jchzalrnumimnmhp|0", "haegwjzuvuyypxyu|0", "dvszwmarrgswjxmb|0"})
    void resolve_test(String input, String output) {
        //given:
        Day day = new Day05a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.valueOf(output), day.getResult());
    }
}