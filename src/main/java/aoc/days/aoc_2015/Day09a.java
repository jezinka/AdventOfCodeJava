package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Day09a extends Day {

    List<List<String>> posibilities = new ArrayList<>();

    public Day09a() {
        super("9.txt");
    }

    public Day09a(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-09a";
    }

    @Override
    public void resolve() {
        List<Integer> travelsLength = getTravelsLength();
        setResult(travelsLength);
    }

    private List<Integer> getTravelsLength() {
        Map<String, Integer> distances = new HashMap();
        Set<String> destinations = new HashSet<>();

        for (String input : this.getInput()) {
            Matcher matcher = Pattern.compile("([A-Za-z]+) to ([A-Za-z]+) = (\\d+)").matcher(input.trim());
            if (matcher.matches()) {
                String from = matcher.group(1);
                String to = matcher.group(2);
                distances.put("%s_%s".formatted(from, to), Integer.parseInt(matcher.group(3)));
                destinations.addAll(List.of(from, to));
            }
        }

        travel(new ArrayList<>(), destinations);

        List<Integer> travelsLength = new ArrayList<>();
        for (List<String> possible : posibilities) {
            Integer length = 0;
            for (int i = 0; i < possible.size() - 1; i++) {
                if (distances.containsKey(possible.get(i) + "_" + possible.get(i + 1))) {
                    length += distances.get(possible.get(i) + "_" + possible.get(i + 1));
                } else {
                    length += distances.get(possible.get(i + 1) + "_" + possible.get(i));
                }
            }
            travelsLength.add(length);
        }
        return travelsLength;
    }

    public void setResult(List<Integer> travelsLength) {
        this.setResult(travelsLength.stream().min(Integer::compareTo).get());
    }


    private void travel(List<String> route, Set<String> destinations) {
        if (destinations.isEmpty()) {
            posibilities.add(route);
            return;
        }
        for (String destination : destinations) {
            ArrayList<String> newRoute = new ArrayList<>(route);
            newRoute.add(destination);
            travel(newRoute, destinations.stream().filter(d -> !d.equals(destination)).collect(Collectors.toSet()));
        }
    }
}
