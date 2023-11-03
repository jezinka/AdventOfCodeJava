package aoc.days.aoc_2016;

import aoc.days.Day;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Day02a extends Day {

    int[][] panel = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    public Day02a() {
        super();
    }

    public Day02a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        StringBuilder code = new StringBuilder();
        Point button = new Point(1, 1);

        for (String instruction : this.getInput()) {
            List<String> directions = Arrays.stream(instruction.split("")).toList();
            directions.forEach(d -> {
                switch (d) {
                    case "R" -> button.y = Math.min(button.y + 1, 2);
                    case "L" -> button.y = Math.max(button.y - 1, 0);
                    case "U" -> button.x = Math.max(button.x - 1, 0);
                    case "D" -> button.x = Math.min(button.x + 1, 2);
                }
            });
            code.append(panel[button.x][button.y]);
        }

        setResult(code.toString());
    }
}
