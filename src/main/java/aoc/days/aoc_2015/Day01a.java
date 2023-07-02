package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.List;

public class Day01a extends Day {

    public Day01a(String s) {
        super(s);
    }

    public Day01a(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-01a";
    }

    @Override
    public void resolve() {
        List<String> characters = this.getInputLineSplitBySingleCharacters();
        long openingBracketCount = characters.stream().filter(c -> c.equals("(")).count();
        long closingBracketCount = characters.stream().filter(c -> c.equals(")")).count();
        this.setResult(openingBracketCount - closingBracketCount);
    }
}
