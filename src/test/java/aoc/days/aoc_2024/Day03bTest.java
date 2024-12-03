package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03bTest {

    @Test
    void test() {
        Day day = new Day03b(List.of("xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(48L, day.getResult());
    }

}
