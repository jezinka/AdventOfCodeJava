package aoc.utils;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LCMTest {

    @Test
    void lcm() {
        assertEquals(36L, LCM.lcm(List.of(12L, 18L)));
        assertEquals(36L, LCM.lcm(List.of(9L, 12L, 18L)));
    }
}