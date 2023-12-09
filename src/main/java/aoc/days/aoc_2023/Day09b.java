package aoc.days.aoc_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day09b extends Day09a {

    public Day09b() {
        super();
    }

    public Day09b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int result = 0;
        for (var line : getInput()) {
            List<Integer> numbers = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            ArrayList<List<Integer>> diffsLevels = extrapolate(numbers);

            result += diffsLevels.get(0).get(0);
        }

        setResult(result);
    }

    @Override
    public void getExtrapolationMethod(ArrayList<List<Integer>> diffsLevels) {
        extrapolatePast(diffsLevels);
    }

    private static void extrapolatePast(ArrayList<List<Integer>> diffsLevels) {
        for (int i = diffsLevels.size() - 1; i > 0; i--) {
            List<Integer> upper = diffsLevels.get(i - 1);
            List<Integer> zeros = diffsLevels.get(i);
            upper.add(0, upper.get(0) - zeros.get(0));
        }
    }
}

