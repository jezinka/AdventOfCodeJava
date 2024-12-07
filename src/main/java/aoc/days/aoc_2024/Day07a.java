package aoc.days.aoc_2024;

import aoc.days.Day;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day07a extends Day {

    public Day07a() {
        super();
    }

    public Day07a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        long validRes = 0;
        for (String s : getInput()) {
            String[] split = s.split(":");
            var res = Long.parseLong(split[0]);
            var numbers = Arrays.stream(split[1].split(" ")).filter(StringUtils::isNumeric).map(Long::parseLong).toList();

            List<String> permutations = getPossibleOperators();
            while (permutations.get(0).length() < numbers.size() - 1) {
                List<String> copy = new ArrayList<>();
                for (var p : permutations) {
                    for (var op : getPossibleOperators()) {
                        copy.add(p + op);
                    }
                }
                permutations = copy;
            }

            for (var p : permutations) {
                var copyNumbers = new ArrayList<>(numbers);
                var rezult = copyNumbers.remove(0);
                for (var op : p.split("")) {
                    switch (op) {
                        case "+" -> rezult += copyNumbers.remove(0);
                        case "*" -> rezult *= copyNumbers.remove(0);
                        case "." -> rezult = Long.parseLong(rezult.toString() + copyNumbers.remove(0).toString());
                    }
                }
                if (rezult == res) {
                    validRes += rezult;
                    break;
                }
            }
        }
        setResult(validRes);
    }

    List<String> getPossibleOperators() {
        return List.of("+", "*");
    }

}
