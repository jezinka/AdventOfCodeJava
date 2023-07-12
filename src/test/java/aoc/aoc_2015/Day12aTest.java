package aoc.aoc_2015;

import aoc.days.aoc_2015.Day12a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day12aTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"[1,2,3]|6", "{\"a\":2,\"b\":4}|6", "[[[3]]]|3", "{\"a\":{\"b\":4},\"c\":-1}|3", "{\"a\":[-1,1]}|0", "[-1,{\"a\":1}]|0"})
    void resolve(String input, String output) {
        //given:
        Day12a day = new Day12a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(Long.parseLong(output), day.getResult());
    }
}