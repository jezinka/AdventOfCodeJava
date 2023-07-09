package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class Day02b extends Day {

    public Day02b() {
        super("2.txt");
    }

    public Day02b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {


        AtomicLong totalFeets = new AtomicLong();

        List<String> boxes = this.getInput(); //l;w;h
        boxes.stream().map(dimensions -> dimensions.split("x")).forEach(xes -> {
                    int l = Integer.parseInt(xes[0]);
                    int w = Integer.parseInt(xes[1]);
                    int h = Integer.parseInt(xes[2]);
                    long bowLength = (long) l * w * h;
                    long smallestPerimeter = Collections.min(List.of(2 * (l + w), 2 * (l + h), 2 * (w + h)));
                    totalFeets.updateAndGet(v -> v + bowLength + smallestPerimeter);
                }
        );

        this.setResult(totalFeets.get());
    }
}
