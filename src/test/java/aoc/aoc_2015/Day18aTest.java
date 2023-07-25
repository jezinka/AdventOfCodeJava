package aoc.aoc_2015;

import aoc.days.aoc_2015.Day18a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day18aTest {

    public static final List<String> GRID = List.of(".#.#.#", "...##.", "#....#", "..#...", "#.#..#", "####..");

    @Test
    void resolve() {
        //given:
        Day18a day = new Day18a(GRID);
        day.setSteps(4);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(4L, day.getResult());
    }
}