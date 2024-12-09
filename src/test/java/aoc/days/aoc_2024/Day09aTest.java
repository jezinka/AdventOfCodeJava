package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class Day09aTest {

    @Test
    void test() {
        Day day = new Day09a(List.of("2333133121414131402"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1928L, day.getResult());
    }
}
