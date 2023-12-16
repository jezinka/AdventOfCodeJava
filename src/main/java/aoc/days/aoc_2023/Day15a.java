package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.List;

public class Day15a extends Day {

    public Day15a() {
        super();
    }

    public Day15a(List<String> input) {
        super(input);
    }

    public static int hashAlgorithm(String input) {
        int sum = 0;
        for (char c : input.toCharArray()) {
            sum += c;
            sum *= 17;
            sum %= 256;
        }
        return sum;
    }

    @Override
    public void resolve() {
        int result = 0;
        for (String in : getInput().get(0).trim().split(",")) {
            result += hashAlgorithm(in);
        }
        setResult(result);
    }
}