package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.List;

public class Day02b extends Day {

    public Day02b() {
        super();
    }

    public Day02b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int sum = 0;
        for (String line : getInput()) {

            int maxRed = 0;
            int maxGreen = 0;
            int maxBlue = 0;

            line = line.substring(line.indexOf(":") + 1);

            for (String game : line.split(";")) {
                for (String round : game.split(",")) {
                    round = round.trim();
                    int number = Integer.parseInt(round.substring(0, round.indexOf(" ")));
                    if (round.contains("red")) {
                        maxRed = Math.max(maxRed, number);
                    } else if (round.contains("blue")) {
                        maxBlue = Math.max(maxBlue, number);
                    } else {
                        maxGreen = Math.max(maxGreen, number);
                    }
                }
            }
            sum += maxRed * maxBlue * maxGreen;
        }
        setResult(sum);
    }
}
