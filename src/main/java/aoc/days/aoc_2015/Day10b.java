package aoc.days.aoc_2015;

import java.util.List;


public class Day10b extends Day10a {

    private int rounds = 50;

    public Day10b() {
        super();
    }

    public Day10b(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-10b";
    }

    @Override
    public int getRounds() {
        return rounds;
    }
}
