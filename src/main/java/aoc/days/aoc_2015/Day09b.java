package aoc.days.aoc_2015;

import java.util.List;


public class Day09b extends Day09a {

    public Day09b() {
        super();
    }

    public Day09b(List<String> input) {
        super(input);
    }

    @Override
    public void setResult(List<Integer> travelsLength) {
        travelsLength.stream().max(Integer::compareTo).ifPresent(this::setResult);
    }
}
