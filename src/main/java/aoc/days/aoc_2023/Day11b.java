package aoc.days.aoc_2023;

import java.util.List;

public class Day11b extends Day11a {

    private int expansionRate;

    public Day11b() {
        super();
        setExpansionRate(1000000);
    }

    public Day11b(List<String> input, int expansionRate) {
        super(input);
        setExpansionRate(expansionRate);
    }

    @Override
    public void resolve() {
        super.resolve();
    }

    @Override
    public int getExpansionRate() {
        return expansionRate;
    }

    public void setExpansionRate(int expansionRate) {
        this.expansionRate = expansionRate - 1;
    }
}