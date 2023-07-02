package aoc.days;

import aoc.days.aoc_2015.Day01a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class DayTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"TEST|4", "123456789|9"})
    void getInputLineSplitBySingleCharacters(String input, String output) {
        Day day = new Day01a(List.of(input));
        List<String> characters = day.getInputLineSplitBySingleCharacters();
        Assertions.assertEquals(Integer.valueOf(output), characters.size());
    }
}