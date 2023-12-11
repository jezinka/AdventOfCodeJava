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
        List<List<Long>> galactics = getExtendedGalacticsLocation();
        List<List<List<Long>>> pairs = new ArrayList<>();
        for (int i = 0; i < galactics.size(); i++) {
            for (int j = i + 1; j < galactics.size(); j++) {
                pairs.add(List.of(List.of(galactics.get(i).get(0), galactics.get(i).get(1)), List.of(galactics.get(j).get(0), galactics.get(j).get(1))));
            }
        }
        long galacticsDistance = pairs.stream().map(p -> Map.entry(p, calculateManhattanDistance(p))).mapToLong(Map.Entry::getValue).sum();
        setResult(galacticsDistance);
    }

    private long calculateManhattanDistance(List<List<Long>> p) {
        return Math.abs(p.get(0).get(0) - p.get(1).get(0)) + Math.abs(p.get(0).get(1) - p.get(1).get(1));
    }

    private List<List<Long>> getExtendedGalacticsLocation() {
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

        List<List<Long>> expandedGalactics = new ArrayList<>();
        galactics.forEach(p ->
                {
                    long newX = p.x + getExpansionRow(p.x, emptyRows);
                    long newY = p.y + getExpansionColumn(p.y, emptyColumns);
                    expandedGalactics.add(List.of(newX, newY));
                }
        );
        return expandedGalactics;
    }

    private long getExpansionColumn(Integer py, List<Integer> emptyColumns) {
        return emptyColumns.stream().filter(y -> y < py).count() * getExpansionRate();
    }

    private long getExpansionRow(Integer px, List<Integer> emptyRows) {
        return emptyRows.stream().filter(x -> x < px).count() * getExpansionRate();
    }

    public int getExpansionRate() {
        return 1;
    }
}