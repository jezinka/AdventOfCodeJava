package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class Day06a extends Day {

    protected static final String TURN_ON = "turn on";
    protected static final String TOGGLE = "toggle";

    private Map<String, Boolean> board = new HashMap<>();

    public Day06a() {
        super();
    }

    public Day06a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        this.getInput().forEach(input -> {
            List<Integer> coordinates = getCoordinates(input);
            int xStart = Math.min(coordinates.get(0), coordinates.get(2));
            int xEnd = Math.max(coordinates.get(0), coordinates.get(2));
            int yStart = Math.min(coordinates.get(1), coordinates.get(3));
            int yEnd = Math.max(coordinates.get(1), coordinates.get(3));

            for (int x = xStart; x <= xEnd; x++) {
                for (int y = yStart; y <= yEnd; y++) {
                    String light = "%d,%d".formatted(x, y);
                    updateBoard(light, input);
                }
            }
        });

        this.setResult(getCount());
    }

    protected void updateBoard(String light, String input) {
        boolean value;
        if (input.startsWith(TOGGLE)) {
            value = !this.board.getOrDefault(light, false);
        } else {
            value = input.startsWith(TURN_ON);
        }
        this.board.put(light, value);
    }

    protected long getCount() {
        return this.board.values().stream().filter(v -> v.equals(Boolean.TRUE)).count();
    }

    private List<Integer> getCoordinates(String input) {
        var matcher = Pattern.compile("\\d+").matcher(input);

        List<Integer> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(Integer.parseInt(matcher.group()));
        }
        return integerList;
    }
}
