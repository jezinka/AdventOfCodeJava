package aoc.aoc_2015;

import aoc.days.aoc_2015.Day07a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class Day07aTest {

    @Test
    void resolve_test() {
        //given:
        Day07a day = new Day07a(List.of(
                "123 -> x",
                "456 -> y",
                "x AND y -> d",
                "x OR y -> e",
                "x LSHIFT 2 -> f",
                "y RSHIFT 2 -> g",
                "NOT x -> h",
                "NOT y -> i"));

        //when:
        day.resolve();
        Map<String, Long> results = day.getBoard();

        //then:
        Assertions.assertNotNull(results);

        Assertions.assertEquals(123, results.get("x"));
        Assertions.assertEquals(456, results.get("y"));
        Assertions.assertEquals(72, results.get("d"));
        Assertions.assertEquals(507, results.get("e"));
        Assertions.assertEquals(492, results.get("f"));
        Assertions.assertEquals(114, results.get("g"));
        Assertions.assertEquals(65412, results.get("h"));
        Assertions.assertEquals(65079, results.get("i"));
    }
}