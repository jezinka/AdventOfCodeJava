package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02a extends Day {

    public Day02a() {
        super();
    }

    public Day02a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        long validInputs = 0L;

        for (String line : getInput()) {
            List<Integer> split = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
            List<Integer> levels = new ArrayList<>();
            for (int i = 1; i < split.size(); i++) {
                levels.add(split.get(i - 1) - split.get(i));
            }

            if (isValid(levels)) {
                validInputs++;
            }
        }

        setResult(validInputs);
    }

    boolean isValid(List<Integer> levels) {
        return levels.stream().allMatch(l -> Math.abs(l) <= 3)
               && levels.stream().allMatch(l -> Math.abs(l) >= 1)
               && (levels.stream().allMatch(l -> l > 0) || levels.stream().allMatch(l -> l < 0));
    }
}
