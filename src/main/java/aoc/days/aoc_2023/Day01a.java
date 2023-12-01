package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day01a extends Day {


    public Day01a() {
        super();
    }

    public Day01a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Integer sum = 0;
        for (String line : getInput()) {
            List<Integer> integerList = new ArrayList<>();
            Matcher matcher = Pattern.compile("\\d").matcher(line);
            while (matcher.find()) {
                integerList.add(Integer.parseInt(matcher.group()));
            }
            int number = 0;
            if (!integerList.isEmpty()) {
                number += integerList.get(0) * 10 + integerList.get(integerList.size() - 1);
            }
            sum += number;
        }
        setResult(sum);
    }
}
