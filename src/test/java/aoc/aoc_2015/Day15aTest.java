package aoc.aoc_2015;

import aoc.days.aoc_2015.Day15a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Day15aTest {

    public static final List<String> INGREDIENTS = List.of(
            "Butterscotch: capacity -1, durability -2, flavor 6, texture 3, calories 8",
            "Cinnamon: capacity 2, durability 3, flavor -2, texture -1, calories 3");

    @Test
    void resolve() {
        //given:
        Day15a day = new Day15a(INGREDIENTS);
        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(62842880, day.getResult());
    }
}