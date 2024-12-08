package aoc.days.aoc_2024;

import java.awt.*;
import java.util.List;

public class Day08b extends Day08a {

    public Day08b() {
        super();
    }

    public Day08b(List<String> input) {
        super(input);
    }

    @Override
    boolean isValidPoint(List<Point> pair, int i, int j, int xLength, int yLength) {
        return ((Math.abs(i - pair.get(0).x) % xLength) == 0 && (Math.abs(j - pair.get(0).y) % yLength) == 0)
               || ((Math.abs(i - pair.get(1).x) % xLength == 0) && (Math.abs(j - pair.get(1).y) % yLength == 0));
    }

}
