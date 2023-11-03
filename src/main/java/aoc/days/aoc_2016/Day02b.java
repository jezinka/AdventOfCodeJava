package aoc.days.aoc_2016;

import aoc.days.Day;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Day02b extends Day {

    String[][] panel = {
            {null, null, "1", null, null},
            {null, "2", "3", "4", null},
            {"5", "6", "7", "8", "9"},
            {null, "A", "B", "C", null},
            {null, null, "D", null, null}};

    public Day02b() {
        super();
    }

    public Day02b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        StringBuilder code = new StringBuilder();
        Point button = new Point(2, 0);

        for (String instruction : this.getInput()) {
            List<String> directions = Arrays.stream(instruction.split("")).toList();
            directions.forEach(d -> {

                switch (d) {
                    case "R" -> {
                        int newY = Math.min(button.y + 1, 4);
                        if (panel[button.x][newY] != null) {
                            button.y = newY;
                        }
                    }
                    case "L" -> {
                        int newY = Math.max(button.y - 1, 0);
                        if (panel[button.x][newY] != null) {
                            button.y = newY;
                        }
                    }
                    case "U" -> {
                        int newX = Math.max(button.x - 1, 0);
                        if (panel[newX][button.y] != null) {
                            button.x = newX;
                        }
                    }
                    case "D" -> {
                        int newX = Math.min(button.x + 1, 4);
                        if (panel[newX][button.y] != null) {
                            button.x = newX;
                        }
                    }
                }
            });
            code.append(panel[button.x][button.y]);
        }

        setResult(code.toString());
    }
}
