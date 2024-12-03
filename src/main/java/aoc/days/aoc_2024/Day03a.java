package aoc.days.aoc_2024;

import aoc.days.Day;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03a extends Day {

    public Day03a() {
        super();
    }

    public Day03a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        long result = 0;

        Pattern compile = Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        for (String s : getInput()) {
            Matcher matcher = compile.matcher(s);
            while (matcher.find()) {
                result += Long.parseLong(matcher.group(1)) * Long.parseLong(matcher.group(2));
            }
        }

        setResult(result);
    }
}
