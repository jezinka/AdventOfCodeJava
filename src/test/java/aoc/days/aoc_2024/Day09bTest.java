package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day09bTest {

    @Test
    void test() {
        Day day = new Day09b(List.of("2333133121414131402"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(2858L, day.getResult());
    }

    @Test
    void test_edge() {
        Day day = new Day09b(List.of("12345"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(132L, day.getResult());
    }

    @Test
    void test_edge2() {
        Day day = new Day09b(List.of("171010402"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(88L, day.getResult());
    }
}
