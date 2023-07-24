package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Day16a extends Day {

    public Day16a() {
        super();
    }

    public Day16a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<AuntSue> possibleSues = getInput().stream().map(AuntSueA::new).collect(Collectors.toList());
        findAunt(possibleSues);
    }

    public void findAunt(List<AuntSue> possibleSues) {
        Map<String, Integer> mfcsamResult = Map.of(
                "children", 3,
                "cats", 7,
                "samoyeds", 2,
                "pomeranians", 3,
                "akitas", 0,
                "vizslas", 0,
                "goldfish", 5,
                "trees", 3,
                "cars", 2,
                "perfumes", 1);

        mfcsamResult.forEach((k, v) -> possibleSues.removeAll(possibleSues.stream().filter(a -> !a.isValidAunt(k, v)).toList()));

        if (possibleSues.size() == 1) {
            setResult(possibleSues.get(0).number);
        } else {
            throw new RuntimeException("Wrong answer!");
        }
    }

    abstract class AuntSue {
        int number;
        Map<String, Integer> properties = new HashMap();

        public AuntSue(String instruction) {
            int colon = instruction.indexOf(":");
            number = Integer.parseInt(instruction.substring(4, colon));
            Arrays.stream(instruction.substring(colon + 1).trim().split(",")).map(ins -> ins.split(":")).forEach(split -> {
                properties.put(split[0].trim(), Integer.parseInt(split[1].trim()));
            });
        }

        abstract boolean isValidAunt(String key, Integer value);
    }

    class AuntSueA extends AuntSue {

        public AuntSueA(String instruction) {
            super(instruction);
        }

        @Override
        boolean isValidAunt(String key, Integer value) {
            return !properties.containsKey(key) || properties.get(key).equals(value);
        }
    }
}

