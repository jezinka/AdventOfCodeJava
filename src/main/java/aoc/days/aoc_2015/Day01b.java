package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.List;

public class Day01b extends Day {

    public Day01b() {
        super("1.txt");
    }

    public Day01b(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-01b";
    }

    @Override
    public void resolve() {
        List<String> inputLineSplitBySingleCharacters = this.getInputLineSplitBySingleCharacters();

        long floor = 0;
        long processedInstructionsCounter = 0;

        while (floor != -1) {
            String instruction = inputLineSplitBySingleCharacters.remove(0);
            if (instruction.equals("(")) {
                floor++;
            } else if (instruction.equals(")")) {
                floor--;
            }
            processedInstructionsCounter++;
        }

        this.setResult(processedInstructionsCounter);
    }
}
