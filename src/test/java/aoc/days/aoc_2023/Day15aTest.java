package aoc.days.aoc_2023;

import aoc.days.Day;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class Day15aTest {

    @Test
    void resolve_test() {
        Day day = new Day15a(List.of("rn=1,cm-,qp=3,cm=2,qp-,pc=4,ot=9,ab=5,pc-,pc=6,ot=7"));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(1320, day.getResult());
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "HASH|52",
            "rn=1|30",
            "cm-|253",
            "qp=3|97",
            "cm=2|47",
            "qp-|14",
            "pc=4|180",
            "ot=9|9",
            "ab=5|197",
            "pc-|48",
            "pc=6|214",
            "ot=7|231"})
    void test_partially(String input, String output) {
        int result = Day15a.hashAlgorithm(input);
        Assertions.assertEquals(Integer.parseInt(output), result);
    }
}
