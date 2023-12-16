package aoc.days.aoc_2023;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day12a extends Day {

    public Day12a() {
        super();
    }

    public Day12a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        int result = 0;
        for (String line : getInput()) {
            result = getResult(line, result);
        }
        setResult(result);
    }

    int getResult(String line, int result) {
        var parts = line.split(" ");
        var onsens = parts[0].replaceAll("\\.{2,}", ".");

        List<String> possibilities = new ArrayList<>();
        if (!onsens.startsWith("?")) {
            possibilities.add(onsens.substring(0, onsens.indexOf("?")));
            onsens = onsens.substring(onsens.indexOf("?"));
        } else {
            possibilities.add("");
        }

        while (!onsens.isEmpty()) {
            Set<String> temp = new HashSet<>();
            if (onsens.contains("?")) {
                if (onsens.startsWith("?")) {
                    for (String possibility : possibilities) {

                        String withKropka = possibility + ".";
                        if (sensJeszczeToDodac(withKropka, parts[1])) {
                            temp.add(withKropka);
                        }

                        String withHash = possibility + "#";
                        if (sensJeszczeToDodac(withHash, parts[1])) {
                            temp.add(withHash);
                        }
                    }
                    onsens = onsens.substring(1);
                } else {
                    String without = onsens.substring(0, onsens.indexOf("?"));
                    for (String possibility : possibilities) {
                        String newPossibility = possibility + without;
                        if (sensJeszczeToDodac(newPossibility, parts[1])) {
                            temp.add(newPossibility);
                        }
                    }
                    onsens = onsens.substring(onsens.indexOf("?"));
                }
            } else {
                for (String possibility : possibilities) {
                    String newPossibility = possibility + onsens;
                    if (sensJeszczeToDodac(newPossibility, parts[1])) {
                        temp.add(newPossibility);
                    }
                }
                onsens = "";
            }

            possibilities = new ArrayList<>(temp);
        }

        AtomicInteger count = new AtomicInteger();
        possibilities.forEach(p ->

                {
                    if (partsToLengthsString(p).equals(parts[1])) {
                        count.getAndIncrement();
                    }
                }
        );
//        System.out.println(line + ": " + count.get());
//        System.out.println();
        result += count.get();
        return result;
    }

    private boolean sensJeszczeToDodac(String newPossibility, String controlOnsens) {
        if (!newPossibility.contains("#") || newPossibility.endsWith("#")) {
            return true;
        }

        String prefix = partsToLengthsString(newPossibility);
//        if (!controlOnsens.startsWith(prefix)) {
//            System.out.println(prefix + " -> " + controlOnsens + " -> buu");
//        }
        return controlOnsens.startsWith(prefix);
    }

    private String partsToLengthsString(String p) {
        return getList(p).stream().map(Object::toString).collect(Collectors.joining(","));
    }

    private static List<Integer> getList(String p) {
        return Arrays.stream(p.replaceAll("\\.{2,}", ".").split("\\.")).filter(r -> !r.isEmpty()).map(String::length).toList();
    }
}