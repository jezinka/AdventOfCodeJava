package aoc.days.aoc_2016;

import aoc.days.Day;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day04a extends Day {

    public Day04a() {
        super();
    }

    public Day04a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int sumId = 0;

        for (String instruction : this.getInput()) {
            var groups = Pattern.compile("(?<name>[a-z\\-]+)-(?<id>\\d+)\\[(?<checksum>\\w+)\\]").matcher(instruction);
            if (groups.matches()) {
                String name = groups.group("name");
                int id = Integer.parseInt(groups.group("id"));
                String checksum = groups.group("checksum");

                if (getChecksum(name).equals(checksum)) {
                    sumId += id;
                }
            }
        }

        setResult(sumId);
    }

    String getChecksum(String name) {
        return Arrays.stream(name.replaceAll("-", "").split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(5)
                .collect(Collectors.joining());
    }
}
