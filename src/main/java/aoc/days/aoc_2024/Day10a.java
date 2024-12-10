package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Day10a extends Day {

    public Day10a() {
        super();
    }

    public Day10a(List<String> input) {
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

        int hills = 0;
        for (Point p : start) {
            Set<Point> hillsReachable = new HashSet<>();
            List<Point> visited = new ArrayList<>();
            visited.add(new Point(p.x, p.y));
            nextStep(p, map, visited, hillsReachable);
            hills += hillsReachable.size();
        }

        setResult(hills);
    }

    private void nextStep(Point p, String[][] map, List<Point> visited, Set<Point> hillsReachable) {
        if (map[p.x][p.y].equals("9")) {
            hillsReachable.add(new Point(p.x, p.y));
            return;
        }

        for (Point nextStep : getPossibleSteps(p, map)) {
            if (!visited.contains(nextStep)) {
                List<Point> copy = new ArrayList<>(visited);
                copy.add(nextStep);
                nextStep(nextStep, map, copy, hillsReachable);
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
