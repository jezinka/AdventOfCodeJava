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
    public String getName() {
        return "2015-09b";
    }

    @Override
    public void setResult(List<Integer> travelsLength) {
        this.setResult(travelsLength.stream().max(Integer::compareTo).get());
    }
}
