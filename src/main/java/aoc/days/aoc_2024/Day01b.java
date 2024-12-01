package aoc.days.aoc_2024;

import java.util.List;

public class Day01b extends Day01a {

    public Day01b() {
        super();
    }

    public Day01b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        TwoLists lists = splitInputIntoTwoLists();

        long similarityScore = 0L;

        for (Long id : lists.numbersLeft()) {
            long counter = 0L;
            for (Long r : lists.numbersRight()) {
                if (r.equals(id)) {
                    counter++;
                }
            }

            similarityScore += id * counter;
        }
        this.setResult(similarityScore);
    }
}
