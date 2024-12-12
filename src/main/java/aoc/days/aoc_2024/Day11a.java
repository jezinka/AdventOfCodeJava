package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Day11a extends Day {

    private final int numberOfBlinks;
    private AtomicLong counter = new AtomicLong(0);

    public Day11a() {
        super();
        this.numberOfBlinks = 25;
    }

    public Day11a(List<String> input, int numberOfBlinks) {
        super(input);
        this.numberOfBlinks = numberOfBlinks;
    }

    @Override
    public void resolve() {
        List<Long> stones = new ArrayList<>();
        for (String s : getInput().get(0).split(" ")) {
            stones.add(Long.parseLong(s));
        }

        for (var s : stones) {
            getStones(s, 0);
        }

        setResult(counter.get());
    }

    private void getStones(Long s, int j) {

        if (j == getNumberOfBlinks()) {
            counter.getAndIncrement();
            return;
        }

        int step = j + 1;
        if (s == 0) {
            getStones(1L, step);
        } else if (s.toString().length() % 2 == 0) {
            String stringStone = s.toString();
            getStones(Long.parseLong(stringStone.substring(0, stringStone.length() / 2)), step);
            getStones(Long.parseLong(stringStone.substring((stringStone.length() / 2))), step);
        } else {
            getStones(s * 2024, step);
        }
    }

    public int getNumberOfBlinks() {
        return numberOfBlinks;
    }
}
