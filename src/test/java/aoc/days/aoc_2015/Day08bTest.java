package aoc.days.aoc_2015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day08bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"\"\"|2|6", "\"abc\"|5|9", "\"aaa\\\"aaa\"|10|16", "\"\\x27\"|6|11"})
    void resolve_test(String input, String code, String output) {
        //given:
        Day08b day = new Day08b(List.of(input));

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
        Day08b day = new Day08b(List.of("\"\"", "\"abc\"", "\"aaa\\\"aaa\"", "\"\\x27\""));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(19, day.getResult());
    }
}