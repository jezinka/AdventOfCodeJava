package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.List;


public class Day10a extends Day {

    private int rounds = 40;

    public Day10a() {
        super();
    }

    public Day10a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        String sequence = getInput().get(0);

        for (int i = 0; i < this.getRounds(); i++) {
            var counter = 0;
            StringBuilder newSequence = new StringBuilder();
            String toCount = sequence.substring(0, 1);

            for (String input : sequence.split("")) {
                if (input.equals(toCount)) {
                    counter++;
                } else {
                    newSequence.append(counter).append(toCount);
                    counter = 1;
                    toCount = input;
                }
            }
            newSequence.append(counter).append(toCount);
            sequence = newSequence.toString();

        }
        this.setResult(sequence.length());
    }

    public void setRounds(int i) {
        this.rounds = i;
    }

    public int getRounds(){
        return rounds;
    }
}
