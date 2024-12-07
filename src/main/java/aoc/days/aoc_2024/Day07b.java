package aoc.days.aoc_2024;

import java.util.List;

public class Day07b extends Day07a {

    public Day07b() {
        super();
    }

    public Day07b(List<String> input) {
        super(input);
    }

    @Override
    List<String> getPossibleOperators() {
        return List.of("+", "*", ".");
    }
}
