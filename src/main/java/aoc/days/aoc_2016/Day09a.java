package aoc.days.aoc_2016;

import aoc.days.Day;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day09a extends Day {

    public Day09a() {
        super();
    }

    public Day09a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Pattern compile = Pattern.compile("\\((\\d+x\\d+)\\)");
        StringBuilder decompressed = new StringBuilder();
        String line = getInput().get(0).trim();

        while (line.length() > 0) {
            line = decompress(compile, decompressed, line);
        }

        setResult(decompressed.length());
    }

    String decompress(Pattern compile, StringBuilder decompressed, String line) {

        if (!line.startsWith("(")) {
            int startBracket = line.indexOf("(");
            if (startBracket == -1) {
                decompressed.append(line);
                line = "";
            } else {
                decompressed.append(line, 0, startBracket);
                line = line.substring(startBracket);
            }
        } else {
            Matcher matcher = compile.matcher(line);
            if (matcher.find()) {
                String marker = matcher.group(1);
                List<Integer> a = Arrays.stream(marker.split("x")).map(Integer::parseInt).toList();
                int endMarker = line.indexOf(")") + 1;
                String repeated = line.substring(endMarker, endMarker + a.get(0));
                decompressed.append(repeated.repeat(Math.max(0, a.get(1))));
                line = line.substring(endMarker + a.get(0));
            }
        }
        return line;
    }
}
