package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Day08a extends Day {

    List<List> charactersLength = new ArrayList<>();

    public Day08a() {
        super("8.txt");
    }

    public Day08a(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-08a";
    }

    @Override
    public void resolve() {
        AtomicInteger counter = new AtomicInteger();

        this.getInput().forEach(input -> {
            int count = input.length();

            int cleanOutput = 0;
            input = input.substring(1, input.length() - 1);

            int i = 0;
            while (i < input.length()) {

                char c = input.charAt(i);
                if (c == '\\') {
                    if (i + 1 < input.length()) {
                        if (input.charAt(i + 1) == 'x' && i + 3 < input.length() && input.substring(i + 2, i + 4).matches("[0-9a-f]{2}")) {
                            i += 4;
                        } else if (input.charAt(i + 1) == '\\') {
                            i += 2;
                        } else if (input.charAt(i + 1) == '"') {
                            i += 2;
                        }
                    }
                } else {
                    i++;
                }
                cleanOutput++;
            }


            counter.addAndGet(count - cleanOutput);
            charactersLength.add(List.of(input, count, cleanOutput));
        });

        this.setResult(counter.get());
    }

    public List<List> getCharactersLength() {
        return charactersLength;
    }
}
