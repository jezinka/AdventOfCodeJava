package aoc.days.aoc_2016;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Day07a extends Day {

    public Day07a() {
        super();
    }

    public Day07a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<String> ipv7TLSAddressees = new ArrayList<>();

        for (String line : getInput()) {
            boolean ipv7ABBA = false;

            List<String> bracketMatches = getHyperNetChunks(line);

            boolean ipv7ABBABrackets = isABBA(bracketMatches);

            if (!ipv7ABBABrackets) {
                List<String> matches = getSuperNetChunks(line, bracketMatches);

                ipv7ABBA = isABBA(matches);
            }

            if (!ipv7ABBABrackets && ipv7ABBA) {
                ipv7TLSAddressees.add(line);
            }
        }

        setResult(ipv7TLSAddressees.size());
    }

    protected static List<String> getHyperNetChunks(String line) {
        return Pattern.compile("(\\[\\w+\\])")
                .matcher(line)
                .results()
                .map(MatchResult::group)
                .map(m -> m.replace("[", "").replace("]", ""))
                .toList();
    }

    protected static List<String> getSuperNetChunks(String line, List<String> bracketMatches) {
        return Pattern.compile("(\\w+)")
                .matcher(line)
                .results()
                .map(MatchResult::group)
                .filter(m -> !bracketMatches.contains(m)).toList();
    }

    private boolean isABBA(List<String> matches) {
        for (String match : matches) {
            for (int i = 0; i <= match.length() - 4; i++) {
                String[] window = match.substring(i, i + 4).split("");
                if (window[0].equals(window[3]) && window[1].equals(window[2]) && !window[0].equals(window[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}
