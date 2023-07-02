package aoc.days.aoc_2015;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Day03a extends Day {

    public Day03a() {
        super("3.txt");
    }

    public Day03a(List<String> input) {
        super(input);
    }

    @Override
    public String getName() {
        return "2015-03a";
    }

    @Override
    public void resolve() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));

        List<String> directions = this.getInputLineSplitBySingleCharacters();
        directions.forEach(direction -> {
            Point lastPoint = XyUtils.movePoint(points.get(points.size() - 1), direction);
            points.add(lastPoint);
        });

        this.setResult(Set.copyOf(points).size());
    }

}
