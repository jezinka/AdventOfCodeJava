package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;


public class Day05a extends Day {

    public Day05a() {
        super("5.txt");
    }

    public Day05a(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-05a";
    }

    @Override
    public void resolve() {
        List<String> vowels = List.of("a", "e", "i", "o", "u");
        String backreference = "(.)\\1";
        List<String> naughtyStrings = List.of("ab", "cd", "pq", "xy");

        AtomicInteger counter = new AtomicInteger(0);

        this.getInput().forEach(line -> {
            boolean count = Arrays.stream(line.split("")).filter(vowels::contains).count() > 2;
            boolean doubleLetters = Pattern.compile(backreference).matcher(line).find();
            boolean hasNaughtyStrings = naughtyStrings.stream().anyMatch(line::contains);

            if (count && doubleLetters && !hasNaughtyStrings) {
                counter.getAndSet(counter.get() + 1);
            }
        });

        this.setResult(counter.get());
    }
}
