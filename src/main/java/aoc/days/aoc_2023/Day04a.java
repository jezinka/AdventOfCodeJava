package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day04a extends Day {


    public Day04a() {
        super();
    }

    public Day04a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int sum = 0;
        for (String line : getInput()) {
            List<String> intersection = getIntersection(line);

            if (!intersection.isEmpty()) {
                sum += (int) Math.pow(2, intersection.size() - 1);
            }
        }
        setResult(sum);
    }

    static List<String> getIntersection(String line) {
        line = line.substring(line.indexOf(":") + 1).trim();
        String[] split = line.split(" \\| ");
        List<String> winning = new ArrayList<>(Arrays.stream(split[0].split(" +")).toList());
        List<String> numbers = new ArrayList<>(Arrays.stream(split[1].split(" +")).toList());
        return numbers.stream().filter(winning::contains).toList();
    }
}
