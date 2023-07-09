package aoc.days.aoc_2015;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day06b extends Day06a {

    private Map<String, Integer> board = new HashMap<>();

    public Day06b() {
        super();
    }

    public Day06b(List<String> input) {
        super(input);
    }

    @Override
    protected long getCount() {
        return this.board.values().stream().reduce(0, Integer::sum);
    }

    @Override
    protected void updateBoard(String light, String input) {
        int value;
        if (input.startsWith(TOGGLE)) {
            value = this.board.getOrDefault(light, 0) + 2;
        } else if (input.startsWith(TURN_ON)) {
            value = this.board.getOrDefault(light, 0) + 1;
        } else {
            value = Math.max(0, this.board.getOrDefault(light, 0) - 1);
        }
        board.put(light, value);
    }
}
