package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.Arrays;
import java.util.List;


public class Day11a extends Day {

    public Day11a() {
        super();
    }

    public Day11a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        String password = this.getInput().get(0);
        do {
            password = increment(password);
        }
        while (!(ruleTwo(password) && ruleOne(password) && ruleThree(password)));

        this.setResult(password);
    }

    private String increment(String password) {
        int index = password.length() - 1;
        String[] letters = password.split("");

        String character = letters[index];
        if (!character.equals("z")) {
            letters[index] = String.valueOf((char) (character.toCharArray()[0] + 1));
        } else {
            while (letters[index - 1].equals("z")) {
                index--;
            }
            letters[index - 1] = String.valueOf((char) (letters[index - 1].toCharArray()[0] + 1));
            while (index < letters.length) {
                letters[index] = "a";
                index++;
            }
        }
        return String.join("", letters);
    }

    public static boolean ruleOne(String password) {
        for (int i = 0; i < password.length() - 2; i++) {
            String window = password.substring(i, i + 3);
            var chars = Arrays.stream(window.split("")).map(c -> (int) c.toCharArray()[0]).toList();
            if (chars.get(0) - chars.get(1) == -1 && chars.get(1) - chars.get(2) == -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean ruleTwo(String password) {
        return Arrays.stream(password.split("")).noneMatch(c -> c.equals("l") || c.equals("i") || c.equals("o"));
    }

    public static boolean ruleThree(String password) {
        boolean firstPair = false;
        boolean secondPair = false;
        for (int i = 0; i < password.length() - 1; i++) {
            String window = password.substring(i, i + 2);
            var chars = window.split("");
            if (chars[0].equals(chars[1])) {
                if (!firstPair) {
                    firstPair = true;
                    i++;
                } else {
                    secondPair = true;
                    break;
                }
            }
        }
        return secondPair;
    }
}

