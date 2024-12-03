package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03b extends Day {

    public Day03b() {
        super();
    }

    public Day03b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        long result = 0;

        boolean omit = false;

        Pattern compile = Pattern.compile("(mul\\((\\d{1,3}),(\\d{1,3})\\)|do\\(\\)|don't\\(\\))");
        for (String s : getInput()) {
            Matcher matcher = compile.matcher(s);
            while (matcher.find()) {
                if (matcher.group().startsWith("mul") && !omit) {
                    result += Long.parseLong(matcher.group(2)) * Long.parseLong(matcher.group(3));
                } else if (matcher.group().equals("don't()")) {
                    omit = true;
                } else if (matcher.group().equals("do()")) {
                    omit = false;
                }
            }
        }

        setResult(result);
    }
}
