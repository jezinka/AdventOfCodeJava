package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day10b extends Day {

    public Day10b() {
        super();
    }

    public Day10b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        String[][] map = XyUtils.prepareBoard(getInput());

        List<Point> start = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j].equals("0")) {
                    start.add(new Point(i, j));
                }
            }
        }

        List<List<Point>> trails = new ArrayList<>();
        for (Point p : start) {
            List<Point> visited = new ArrayList<>();
            visited.add(new Point(p.x, p.y));
            nextStep(p, map, visited, trails);
        }

        setResult(trails.size());
    }

    private void nextStep(Point p, String[][] map, List<Point> visited, List<List<Point>> trails) {
        if (map[p.x][p.y].equals("9")) {
            Point hill = new Point(p.x, p.y);
            visited.add(hill);
            trails.add(visited);
            return;
        }

        for (Point nextStep : getPossibleSteps(p, map)) {
            if (!visited.contains(nextStep)) {
                List<Point> copy = new ArrayList<>(visited);
                copy.add(nextStep);
                nextStep(nextStep, map, copy, trails);
            }
        }
    }

    private static List<Point> getPossibleSteps(Point p, String[][] map) {
        return Stream.of(new Point(p.x + 1, p.y), new Point(p.x - 1, p.y), new Point(p.x, p.y + 1), new Point(p.x, p.y - 1))
                .filter(pos -> pos.x > -1 && pos.y > -1 && pos.x < map.length && pos.y < map.length)
                .filter(pos -> StringUtils.isNumeric(map[pos.x][pos.y]))
                .filter(pos -> -1 == Integer.parseInt(map[p.x][p.y]) - Integer.parseInt(map[pos.x][pos.y]))
                .toList();
    }

}
