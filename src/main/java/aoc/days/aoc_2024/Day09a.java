package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day09a extends Day {

    public Day09a() {
        super();
    }

    public Day09a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        List<Integer> unZipped = new ArrayList<>();

        var diskMap = getInput().get(0);
        int fileId = 0;
        List<Integer> list = Arrays.stream(diskMap.split("")).map(Integer::parseInt).toList();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i); j++) {
                if (i % 2 == 0) {
                    unZipped.add(fileId);
                } else {
                    unZipped.add(null);
                }
            }
            if (i % 2 == 0) {
                fileId++;
            }
        }

        int start = 0;
        int end = unZipped.size() - 1;
        while (start < end) {
            while (unZipped.get(start) != null) {
                start++;
            }
            while (unZipped.get(end) == null) {
                end--;
            }

            if (start > end) {
                break;
            }

            var temp = unZipped.get(start);
            unZipped.set(start, unZipped.get(end));
            unZipped.set(end, temp);
        }

        var onlyFiles = unZipped.stream().filter(Objects::nonNull).toList();
        long checksum = 0L;
        int index = 0;
        for (Integer onlyFile : onlyFiles) {
            checksum += (long) onlyFile * index;
            index++;
        }
        setResult(checksum);
    }
}
