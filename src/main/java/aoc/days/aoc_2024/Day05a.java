package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.*;

public class Day05a extends Day {

    public Day05a() {
        super();
    }

    public Day05a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        Map<Integer, List<Integer>> orderOfPages = new HashMap<>();
        ArrayList<List<Integer>> validUpdates = processUpdates(orderOfPages, null);

        int sumOfMiddles = getSumOfMiddles(validUpdates);
        setResult(sumOfMiddles);
    }

    int getSumOfMiddles(ArrayList<List<Integer>> validUpdates) {
        return validUpdates.stream().mapToInt(u -> u.get((u.size() / 2))).sum();
    }

    ArrayList<List<Integer>> processUpdates(Map<Integer, List<Integer>> orderOfPages, ArrayList<List<Integer>> invalidUpdates) {

        ArrayList<List<Integer>> validUpdates = new ArrayList<>();
        for (String line : getInput()) {
            if (line.contains("|")) {
                List<Integer> instruction = Arrays.stream(line.split("\\|")).map(Integer::parseInt).toList();
                if (orderOfPages.containsKey(instruction.get(0))) {
                    orderOfPages.get(instruction.get(0)).add(instruction.get(1));
                } else {
                    List<Integer> value = new ArrayList<>();
                    value.add(instruction.get(1));
                    orderOfPages.put(instruction.get(0), value);
                }
            } else if (!line.isBlank()) {
                List<Integer> updates = Arrays.stream(line.split(",")).map(Integer::parseInt).toList();
                if (isValidUpdate(updates, orderOfPages, invalidUpdates)) {
                    validUpdates.add(List.copyOf(updates));
                }
            }
        }
        return validUpdates;
    }

    boolean isValidUpdate(List<Integer> updates, Map<Integer, List<Integer>> orderOfPages, ArrayList<List<Integer>> invalidUpdates) {
        boolean validUpdate = true;
        for (Integer u : updates) {
            if (orderOfPages.containsKey(u)) {
                if (!orderOfPages.get(u).stream().allMatch(pageBehind -> !updates.contains(pageBehind) || updates.indexOf(pageBehind) > updates.indexOf(u))) {
                    validUpdate = false;
                    if (invalidUpdates != null) {
                        invalidUpdates.add(updates);
                    }
                    break;
                }
            }
        }
        return validUpdate;
    }

}
