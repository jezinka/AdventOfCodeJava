package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day10aTest {

    @Test
    void test() {
        Day day = new Day10a(List.of("89010123",
                "78121874",
                "87430965",
                "96549874",
                "45678903",
                "32019012",
                "01329801",
                "10456732"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(36, day.getResult());
    }

    @Test
    void test_small() {
        Day day = new Day10a(List.of(
                "0123",
                "1234",
                "8765",
                "9876"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1, day.getResult());
    }

    @Test
    void test_2() {
        Day day = new Day10a(List.of(
                "...0...",
                "...1...",
                "...2...",
                "6543456",
                "7.....7",
                "8.....8",
                "9.....9"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(2, day.getResult());
    }

    @Test
    void test_3() {
        Day day = new Day10a(List.of(
                "10..9..",
                "2...8..",
                "3...7..",
                "4567654",
                "...8..3",
                "...9..2",
                ".....01"));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(3, day.getResult());
    }

    @Test
    void test_4() {
        Day day = new Day10a(List.of(
                "..90..9",
                "...1.98",
                "...2..7",
                "6543456",
                "765.987",
                "876....",
                "987...."));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(4, day.getResult());
    }
}
