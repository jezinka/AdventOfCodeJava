package aoc.days.aoc_2016;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day01b extends Day01a {

    public Day01b() {
        super();
    }

    public Day01b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Point> visitedPlaces = new ArrayList<>();

        Point point = new Point(0, 0);
        visitedPlaces.add(new Point(point.x, point.y));

        Point direction = DIRECTIONS.get(0);
        List<String> instructions = Arrays.stream(getInput().get(0).split(", ")).toList();
        Point pointVisitedTwice = null;

        for (String instruction : instructions) {
            direction = getNewDirection(DIRECTIONS, direction, instruction);
            int path = Integer.parseInt(instruction.substring(1));
            for (int i = 0; i < path; i++) {
                point.x += direction.x;
                point.y += direction.y;

                Point newPoint = new Point(point.x, point.y);
                if (visitedPlaces.contains(newPoint)) {
                    pointVisitedTwice = newPoint;
                    break;
                }
                visitedPlaces.add(newPoint);
            }
            if (pointVisitedTwice != null) {
                break;
            }
        }

        if (pointVisitedTwice != null) {
            setResult(Math.abs(pointVisitedTwice.x) + Math.abs(pointVisitedTwice.y));
        }
    }
}
