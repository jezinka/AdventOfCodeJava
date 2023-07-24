package aoc.aoc_2015;

import aoc.days.aoc_2015.Day17b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day17bTest {

    public static final List<String> CONTAINERS = List.of("20", "15", "10", "5", "5");

    @Test
    void resolve() {
        //given:
        Day17b day = new Day17b(CONTAINERS);
        day.setEggnog(25);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(3L, day.getResult());
    }
}