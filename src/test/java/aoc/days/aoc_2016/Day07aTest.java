package aoc.days.aoc_2016;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day07aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "abba[mnop]qrst|1",
            "abcd[bddb]xyyx|0",
            "aaaa[qwer]tyui|0",
            "ioxxoj[asdfgh]zxcvbn|1"
    })
    void resolve_test(String input, String result) {
        //given:
        Day day = new Day07a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Integer.parseInt(result), day.getResult());
    }
}