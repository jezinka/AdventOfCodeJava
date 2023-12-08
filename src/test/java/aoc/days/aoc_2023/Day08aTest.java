package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day08aTest {

    @Test
    void resolve_test() {
        Day day = new Day08a(List.of(
                "LLR",
                "",
                "AAA = (BBB, BBB)",
                "BBB = (AAA, ZZZ)",
                "ZZZ = (ZZZ, ZZZ)"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(6L, day.getResult());
    }

    @Test
    void resolveBigger_test() {
        Day day = new Day08a(List.of(
                "RL",
                "",
                "AAA = (BBB, CCC)",
                "BBB = (DDD, EEE)",
                "CCC = (ZZZ, GGG)",
                "DDD = (DDD, DDD)",
                "EEE = (EEE, EEE)",
                "GGG = (GGG, GGG)",
                "ZZZ = (ZZZ, ZZZ)"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(2L, day.getResult());
    }
}
