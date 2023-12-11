package aoc.days.aoc_2023;

import aoc.days.Day;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Day11a extends Day {

    public Day11a() {
        super();
    }

    public Day11a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Point> galactics = getExtendedGalacticsLocation();
        List<List<Point>> pairs = new ArrayList<>();
        for (int i = 0; i < galactics.size(); i++) {
            for (int j = i + 1; j < galactics.size(); j++) {
                pairs.add(List.of(galactics.get(i), galactics.get(j)));
            }
        }
        int galacticsDistance = pairs.stream().map(p -> Map.entry(p, calculateManhattanDistance(p))).mapToInt(Map.Entry::getValue).sum();
        setResult(galacticsDistance);
    }

    private int calculateManhattanDistance(List<Point> p) {
        return Math.abs(p.get(0).x - p.get(1).x) + Math.abs(p.get(0).y - p.get(1).y);
    }

    private List<Point> getExtendedGalacticsLocation() {
        List<Integer> emptyRows = new ArrayList<>();
        List<Integer> emptyColumns = new ArrayList<>();

        List<Point> galactics = new ArrayList<>();

        List<String> columns = new ArrayList<>();

        for (int i = 0; i < getInput().size(); i++) {

            String[] letters = getInput().get(i).split("");
            if (Arrays.stream(letters).allMatch(p -> p.equals("."))) {
                emptyRows.add(i);
            }

            for (int j = 0; j < letters.length; j++) {
                if (columns.size() <= j) {
                    columns.add("");
                }
                columns.set(j, columns.get(j) + letters[j]);
                if (letters[j].equals("#")) {
                    galactics.add(new Point(i, j));
                }
            }
        }

        for (int i = 0; i < columns.size(); i++) {
            if (Arrays.stream(columns.get(i).split("")).allMatch(p -> p.equals("."))) {
                emptyColumns.add(i);
            }
        }

//        // createUniverse
//        String[][] universe = new String[getInput().size() + emptyRows.size()][getInput().get(0).length() + emptyColumns.size()];
//        for (String[] strings : universe) {
//            Arrays.fill(strings, ".");
//        }

        List<Point> expandedGalactics = new ArrayList<>();
        galactics.forEach(p ->
                {
                    int newX = p.x + (int) emptyRows.stream().filter(x -> x < p.x).count();
                    int newY = p.y + (int) emptyColumns.stream().filter(y -> y < p.y).count();
//                    universe[newX][newY] = "#";
                    expandedGalactics.add(new Point(newX, newY));
                }
        );
//        XyUtils.printBoard(universe);
        return expandedGalactics;
    }
}