package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day15a extends Day {

    public static final String ROBOT = "@";
    public static final String BOX = "O";
    public static final String WALL = "#";
    private final boolean render;

    public Day15a() {
        super();
        render = false;
    }

    public Day15a(List<String> input) {
        super(input);
        render = true;
    }

    @Override
    public void resolve() {
        String[][] board = XyUtils.prepareBoard(getInput().stream().filter(line -> getInput().indexOf(line) < getInput().indexOf("")).toList());

        List<Point> boxes = new ArrayList<>();
        List<Point> walls = new ArrayList<>();
        Point robot = prepareObjects(board, boxes, walls);
        List<String> instructions = Arrays.stream(StringUtils.join(getInput().stream().filter(line -> getInput().indexOf(line) > getInput().indexOf("")).toList(), "").split("")).collect(Collectors.toList());

        printBoard(board, robot, boxes, walls);

        while (!instructions.isEmpty()) {
            String instruction = instructions.remove(0);
            robot = switch (instruction) {
                case ">" -> goRobot(new Point(0, 1), robot, boxes, walls);
                case "v" -> goRobot(new Point(1, 0), robot, boxes, walls);
                case "<" -> goRobot(new Point(0, -1), robot, boxes, walls);
                case "^" -> goRobot(new Point(-1, 0), robot, boxes, walls);
                default -> robot;
            };

            printBoard(board, robot, boxes, walls);
        }

        boxes.stream().map(this::findGpsCoordinate).reduce(Long::sum).ifPresent(this::setResult);
    }

    private Point goRobot(Point where, Point robot, List<Point> boxes, List<Point> walls) {
        Point newRobotPosition = new Point(robot.x + where.x, robot.y + where.y);
        if (walls.contains(newRobotPosition)) {
            return robot;
        }

        if (boxes.contains(newRobotPosition)) {
            return moveBox(where, robot, boxes, walls, newRobotPosition);
        }

        return newRobotPosition;
    }

    private static Point moveBox(Point where, Point robot, List<Point> boxes, List<Point> walls, Point oldBoxPosition) {
        Point newBoxPosition = new Point(oldBoxPosition.x + where.x, oldBoxPosition.y + where.y);
        if (walls.contains(newBoxPosition)) {
            return robot;
        }

        if (boxes.contains(newBoxPosition)) {
            var newRobotPosition = moveBox(where, robot, boxes, walls, newBoxPosition);
            if (newRobotPosition.equals(robot)) {
                return robot;
            }
        }

        boxes.remove(oldBoxPosition);
        boxes.add(newBoxPosition);
        return oldBoxPosition;
    }

    private void printBoard(String[][] board, Point robot, List<Point> boxes, List<Point> walls) {
        if (!render) {
            return;
        }

        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                if (robot.equals(new Point(i, j))) {
                    row.append(ROBOT);
                } else if (boxes.contains(new Point(i, j))) {
                    row.append(BOX);
                } else if (walls.contains(new Point(i, j))) {
                    row.append(WALL);
                } else {
                    row.append(".");
                }
            }
            System.out.println(row);
        }
    }

    Point prepareObjects(String[][] board, List<Point> boxes, List<Point> walls) {
        Point robot = null;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                final Point point = new Point(i, j);
                switch (board[i][j]) {
                    case ROBOT -> robot = point;
                    case BOX -> boxes.add(point);
                    case WALL -> walls.add(point);
                }
            }
        }

        if (robot == null) {
            throw new RuntimeException("no robot found");
        }

        return robot;
    }

    long findGpsCoordinate(Point point) {
        return point.x * 100L + point.y;
    }
}
