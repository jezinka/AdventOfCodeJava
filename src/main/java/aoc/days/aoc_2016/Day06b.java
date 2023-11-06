package aoc.days.aoc_2016;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Day06b extends Day06a {

    public Day06b() {
        super();
    }

    public Day06b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        super.resolve();
    }

    @Override
    Comparator<Map.Entry<String, Long>> getEntryComparator() {
        return Map.Entry.comparingByValue();
    }
}
