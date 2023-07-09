package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Day05b extends Day {

    public Day05b() {
        super();
    }

    public Day05b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        AtomicInteger counter = new AtomicInteger(0);

        this.getInput().forEach(line -> {
            AtomicBoolean hasPair = new AtomicBoolean(false);
            boolean hasBetween = false;

            List<String> pairs = new ArrayList<>();
            for (int i = 0; i < line.length() - 1; i++) {
                pairs.add(line.substring(i, i + 2));
            }

            var frequency = pairs.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            frequency.forEach((key, value) -> {
                if (value > 1 && line.indexOf(key) + 1 != line.lastIndexOf(key)) {
                    hasPair.set(true);
                }
            });

            for (int i = 0; i < line.length() - 2; i++) {
                String window = line.substring(i, i + 3);
                if (window.charAt(0) == window.charAt(2)) {
                    hasBetween = true;
                    break;
                }
            }
            if (hasBetween && hasPair.get()) {
                counter.updateAndGet(v -> v + 1);
            }
        });

        this.setResult(counter.get());
    }
}
