package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day07bTest {

    @Test
    void resolve_test() {
        Day day = new Day07b(List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(5905, day.getResult());
    }
}
