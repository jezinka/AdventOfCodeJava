package aoc.days.aoc_2023;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day03b extends Day03a {


    public Day03b() {
        super();
    }

    public Day03b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        Map<Point, Set<Integer>> star = new HashMap<>();
        List<String> input = getInput();

        for (int x = 0; x < input.size(); x++) {
            String line = input.get(x).trim();
            List<String> number = new ArrayList<>();
            List<Point> numberPosition = new ArrayList<>();
            for (int y = 0; y < line.split("").length; y++) {
                String c = line.substring(y, y + 1);
                if (StringUtils.isNumeric(c)) {
                    number.add(c);
                    numberPosition.add(new Point(x, y));
                } else {
                    if (c.equals("*")) {
                        if (!star.containsKey(new Point(x, y))) {
                            star.put(new Point(x, y), new HashSet<>());
                        }
                    }
                    if (!number.isEmpty()) {
                        doBufor(number, numberPosition, star);
                    }
                }
            }
            if (!number.isEmpty()) {
                doBufor(number, numberPosition, star);
            }
        }
        int sum = star.entrySet().stream().filter(e -> e.getValue().size() == 2).toList().stream().map(z -> z.getValue().stream().toList()).mapToInt(zlist -> zlist.get(0) * zlist.get(1)).sum();
        setResult(sum);
    }

    void doBufor(List<String> number, List<Point> numberPosition, Map<Point, Set<Integer>> star) {
        NeighbourhoodRange result = getNeighbourhoodRange(numberPosition);


        int n = Integer.parseInt(StringUtils.join(number, ""));
        for (int i = result.minX(); i <= result.maxX(); i++) {
            for (int j = result.minY(); j <= result.maxY(); j++) {
                int finalI = i;
                int finalJ = j;
                if (numberPosition.stream().noneMatch(p -> p.x == finalI && p.y == finalJ)) {
                    String special = getInput().get(i).substring(j, j + 1);
                    if (special.equals("*")) {
                        if (!star.containsKey(new Point(i, j))) {
                            star.put(new Point(i, j), new HashSet<>(Arrays.asList(n)));
                        } else {
                            star.get(new Point(i, j)).add(n);
                        }
                    }
                }
            }
        }

        number.clear();
        numberPosition.clear();
    }
}
