package aoc;

import aoc.days.Day;
import aoc.days.aoc_2015.Day01a;
import aoc.days.aoc_2015.Day01b;
import aoc.days.aoc_2015.Day02a;
import aoc.days.aoc_2015.Day02b;

import java.util.ArrayList;
import java.util.List;

public class Resolver {

    public static void main(String[] args) {
        List<Day> days = new ArrayList<>();
        if (args.length == 0) {
            days.add(new Day01a());
            days.add(new Day01b());
            days.add(new Day02a());
            days.add(new Day02b());
        } else {
            String dayArg = args[0];
            days.add(getDay(dayArg));
        }
        days.forEach(day ->
                {
                    day.resolve();
                    System.out.println(day.getName() + " -> " + day.getResult());
                }
        );
    }

    private static Day getDay(String input) {
        switch (input) {
            case "2015-01a":
                return new Day01a();
            case "2015-01b":
                return new Day01b();
            case "2015-02a":
                return new Day02a();
            case "2015-02b":
                return new Day02b();
        }
        throw new UnsupportedOperationException();
    }
}

