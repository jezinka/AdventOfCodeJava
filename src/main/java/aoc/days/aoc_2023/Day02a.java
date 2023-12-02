package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.List;

public class Day02a extends Day {

    public Day02a() {
        super();
    }

    public Day02a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int maxRed = 12;
        int maxBlue = 14;
        int maxGreen = 13;

        int sum = 0;
        int gameId = 1;
        for (String line : getInput()) {
            boolean gameFailed = false;

            line = line.substring(line.indexOf(":") + 1);

            for (String game : line.split(";")) {
                for (String round : game.split(",")) {
                    round = round.trim();
                    int number = Integer.parseInt(round.substring(0, round.indexOf(" ")));
                    if (round.contains("red")) {
                        gameFailed = number > maxRed;
                    } else if (round.contains("blue")) {
                        gameFailed = number > maxBlue;
                    } else {
                        gameFailed = number > maxGreen;
                    }
                    if (gameFailed) {
                        break;
                    }
                }

                if (gameFailed) {
                    break;
                }
            }

            if (!gameFailed) {
                sum += gameId;
            }
            gameId++;
        }
        setResult(sum);
    }
}
