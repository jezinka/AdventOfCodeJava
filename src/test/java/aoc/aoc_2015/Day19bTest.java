package aoc.aoc_2015;

import aoc.days.aoc_2015.Day19b;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day19bTest {

    @Test
    void resolve() {
        //given:
        Day19b day = new Day19b();
        addStartingPoint(day);

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(3, day.getResult());
    }

    @Test
    void resolve_HOHOHO() {
        //given:
        Day19b day = new Day19b();
        day.setMolecule("HOHOHO");
        addStartingPoint(day);

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(6, day.getResult());
    }

    private void addStartingPoint(Day19b day) {
        day.getReplacements().add(new ImmutablePair<>("e", "H"));
        day.getReplacements().add(new ImmutablePair<>("e", "O"));
    }
}