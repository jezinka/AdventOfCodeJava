package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.awt.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day06a extends Day {

    public Day06a() {
        super();
        showBoard = false;
    }

    public Day06a(List<String> input) {
        super(input);
    }

    private static boolean showBoard = true;
    public static final List<Point> DIRECTIONS = List.of(new Point(-1, 0), new Point(0, 1), new Point(1, 0), new Point(0, -1));
    public static final List<String> DIRECTION_POINTERS = List.of("^", ">", "v", "<");

    @Override
    public void resolve() {
        Point direction = DIRECTIONS.get(0);
        String directionPointer = DIRECTION_POINTERS.get(0);

        Set<Point> visited = new HashSet<>();
        String[][] board = XyUtils.prepareBoard(getInput());

        Point guardPosition = putGuardOnStart(board, visited);

        if (showBoard) {
            System.out.println("Początek");
            printBoard(board, guardPosition, directionPointer);
        }

        guardTupTup(guardPosition, direction, board, directionPointer, visited, visited.size());

        setResult(visited.size());
    }

    Point putGuardOnStart(String[][] board, Set<Point> visited) {
        Point guardPosition = new Point(0, 0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("^")) {
                    guardPosition = new Point(i, j);
                    visited.add(guardPosition);
                }
            }
        }
        return guardPosition;
    }

    boolean guardTupTup(Point guardPosition, Point direction, String[][] board, String directionPointer, Set<Point> visited, int limit) {
        int loopCounter = 0;
        while (guardPosition.x + direction.x > -1 && guardPosition.x + direction.x < board.length && guardPosition.y + direction.y > -1 && guardPosition.y + direction.y < board.length) {
            if (board[guardPosition.x + direction.x][guardPosition.y + direction.y].equals("#")) {
                var index = DIRECTIONS.indexOf(direction) + 1 == DIRECTIONS.size() ? 0 : DIRECTIONS.indexOf(direction) + 1;
                direction = DIRECTIONS.get(index);
                directionPointer = DIRECTION_POINTERS.get(index);
            } else {
                guardPosition = new Point(guardPosition.x + direction.x, guardPosition.y + direction.y);
                boolean added = visited.add(guardPosition);
                if (added) {
                    loopCounter = 0;
                } else {
                    loopCounter += 1;
                }
            }

            if (showBoard) {
                System.out.println("\nKolejny ruch\n");
                printBoard(board, guardPosition, directionPointer);
            }

            if (loopCounter > limit) {
                break;
            }
        }
        return loopCounter > limit;
    }

    void printBoard(String[][] board, Point guardPosition, String directionPointer) {
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (guardPosition.x == i && guardPosition.y == j) {
                    row.append(directionPointer);
                } else if (board[i][j].equals("#")) {
                    row.append("#");
                } else {
                    row.append(".");
                }
            }
            System.out.println(row);
        }
    }
}
