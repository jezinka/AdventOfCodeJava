package aoc.days.aoc_2023;

import aoc.days.Day;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day01b extends Day {


    public Day01b() {
        super();
    }

    public Day01b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Integer sum = 0;
        for (String line : getInput()) {
            List<Integer> integerList = new ArrayList<>();

            while (!line.isEmpty()) {

                String first = line.substring(0, 1);
                if (StringUtils.isNumeric(first)) {
                    integerList.add(Integer.parseInt(first));
                } else {
                    if (line.startsWith("one")) {
                        integerList.add(1);
                    } else if (line.startsWith("two")) {
                        integerList.add(2);
                    } else if (line.startsWith("three")) {
                        integerList.add(3);
                    } else if (line.startsWith("four")) {
                        integerList.add(4);
                    } else if (line.startsWith("five")) {
                        integerList.add(5);
                    } else if (line.startsWith("six")) {
                        integerList.add(6);
                    } else if (line.startsWith("seven")) {
                        integerList.add(7);
                    } else if (line.startsWith("eight")) {
                        integerList.add(8);
                    } else if (line.startsWith("nine")) {
                        integerList.add(9);
                    }
                }
                line = line.substring(1);
            }

            if (!integerList.isEmpty()) {
                sum += integerList.get(0) * 10 + integerList.get(integerList.size() - 1);
            }
        }

        setResult(sum);
    }
}
