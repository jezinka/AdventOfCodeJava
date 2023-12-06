package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06a extends Day {


    public Day06a() {
        super();
    }

    public Day06a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int possibilities = 1;
        List<List<Long>> timeDistanceRecord = prepareRecords();

        for (List<Long> td : timeDistanceRecord) {
            List<Long> result = new ArrayList<>();
            Long time = td.get(0);
            Long distanceRecord = td.get(1);
            for (int i = 0; i <= time; i++) {
                var v = i * (time - i);
                if (v > distanceRecord) {
                    result.add(v);
                }
            }
            possibilities *= result.size();
        }

        setResult(possibilities);
    }

    List<List<Long>> prepareRecords() {
        List<List<Long>> timeDistanceRecord = new ArrayList<>();

        List<Long> times = Arrays.stream(getInput().get(0).substring(getInput().get(0).indexOf(":") + 1).trim().split("\\s+")).map(Long::parseLong).toList();
        List<Long> distances = Arrays.stream(getInput().get(1).substring(getInput().get(1).indexOf(":") + 1).trim().split("\\s+")).map(Long::parseLong).toList();

        for (int i = 0; i < times.size(); i++) {
            timeDistanceRecord.add(List.of(times.get(i), distances.get(i)));
        }
        return timeDistanceRecord;
    }
}
