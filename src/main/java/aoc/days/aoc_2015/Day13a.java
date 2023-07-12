package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class Day13a extends Day {

    public Day13a() {
        super();
    }

    public Day13a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Integer> sumOrder = new ArrayList<>();
        Set<String> guests = new HashSet();
        List<List> instructions = new ArrayList<>();

        prepareGuestList(guests, instructions);

        List<List<String>> allOptions = new ArrayList<>();
        makePermutations(new ArrayList<>(), guests, allOptions);
        //TODO: remove duplicates -> ABCD == BCDA == CDAB == DABC
        allOptions.forEach(order -> {
            int counter = 0;
            for (int i = 0; i < order.size(); i++) {
                String guest = order.get(i);
                String guest2;
                if (i + 1 == order.size()) {
                    guest2 = order.get(0);
                } else {
                    guest2 = order.get(i + 1);
                }

                List<List> lines = instructions.stream().filter(ins -> ins.get(0).equals(guest) && ins.get(1).equals(guest2) || ins.get(0).equals(guest2) && ins.get(1).equals(guest)).toList();
                if (!lines.isEmpty()) {
                    counter += (int) lines.get(0).get(2) + (int) lines.get(1).get(2);
                }
            }
            sumOrder.add(counter);
        });
        this.setResult(Collections.max(sumOrder));
    }

    public void prepareGuestList(Set<String> guests, List<List> instructions) {
        this.getInput().forEach(line -> {
            Matcher matcher = Pattern.compile("(\\w+) would (\\w+) (\\d+) happiness units by sitting next to (\\w+)\\.").matcher(line);
            if (matcher.matches()) {
                String guest1 = matcher.group(1);
                String guest2 = matcher.group(4);
                int units = Integer.parseInt(matcher.group(3)) * (matcher.group(2).equals("gain") ? 1 : -1);
                guests.add(guest1);
                guests.add(guest2);
                instructions.add(List.of(guest1, guest2, units));
            }
        });
    }

    private void makePermutations(List<String> sitted, Set<String> guests, List<List<String>> allOptions) {
        if (guests.isEmpty()) {
            allOptions.add(sitted);
            return;
        }
        guests.forEach(g -> {
            List<String> order = new ArrayList<>(sitted);
            order.add(g);
            makePermutations(order, guests.stream().filter(leftOver -> !g.equals(leftOver)).collect(Collectors.toSet()), allOptions);
        });
    }
}

