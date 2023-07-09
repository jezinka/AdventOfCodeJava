package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class Day06a extends Day {

    private static final String TURN_ON = "turn on";
    private static final String TURN_OFF = "turn off";
    private static final String TOGGLE = "toggle";

    Map<String, Boolean> board;

    public Day06a() {
        super("6.txt");
    }

    public Day06a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        this.board = new HashMap<>();

        this.getInput().forEach(input -> {
            List<Integer> coordinates = getCoordinates(input);
            int xStart = Math.min(coordinates.get(0), coordinates.get(2));
            int xEnd = Math.max(coordinates.get(0), coordinates.get(2));
            int yStart = Math.min(coordinates.get(1), coordinates.get(3));
            int yEnd = Math.max(coordinates.get(1), coordinates.get(3));

            if (input.startsWith(TURN_ON)) {
                turnOn(xStart, xEnd, yStart, yEnd);
            } else if (input.startsWith(TURN_OFF)) {
                turnOff(xStart, xEnd, yStart, yEnd);
            } else if (input.startsWith(TOGGLE)) {
                toggle(xStart, xEnd, yStart, yEnd);
            }
        });

        this.setResult(this.board.values().stream().filter(v -> v.equals(Boolean.TRUE)).count());
    }

    private void turnOff(int xStart, int xEnd, int yStart, int yEnd) {
        for (int x = xStart; x <= xEnd; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                String light = "%d,%d".formatted(x, y);
                this.board.put(light, false);
            }
        }
    }

    private void turnOn(int xStart, int xEnd, int yStart, int yEnd) {
        for (int x = xStart; x <= xEnd; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                String light = "%d,%d".formatted(x, y);
                this.board.put(light, true);
            }
        }
    }

    private void toggle(int xStart, int xEnd, int yStart, int yEnd) {
        for (int x = xStart; x <= xEnd; x++) {
            for (int y = yStart; y <= yEnd; y++) {
                String light = "%d,%d".formatted(x, y);
                this.board.put(light, !this.board.getOrDefault(light, false));
            }
        }
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
