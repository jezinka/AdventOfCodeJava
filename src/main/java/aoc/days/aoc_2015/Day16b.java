package aoc.days.aoc_2015;

import java.util.List;
import java.util.stream.Collectors;


public class Day16b extends Day16a {

    public Day16b() {
        super();
    }

    public Day16b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<AuntSue> possibleSues = getInput().stream().map(AuntSueB::new).collect(Collectors.toList());
        findAunt(possibleSues);
    }

    class AuntSueB extends AuntSue {

        public AuntSueB(String instruction) {
            super(instruction);
        }

        @Override
        boolean isValidAunt(String key, Integer value) {
            if (!properties.containsKey(key)) {
                return true;
            }

            if (key.equals("trees") || key.equals("cats")) {
                return properties.get(key) > value;
            }

            if (key.equals("pomeranians") || key.equals("goldfish")) {
                return properties.get(key) < value;
            }

            return properties.get(key).equals(value);
        }
    }
}

