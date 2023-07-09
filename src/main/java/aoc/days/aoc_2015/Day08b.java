package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Day08b extends Day {

    List<List> charactersLength = new ArrayList<>();

    public Day08b() {
        super();
    }

    public Day08b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        AtomicInteger counter = new AtomicInteger();

        for (String input : this.getInput()) {
            int count = input.length();

            int encodedOutput = 0;

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == '\"' || c == '\\') {
                    encodedOutput++;
                }
                encodedOutput++;
            }
            encodedOutput += 2;

            counter.addAndGet(encodedOutput - count);
            charactersLength.add(List.of(input, count, encodedOutput));
        }

        this.setResult(counter.get());
    }

    public List<List> getCharactersLength() {
        return charactersLength;
    }
}
