package aoc.days.aoc_2015;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day14aTest {

    public static final List<String> REINDEERS = List.of(
            "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.",
            "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds.");

    @Test
    void resolve() {
        //given:
        Day14a day = new Day14a(REINDEERS);
        day.setTime(1000);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1120, day.getResult());
        Assertions.assertEquals(1120, day.getResults().get("Comet"));
        Assertions.assertEquals(1056, day.getResults().get("Dancer"));
    }

    @Test
    void resolve_1() {
        //given:
        Day14a day = new Day14a(REINDEERS);
        day.setTime(1);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(16, day.getResult());
        Assertions.assertEquals(14, day.getResults().get("Comet"));
        Assertions.assertEquals(16, day.getResults().get("Dancer"));
    }

    @Test
    void resolve_11() {
        //given:
        Day14a day = new Day14a(REINDEERS);
        day.setTime(11);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(176, day.getResult());
        Assertions.assertEquals(140, day.getResults().get("Comet"));
        Assertions.assertEquals(176, day.getResults().get("Dancer"));
    }

    @Test
    void resolve_12() {
        //given:
        Day14a day = new Day14a(REINDEERS);
        day.setTime(12);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(176, day.getResult());
        Assertions.assertEquals(140, day.getResults().get("Comet"));
        Assertions.assertEquals(176, day.getResults().get("Dancer"));
    }

    @Test
    void resolve_138() {
        //given:
        Day14a day = new Day14a(REINDEERS);
        day.setTime(138);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(176, day.getResult());
        Assertions.assertEquals(154, day.getResults().get("Comet"));
        Assertions.assertEquals(176, day.getResults().get("Dancer"));
    }

    @Test
    void resolve_174() {
        //given:
        Day14a day = new Day14a(REINDEERS);
        day.setTime(174);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(280, day.getResult());
        Assertions.assertEquals(280, day.getResults().get("Comet"));
        Assertions.assertEquals(192, day.getResults().get("Dancer"));
    }
}