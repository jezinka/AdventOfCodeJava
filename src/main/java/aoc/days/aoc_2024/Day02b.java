package aoc.days.aoc_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02b extends Day02a {

    public Day02b() {
        super();
    }

    public Day02b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        long validInputs = 0L;

        for (String line : getInput()) {
            List<Integer> split = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();

            List<Integer> levels = getLevels(split);

            if (isValid(levels)) {
                validInputs++;
            } else {
                for (int i = 0; i < split.size(); i++) {
                    List<Integer> splitCopy = new ArrayList<>(List.copyOf(split));
                    splitCopy.remove(i);
                    if (isValid(getLevels(splitCopy))) {
                        validInputs++;
                        break;
                    }
                }
            }
        }

        setResult(validInputs);
    }

    private List<Integer> getLevels(List<Integer> split) {
        List<Integer> levels = new ArrayList<>();
        for (int i = 1; i < split.size(); i++) {
            levels.add(split.get(i - 1) - split.get(i));
        }
        return levels;
    }
}
