package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


public class Day02a extends Day {

    public Day02a() {
        super("2.txt");
    }

    public Day02a(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-02a";
    }

    @Override
    public void resolve() {
        // 2*l*w + 2*w*h + 2*h*l
        AtomicLong totalFeets = new AtomicLong();

        List<String> boxes = this.getInput(); //l;w;h
        boxes.stream().map(dimensions -> dimensions.split("x")).forEach(xes -> {
                    int l = Integer.parseInt(xes[0]);
                    int w = Integer.parseInt(xes[1]);
                    int h = Integer.parseInt(xes[2]);
                    long smallestSide = Collections.min(List.of(l * w, l * h, w * h));
                    totalFeets.updateAndGet(v -> v + (2L * l * w) + (2L * w * h) + (2L * h * l) + smallestSide);
                }
        );

        this.setResult(totalFeets.get());
    }
}
