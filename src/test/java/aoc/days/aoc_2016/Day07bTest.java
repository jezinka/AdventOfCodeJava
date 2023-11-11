package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day07bTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "aba[bab]xyz|1",
            "xyx[xyx]xyx|0",
            "aaa[kek]eke|1",
            "zazbz[bzb]cdb|1"
    })
    void resolve_test(String input, String result) {
        //given:
        Day day = new Day07b(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.parseInt(result), day.getResult());
    }
}