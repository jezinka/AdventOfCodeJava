package aoc.days.aoc_2023;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Day10a extends Day {

    private String[][] board;

    public Day10a() {
        super();
    }

    public Day10a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        setBoard(XyUtils.prepareBoard(getInput()));

        Point startPoint = getStartPoint();

        List<Point> sNeighbours = whereFromS(startPoint);
        List<Point> route1 = new ArrayList<>(List.of(startPoint, sNeighbours.get(0)));
        List<Point> route2 = new ArrayList<>(List.of(startPoint, sNeighbours.get(1)));

        while (!route1.get(route1.size() - 1).equals(route2.get(route2.size() - 1))) {
            route1.add(getNextStep(route1));
            route2.add(getNextStep(route2));
        }

        setResult(route1.stream().filter(p -> !p.equals(startPoint)).count());
    }

    private Point getStartPoint() {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y].equals("S")) {
                    return new Point(x, y);
                }
            }
        }
        throw new RuntimeException("łuuuuuuuuuuuuuuuuu! nie ma początku!");
    }

    private String printRoute(List<Point> route1) {
        return route1.stream().map(this::getSymbol).collect(Collectors.joining(" -> "));
    }

    private Point getNextStep(List<Point> points) {
        Point getLastPoint = points.get(points.size() - 1);
        return getNeighbours(getLastPoint).stream().filter(p -> !points.contains(p)).findFirst().orElse(null);
    }

    List<Point> getNeighbours(Point p) {
        int x = p.x;
        int y = p.y;
        String symbol = getSymbol(p);

        List<Point> neighbours = new ArrayList<>();
        Point right = new Point(x, y + 1);
        Point left = new Point(x, y - 1);
        Point up = new Point(x - 1, y);
        Point down = new Point(x + 1, y);

        if (symbol.equals("-")) {
            neighbours.add(left);
            neighbours.add(right);
        }

        if (symbol.equals("|")) {
            neighbours.add(up);
            neighbours.add(down);
        }

        if (symbol.equals("F")) {
            neighbours.add(down);
            neighbours.add(right);
        }

        if (symbol.equals("7")) {
            neighbours.add(down);
            neighbours.add(left);
        }

        if (symbol.equals("J")) {
            neighbours.add(up);
            neighbours.add(left);
        }

        if (symbol.equals("L")) {
            neighbours.add(up);
            neighbours.add(right);
        }

        return neighbours;
    }

    List<Point> whereFromS(Point p) {
        int x = p.x;
        int y = p.y;

        Point right = new Point(x, y + 1);
        Point left = new Point(x, y - 1);
        Point up = new Point(x - 1, y);
        Point down = new Point(x + 1, y);

        List<Point> neighbours = new ArrayList<>();
        if (List.of("J", "-", "7").contains(getSymbol(right))) {
            neighbours.add(right);
        }
        if (List.of("F", "-", "L").contains(getSymbol(left))) {
            neighbours.add(left);
        }
        if (List.of("F", "|", "7").contains(getSymbol(up))) {
            neighbours.add(up);
        }
        if (List.of("L", "|", "J").contains(getSymbol(down))) {
            neighbours.add(down);
        }

        return neighbours;
    }

    String getSymbol(Point point) {
        if (point.x >= 0 && point.x < board.length
                && point.y >= 0 && point.y < board[point.x].length) {
            return board[point.x][point.y];
        }
        return "";
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}

