package aoc.days.aoc_2023;

import aoc.days.Day;
import aoc.utils.XyUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Day10aTest {

    @Test
    void resolve_test() {
        Day day = new Day10a(List.of(
                "-L|F7",
                "7S-7|",
                "L|7||",
                "-L-J|",
                "L|-JF"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(4L, day.getResult());
    }

    @Test
    void resolveBigger_test() {
        Day day = new Day10a(List.of(
                "..F7.",
                ".FJ|.",
                "SJ.L7",
                "|F--J",
                "LJ..."));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(8L, day.getResult());
    }

    @ParameterizedTest
    @CsvSource(delimiter = ';', value = {"-;L,R", "|;U,D", "L;U,R", "J;U,L", "F;D,R", "7;D,L"})
    void directions_test(String center, String results) {
        Day10a day = new Day10a(List.of(
                ".U.",
                "L" + center + "R",
                ".D."
        ));

        day.setBoard(XyUtils.prepareBoard(day.getInput()));

        //when
        List<Point> neighbours = day.getNeighbours(new Point(1, 1));

        //expect
        List<String> first = neighbours.stream().map(day::getSymbol).toList();
        List<String> second = Arrays.stream(results.split(",")).toList();
        Assertions.assertTrue(first.size() == second.size() && first.containsAll(second) && second.containsAll(first));
    }
}
