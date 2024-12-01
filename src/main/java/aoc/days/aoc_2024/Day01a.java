package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day01a extends Day {

    public Day01a() {
        super();
    }

    public Day01a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        TwoLists lists = splitInputIntoTwoLists();

        lists.numbersLeft.sort(Long::compareTo);
        lists.numbersRight.sort(Long::compareTo);

        long distance = 0L;

        for (int i = 0; i < lists.numbersLeft.size(); i++) {
            distance += Math.abs(lists.numbersLeft.get(i) - lists.numbersRight.get(i));
        }
        this.setResult(distance);
    }

    TwoLists splitInputIntoTwoLists() {
        List<Long> numbersLeft = new ArrayList<>();
        List<Long> numbersRight = new ArrayList<>();

        getInput().forEach(l -> {
            List<Long> split = Arrays.stream(l.split("\\s+"))
                    .filter(s -> !s.isBlank())
                    .map(Long::valueOf).toList();

            numbersLeft.add(split.get(0));
            numbersRight.add(split.get(1));
        });
        return new TwoLists(numbersLeft, numbersRight);
    }

    record TwoLists(List<Long> numbersLeft, List<Long> numbersRight) {
    }
}
