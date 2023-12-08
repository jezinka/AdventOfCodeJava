package aoc.days.aoc_2023;

import aoc.days.Day;
import aoc.days.aoc_2023.Day07a.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day07aTest {

    @Test
    void resolve_test() {
        Day day = new Day07a(List.of(
                "32T3K 765",
                "T55J5 684",
                "KK677 28",
                "KTJJT 220",
                "QQQJA 483"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(6440, day.getResult());
    }

    @Test
    void is5ofKind_test() {
        Hand hand = new Hand("AAAAA", 5);
        Assertions.assertEquals(7, hand.getType());
    }

    @Test
    void is4ofKind_test() {
        Hand hand = new Hand("AABAA", 5);
        Assertions.assertEquals(6, hand.getType());
    }

    @Test
    void isFullHouse_test() {
        Hand hand = new Hand("AABAB", 5);
        Assertions.assertEquals(5, hand.getType());
    }

    @Test
    void is3ofKind_test() {
        Hand hand = new Hand("AABAC", 5);
        Assertions.assertEquals(4, hand.getType());
    }

    @Test
    void is2pairs_test() {
        Hand hand = new Hand("AABCB", 5);
        Assertions.assertEquals(3, hand.getType());
    }

    @Test
    void is1pair_test() {
        Hand hand = new Hand("AABCD", 5);
        Assertions.assertEquals(2, hand.getType());
    }

    @Test
    void isHighCard_test() {
        Hand hand = new Hand("A2BCD", 5);
        Assertions.assertEquals(1, hand.getType());
    }
}
