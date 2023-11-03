package aoc.days.aoc_2016;

import aoc.days.Day;

import java.util.Arrays;
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

        int possibleTriangles = 0;
        for (String instruction : this.getInput()) {
            String preparedLine = prepareLine(instruction);
            List<Integer> sides = Arrays.stream(preparedLine.split(" ")).map(Integer::parseInt).toList();
            possibleTriangles += isTriangle(sides);
        }

        setResult(possibleTriangles);
    }

    String prepareLine(String instruction) {
        return instruction.trim().replaceAll("\s{2,}", " ");
    }

    int isTriangle(List<Integer> sides) {
        sides = sides.stream().sorted().toList();
        if (sides.get(0) + sides.get(1) > sides.get(2)) {
            return 1;
        }
        return 0;
    }
}
