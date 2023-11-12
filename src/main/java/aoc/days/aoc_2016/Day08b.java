package aoc.days.aoc_2016;

import aoc.utils.XyUtils;

import java.util.List;

public class Day08b extends Day08a {

    public Day08b() {
        super();
    }

    public Day08b(List<String> input) {
        super(input);
    }

    public Day08b(List<String> input, int x, int y) {
        super(input, x, y);
    }

    @Override
    public void resolve() {
        super.resolve();
        setResult(XyUtils.boardDisplay(getBoard()));
    }
}
