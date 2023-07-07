package aoc.aoc_2015;

import aoc.days.aoc_2015.Day08a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day08aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"\"\"|2|0", "\"abc\"|5|3", "\"aaa\\\"aaa\"|10|7", "\"\\x27\"|6|1", "\"\\\\\"|4|1"})
    void resolve_test(String input, String code, String output) {
        //given:
        Day08a day = new Day08a(List.of(input));

        //when:
        day.resolve();
        List<List> charactersLengths = day.getCharactersLength();

        //then:
        Assertions.assertEquals(Integer.parseInt(code), charactersLengths.get(0).get(1));
        Assertions.assertEquals(Integer.parseInt(output), charactersLengths.get(0).get(2));
    }

    @Test
    void resolve_all() {
        //given:
        Day08a day = new Day08a(List.of("\"\"", "\"abc\"", "\"aaa\\\"aaa\"", "\"\\x27\""));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(12, day.getResult());
    }
}