package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day08a extends Day {

    public Day08a() {
        super();
    }

    public Day08a(List<String> input) {
        super(input);
    }

    public static HashMap<String, List<String>> map = new HashMap<>();

    @Override
    public void resolve() {

        List<String> input = getInput();

        String steps = input.get(0);

        prepareMap();

        String startNode = "AAA";
        String endNode = "ZZZ";

        long counter = findPath(steps, steps, startNode, endNode);

        setResult(counter);
    }

    void prepareMap() {
        List<String> input = getInput();
        for (int i = 2; i < input.size(); i++) {
            String line = input.get(i);
            Matcher matcher = Pattern.compile("(\\w{3}) = \\((\\w{3}), (\\w{3})\\)").matcher(line);
            if (matcher.matches()) {
                map.put(matcher.group(1), List.of(matcher.group(2), matcher.group(3)));
            }
        }
    }

    long findPath(String instructions, String steps, String startNode, String endNode) {
        long counter = 0;
        String position = startNode;

        while (!position.endsWith(endNode)) {
            if (steps.isEmpty()) {
                steps = instructions;
            }
            String step = steps.substring(0, 1);
            steps = steps.substring(1);

            List<String> newPositions = map.get(position);
            if (step.equals("L")) {
                position = newPositions.get(0);
            } else {
                position = newPositions.get(1);
            }

            counter++;
        }
        return counter;
    }
}

