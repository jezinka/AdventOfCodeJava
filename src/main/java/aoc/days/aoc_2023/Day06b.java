package aoc.days.aoc_2023;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day06b extends Day06a {


    public Day06b() {
        super();
    }

    public Day06b(List<String> input) {
        super(input);
    }

    @Override
    List<List<Long>> prepareRecords() {
        List<List<Long>> timeDistanceRecord = new ArrayList<>();

        Long time = Long.parseLong(StringUtils.join(Arrays.stream(getInput().get(0).substring(getInput().get(0).indexOf(":") + 1).trim().split("\\s+")).toList(), ""));
        Long distance = Long.parseLong(StringUtils.join(Arrays.stream(getInput().get(1).substring(getInput().get(1).indexOf(":") + 1).trim().split("\\s+")).toList(), ""));

        timeDistanceRecord.add(List.of(time, distance));
        return timeDistanceRecord;
    }
}
