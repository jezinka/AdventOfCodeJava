package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static aoc.days.aoc_2023.Day15a.hashAlgorithm;

public class Day15b extends Day {

    public Day15b() {
        super();
    }

    public Day15b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Integer result = 0;
        Map<Integer, List<String>> boxes = new HashMap<>();

        for (String in : getInput().get(0).trim().split(",")) {
            String label = getLabel(in);

            int key = hashAlgorithm(label);
            if (!boxes.containsKey(key)) {
                boxes.put(key, new ArrayList<>());
            }

            List<String> lenses = boxes.get(key);
            if (in.contains("=")) {
                if (lenses.stream().anyMatch(l -> getLabel(l).equals(label))) {
                    int index = lenses.indexOf(lenses.stream().filter(l -> getLabel(l).equals(label)).findFirst().get());
                    lenses.remove(index);
                    lenses.add(index, in);
                } else {
                    lenses.add(in);
                }
            } else {
                lenses.remove(lenses.stream().filter(l -> getLabel(l).equals(label)).findFirst().orElse(null));
            }
        }

        Map<Integer, List<String>> notEmptyBoxes = boxes.entrySet()
                .stream()
                .filter(b -> !b.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        for (Map.Entry<Integer, List<String>> entry : notEmptyBoxes.entrySet()) {
            Integer key = entry.getKey();
            List<String> value = entry.getValue();
            int lensesPower = 0;

            for (int i = 0; i < value.size(); i++) {
                String lens = value.get(i);
                int slot = i + 1;
                int boxNumber = key + 1;
                int focalLength = Integer.parseInt(lens.substring(lens.indexOf("=") + 1));
                lensesPower += boxNumber * slot * focalLength;
            }
            result += lensesPower;
        }

        setResult(result);
    }

    private String getLabel(String in) {
        String token = in.contains("=") ? "=" : "-";
        return in.substring(0, in.indexOf(token));
    }
}