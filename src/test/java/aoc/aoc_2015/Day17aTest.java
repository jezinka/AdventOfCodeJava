package aoc.aoc_2015;

import aoc.days.aoc_2015.Day17a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day17aTest {

    public static final List<String> CONTAINERS = List.of("20", "15", "10", "5", "5");

    @Test
    void resolve() {
        //given:
        Day17a day = new Day17a(CONTAINERS);
        day.setEggnog(25);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(4, day.getResult());
    }
}