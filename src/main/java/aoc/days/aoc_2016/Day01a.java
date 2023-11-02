package aoc.days.aoc_2016;

import aoc.days.Day;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Day01a extends Day {

    public static final List<Point> DIRECTIONS = List.of(new Point(0, 1), new Point(1, 0), new Point(0, -1), new Point(-1, 0));

    public Day01a() {
        super();
    }

    public Day01a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Point point = new Point(0, 0);
        Point direction = DIRECTIONS.get(0);
        List<String> instructions = Arrays.stream(getInput().get(0).split(", ")).toList();

        for (String instruction : instructions) {
            direction = getNewDirection(DIRECTIONS, direction, instruction);
            point.x += direction.x * Integer.parseInt(instruction.substring(1));
            point.y += direction.y * Integer.parseInt(instruction.substring(1));
        }
        setResult(Math.abs(point.x) + Math.abs(point.y));
    }


    public Point getNewDirection(List<Point> directions, Point direction, String instruction) {
        int index;
        if (instruction.startsWith("R")) {
            index = directions.indexOf(direction) - 1 < 0 ? directions.size() - 1 : directions.indexOf(direction) - 1;
        } else {
            index = directions.indexOf(direction) + 1 == directions.size() ? 0 : directions.indexOf(direction) + 1;
        }
        direction = directions.get(index);
        return direction;
    }
}
