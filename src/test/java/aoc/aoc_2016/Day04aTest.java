package aoc.aoc_2016;

import aoc.days.Day;
import aoc.days.aoc_2016.Day04a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day04aTest {

    @Test
    void resolve_test() {
        //given:
        Day day = new Day04a(List.of(
                "aaaaa-bbb-z-y-x-123[abxyz]",
                "a-b-c-d-e-f-g-h-987[abcde]",
                "not-a-real-room-404[oarel]",
                "totally-real-room-200[decoy]"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1514, day.getResult());
    }
}