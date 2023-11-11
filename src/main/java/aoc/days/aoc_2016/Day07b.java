package aoc.days.aoc_2016;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Day07b extends Day07a {

    public Day07b() {
        super();
    }

    public Day07b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<String> ipv7SSLAddressees = new ArrayList<>();

        for (String line : getInput()) {

            List<String> bracketMatches = getHyperNetChunks(line);
            List<String> matches = getSuperNetChunks(line, bracketMatches);

            List<String> abas = getABAs(matches);
            if (hasBAB(bracketMatches, abas)) {
                ipv7SSLAddressees.add(line);
            }
        }

        setResult(ipv7SSLAddressees.size());
    }

    private List<String> getABAs(List<String> matches) {
        List<String> aba = new ArrayList<>();
        for (String match : matches) {
            int windowSize = 3;
            for (int i = 0; i <= match.length() - windowSize; i++) {
                String[] window = match.substring(i, i + windowSize).split("");
                if (window[0].equals(window[2]) && !window[0].equals(window[1])) {
                    aba.add(StringUtils.join(window));
                }
            }
        }
        return aba;
    }

    private boolean hasBAB(List<String> matches, List<String> abas) {
        for (String match : matches) {
            for (String aba : abas) {
                String a = aba.substring(0, 1);
                String b = aba.substring(1, 2);
                for (int i = 0; i <= match.length() - 3; i++) {
                    String[] window = match.substring(i, i + 3).split("");
                    if (window[0].equals(b) && window[1].equals(a) && window[2].equals(b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
