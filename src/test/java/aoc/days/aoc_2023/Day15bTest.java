package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Day15bTest {

    @Test
    void resolve_test() {
        Day day = new Day15b(List.of("rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(145, day.getResult());
    }
}
