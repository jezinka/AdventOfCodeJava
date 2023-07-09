package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;


public class Day07a extends Day {

    private static final String AND = "AND";
    private static final String OR = "OR";
    private static final String RSHIFT = "RSHIFT";
    private static final String LSHIFT = "LSHIFT";
    private static final String NOT = "NOT";

    Map<String, Long> board;

    public Day07a() {
        super();
    }

    public Day07a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        this.board = new HashMap<>();

        this.getInput().forEach(input -> {
            String[] list = input.split(" -> ");
            board.put(list[1], null);
        });

        List<String> notProcessedInput = this.getInput();
        while (board.containsValue(null)) {
            List<String> tempInput = new ArrayList<>();

            notProcessedInput.forEach(input -> {
                String[] list = input.split(" -> ");
                String key = list[1];
                String instruction = list[0];
                Long value = null;

                Optional<String> operator = Stream.of(AND, OR, RSHIFT, LSHIFT, NOT).filter(instruction::contains).findFirst();
                if (operator.isPresent()) {
                    String[] instructionInput = instruction.split(operator.get());
                    Long a = getValueOrFromBoard(instructionInput[0]);
                    Long b = getValueOrFromBoard(instructionInput[1]);

                    if (a != null && b != null) {
                        switch (operator.get()) {
                            case AND -> value = a & b;
                            case OR -> value = a | b;
                            case RSHIFT -> value = a >> b;
                            case LSHIFT -> value = a << b;
                        }
                    }

                    if (instruction.contains(NOT) && b != null) {
                        value = ~b & 0xFFFF;
                    }
                } else {
                    value = getValueOrFromBoard(instruction);
                }

                if (value != null) {
                    board.put(key, value);
                } else {
                    tempInput.add(input);
                }
            });
            notProcessedInput.clear();
            notProcessedInput.addAll(tempInput);
        }

        this.setResult(this.board.get("a"));
    }

    private Long getValueOrFromBoard(String input) {
        String value = input.trim();
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException ex) {
            return board.getOrDefault(value, null);
        }
    }

    public Map<String, Long> getBoard() {
        return board;
    }
}
