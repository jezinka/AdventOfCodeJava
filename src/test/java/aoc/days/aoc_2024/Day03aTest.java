package aoc.days.aoc_2024;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day03aTest {

    @Test
    void test() {
        Day day = new Day03a(List.of("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(161L, day.getResult());
    }

}
