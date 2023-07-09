package aoc.days.aoc_2015;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Day03b extends Day {

    public Day03b() {
        super();
    }

    public Day03b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Point> santaPoints = new ArrayList<>();
        List<Point> robotPoints = new ArrayList<>();
        santaPoints.add(new Point(0, 0));
        robotPoints.add(new Point(0, 0));

        List<String> directions = this.getInputLineSplitBySingleCharacters();
        List<List<Point>> turns = new ArrayList<>();
        turns.add(santaPoints);
        turns.add(robotPoints);
        directions.forEach(direction -> {
            List<Point> currentPoints = turns.remove(0);
            Point lastPoint = XyUtils.movePoint(currentPoints.get(currentPoints.size() - 1), direction);

            switch (direction) {
                case "^" -> lastPoint.x++;
                case "v" -> lastPoint.x--;
                case "<" -> lastPoint.y--;
                case ">" -> lastPoint.y++;
            }
            currentPoints.add(lastPoint);
            turns.add(currentPoints);
        });

        santaPoints.addAll(robotPoints);
        this.setResult(Set.copyOf(santaPoints).size());
    }
}
