package aoc.days.aoc_2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day03b extends Day03a {

    public Day03b() {
        super();
    }

    public Day03b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        int possibleTriangles = 0;
        
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();

        for (String instruction : this.getInput()) {
            List<Integer> sides = Arrays.stream(prepareLine(instruction).split(" ")).map(Integer::parseInt).toList();
            first.add(sides.get(0));
            second.add(sides.get(1));
            third.add(sides.get(2));

            if (first.size() == 3) {
                possibleTriangles += isTriangle(first);
                possibleTriangles += isTriangle(second);
                possibleTriangles += isTriangle(third);
                first.clear();
                second.clear();
                third.clear();
            }
        }

        setResult(possibleTriangles);
    }
}
