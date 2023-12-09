package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day09a extends Day {

    public Day09a() {
        super();
    }

    public Day09a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int result = 0;
        for (var line : getInput()) {
            List<Integer> numbers = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            ArrayList<List<Integer>> diffsLevels = extrapolate(numbers);

            result += diffsLevels.get(0).get(diffsLevels.get(0).size() - 1);
        }

        setResult(result);
    }

    ArrayList<List<Integer>> extrapolate(List<Integer> numbers) {
        ArrayList<List<Integer>> diffsLevels = getData(numbers);
        getExtrapolationMethod(diffsLevels);
        return diffsLevels;
    }

    public void getExtrapolationMethod(ArrayList<List<Integer>> diffsLevels) {
        extrapolateFuture(diffsLevels);
    }

    private static void extrapolateFuture(ArrayList<List<Integer>> diffsLevels) {
        for (int i = diffsLevels.size() - 1; i > 0; i--) {
            List<Integer> upper = diffsLevels.get(i - 1);
            List<Integer> lower = diffsLevels.get(i);
            upper.add(lower.get(lower.size() - 1) + upper.get(upper.size() - 1));
        }
    }

    static ArrayList<List<Integer>> getData(List<Integer> numbers) {
        ArrayList<List<Integer>> diffsLevels = new ArrayList<>();
        diffsLevels.add(numbers);

        while (true) {
            List<Integer> diffs = new ArrayList<>();
            for (int i = 0; i < numbers.size() - 1; i++) {
                Integer diff = numbers.get(i + 1) - numbers.get(i);
                diffs.add(diff);
            }
            diffsLevels.add(new ArrayList<>(diffs));
            if (diffs.stream().allMatch(d -> d == 0)) {
                break;
            }
            numbers = new ArrayList<>(diffs);
        }
        return diffsLevels;
    }
}

