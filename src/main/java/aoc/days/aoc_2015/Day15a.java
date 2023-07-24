package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day15a extends Day {

    public Day15a() {
        super();
        setResult(0);
    }

    public Day15a(List<String> input) {
        super(input);
        setResult(0);
    }

    @Override
    public void resolve() {
        List<List<Object>> ingredients = prepareInstructions();

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100 - i; j++) {
                for (int k = 0; k <= 100 - i - j; k++) {
                    int l = 100 - i - j - k;

                    int score = getScore(ingredients, i, j, k, l);
                    setResult(Math.max(Integer.parseInt(getResult().toString()), score));
                }
            }
        }
    }

    protected List<List<Object>> prepareInstructions() {
        List<List<Object>> ingredients = new ArrayList<>();
        this.getInput().forEach(line -> {
            Matcher m = Pattern.compile("(\\w+): capacity (-?\\d+), durability (-?\\d+), flavor (-?\\d+), texture (-?\\d+), calories (-?\\d+)").matcher(line);
            if (m.matches()) {
                ingredients.add(List.of(m.group(1), m.group(2), m.group(3), m.group(4), m.group(5), m.group(6)));
            }
        });
        return ingredients;
    }

    protected int getScore(List<List<Object>> ingredients, int i, int j, int k, int l) {
        int capacity = getProperty(ingredients, 1, i, j, k, l);
        int durability = getProperty(ingredients, 2, i, j, k, l);
        int flavor = getProperty(ingredients, 3, i, j, k, l);
        int texture = getProperty(ingredients, 4, i, j, k, l);
        return capacity * durability * flavor * texture;
    }

    protected int getProperty(List<List<Object>> ingredients, int index, int i, int j, int k, int l) {
        List<Integer> properties = ingredients.stream().map(ing -> Integer.parseInt(ing.get(index).toString())).toList();
        if (properties.size() == 4) {
            return Math.max(0, i * properties.get(0) + j * properties.get(1) + k * properties.get(2) + l * properties.get(3));
        }
        return Math.max(0, i * properties.get(0) + j * properties.get(1));
    }
}

