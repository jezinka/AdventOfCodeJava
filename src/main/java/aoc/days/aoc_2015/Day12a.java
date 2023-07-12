package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;


public class Day12a extends Day {

    public Day12a() {
        super();
    }

    public Day12a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        AtomicLong counter = new AtomicLong();
        this.getInput().forEach(line -> {
            var matcher = Pattern.compile("-?\\d+").matcher(line);

            List<Integer> integerList = new ArrayList<>();
            while (matcher.find()) {
                integerList.add(Integer.parseInt(matcher.group()));
            }
            counter.addAndGet(integerList.stream().reduce(0, Integer::sum));
        });

        this.setResult(counter.get());
    }
}

