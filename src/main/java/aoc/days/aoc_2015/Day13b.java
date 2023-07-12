package aoc.days.aoc_2015;

import java.util.List;
import java.util.Set;


public class Day13b extends Day13a {

    public Day13b() {
        super();
    }

    public Day13b(List<String> input) {
        super(input);
    }

    @Override
    public void prepareGuestList(Set<String> guests, List<List> instructions) {
        super.prepareGuestList(guests, instructions);
        guests.add("me");
    }
}

