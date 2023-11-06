package aoc.days.aoc_2016;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day06a extends Day {

    public Day06a() {
        super();
    }

    public Day06a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Map<Integer, List<String>> message = new HashMap<>();

        for (String line : getInput()) {
            int key = 0;
            for (String l : line.split("")) {
                if (!message.containsKey(key)) {
                    message.put(key, new ArrayList<>());
                }
                message.get(key).add(l);
                key++;
            }
        }

        StringBuilder password = new StringBuilder();
        for (List<String> letters : message.values()) {
            password.append(letters.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().sorted(getEntryComparator())
                    .map(Map.Entry::getKey)
                    .toList().get(0));
        }

        setResult(password.toString());
    }

    Comparator<Map.Entry<String, Long>> getEntryComparator() {
        return Map.Entry.<String, Long>comparingByValue().reversed();
    }
}
