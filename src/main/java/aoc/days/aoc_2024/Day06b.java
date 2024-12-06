package aoc.days.aoc_2024;

import aoc.utils.XyUtils;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06b extends Day06a {

    public Day06b() {
        super();
        showBoard = false;
    }

    public Day06b(List<String> input) {
        super(input);
    }

    private static boolean showBoard = true;

    @Override
    public void resolve() {
        Point direction = DIRECTIONS.get(0);
        String directionPointer = DIRECTION_POINTERS.get(0);

        Set<Point> visited = new HashSet<>();
        String[][] board = XyUtils.prepareBoard(getInput());

        Point guardPosition = putGuardOnStart(board, visited);
        Point startedPoint = new Point(guardPosition);

        if (showBoard) {
            System.out.println("Początek");
            printBoard(board, guardPosition, directionPointer);
        }

        guardTupTup(guardPosition, direction, board, directionPointer, visited, visited.size());

        int loopObstacles = 0;
        for (Point point : visited) {
            if (point != startedPoint) {
                board = XyUtils.prepareBoard(getInput());
                board[point.x][point.y] = "#";
                boolean loop = guardTupTup(startedPoint, DIRECTIONS.get(0), board, "^", new HashSet<>(), visited.size());
                if (loop) {
                    loopObstacles++;
                }
            }
        }

        setResult(loopObstacles);
    }
}
