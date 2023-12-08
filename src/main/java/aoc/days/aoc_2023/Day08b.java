package aoc.days.aoc_2023;

import aoc.utils.LCM;

import java.util.ArrayList;
import java.util.List;

public class Day08b extends Day08a {

    public Day08b() {
        super();
    }

    public Day08b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        List<String> input = getInput();
        String steps = input.get(0);
        prepareMap();

        List<Long> pathsLength = new ArrayList<>();
        String startNode = "A";
        String endNode = "Z";
        for (String start : map.keySet().stream().filter(k -> k.endsWith(startNode)).toList()) {
            long counter = findPath(steps, steps, start, endNode);
            pathsLength.add(counter);
        }

        setResult(LCM.lcm(pathsLength));
    }
}

