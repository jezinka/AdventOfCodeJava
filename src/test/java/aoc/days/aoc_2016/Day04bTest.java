package aoc.days.aoc_2016;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day04bTest {

    @Test
    void resolve_test() {
        //given:
        Day04b.Room room = new Day04b.Room(343, "qzmt-zixmtkozy-ivhz");

        //when:
        String result = room.getDecryptedName();

        //then:
        Assertions.assertEquals("very encrypted name", result);
    }
}