package aoc.aoc_2015;

import aoc.days.aoc_2015.Day11a;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class Day11aTest {

    @Test
    void rules_hijklmmn() {
        Assertions.assertTrue(Day11a.ruleOne("hijklmmn"));
        Assertions.assertFalse(Day11a.ruleTwo("hijklmmn"));
        Assertions.assertFalse(Day11a.ruleThree("hijklmmn"));
    }

    @Test
    void resolve_abbceffg() {
        Assertions.assertFalse(Day11a.ruleOne("abbceffg"));
        Assertions.assertTrue(Day11a.ruleTwo("abbceffg"));
        Assertions.assertTrue(Day11a.ruleThree("abbceffg"));
    }

    @Test
    void resolve_abbcegjk() {
        Assertions.assertFalse(Day11a.ruleThree("abbcegjk"));
    }

    @Test
    void resolve_abbbcegjk() {
        Assertions.assertFalse(Day11a.ruleThree("abbbcegjk"));
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {"abcdefgh|abcdffaa", "ghijklmn|ghjaabcc"})
    void resolve(String input, String output) {
        //given:
        Day11a day = new Day11a(List.of(input));

        //when:
        day.resolve();

        //then:
        Assertions.assertEquals(output, day.getResult());
    }
}