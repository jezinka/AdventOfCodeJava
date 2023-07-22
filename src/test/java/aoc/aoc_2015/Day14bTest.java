package aoc.aoc_2015;

import aoc.days.aoc_2015.Day14b;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day14bTest {

    public static final List<String> REINDEERS = List.of(
            "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
            "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");

    @Test
    void resolve() {
        //given:
        Day14b day = new Day14b(REINDEERS);
        day.setTime(1000);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(689, day.getResult());
    }
}