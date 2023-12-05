package aoc.days.aoc_2023;

import aoc.days.Day;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Day03a extends Day {


    public Day03a() {
        super();
    }

    public Day03a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Integer> parts = new ArrayList<>();
        List<String> input = getInput();

        for (int x = 0; x < input.size(); x++) {
            String line = input.get(x).trim();
            List<String> number = new ArrayList<>();
            List<Point> numberPosition = new ArrayList<>();
            for (int y = 0; y < line.split("").length; y++) {
                String c = line.substring(y, y + 1);
                if (StringUtils.isNumeric(c)) {
                    number.add(c);
                    numberPosition.add(new Point(x, y));
                } else {
                    if (!number.isEmpty()) {
                        doBufor(parts, number, numberPosition);
                    }
                }
            }
            if (!number.isEmpty()) {
                doBufor(parts, number, numberPosition);
            }
        }

        int sum = 0;
        for (Integer p : parts) {
            sum += p;
        }
        setResult(sum);
    }

    void doBufor(List<Integer> parts, List<String> number, List<Point> numberPosition) {
        NeighbourhoodRange result = getNeighbourhoodRange(numberPosition);

        boolean part = true;

        for (int i = result.minX(); i <= result.maxX(); i++) {
            for (int j = result.minY(); j <= result.maxY(); j++) {
                int finalI = i;
                int finalJ = j;
                if (numberPosition.stream().noneMatch(p -> p.x == finalI && p.y == finalJ)) {
                    String special = getInput().get(i).substring(j, j + 1);
                    if (!special.equals(".")) {
                        part = false;
                    }
                }
                if (!part) {
                    break;
                }
            }
            if (!part) {
                break;
            }
        }
        int n = Integer.parseInt(StringUtils.join(number, ""));
        if (!part) {
            parts.add(n);
        }

        number.clear();
        numberPosition.clear();
    }

    NeighbourhoodRange getNeighbourhoodRange(List<Point> numberPosition) {
        int maxY = Math.min(getInput().size() - 1, numberPosition.stream().mapToInt(p -> p.y).max().getAsInt() + 1);
        int minY = Math.max(0, numberPosition.stream().mapToInt(p -> p.y).min().getAsInt() - 1);
        int maxX = Math.min(getInput().get(0).length() - 1, numberPosition.stream().mapToInt(p -> p.x).max().getAsInt() + 1);
        int minX = Math.max(0, numberPosition.stream().mapToInt(p -> p.x).min().getAsInt() - 1);
        return new NeighbourhoodRange(maxY, minY, maxX, minX);
    }

    record NeighbourhoodRange(int maxY, int minY, int maxX, int minX) {
    }
}
