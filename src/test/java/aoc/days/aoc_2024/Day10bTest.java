package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day10bTest {

    @Test
    void test() {
        Day day = new Day10b(List.of("89010123",
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
        Assertions.assertEquals(81, day.getResult());
    }

    @Test
    void test_small() {
        Day day = new Day10b(List.of(
                ".....0.",
                "..4321.",
                "..5..2.",
                "..6543.",
                "..7..4.",
                "..8765.",
                "..9...."));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(3, day.getResult());
    }

    @Test
    void test_1() {
        Day day = new Day10b(List.of(
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
        Assertions.assertEquals(13, day.getResult());
    }

    @Test
    void test_2() {
        Day day = new Day10b(List.of(
                "012345",
                "123456",
                "234567",
                "345678",
                "4.6789",
                "56789."));
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(227, day.getResult());
    }

}
