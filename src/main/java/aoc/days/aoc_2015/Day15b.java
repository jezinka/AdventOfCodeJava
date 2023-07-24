package aoc.days.aoc_2015;

import java.util.List;


public class Day15b extends Day15a {

    public Day15b() {
        super();
    }

    public Day15b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<List<Object>> ingredients = prepareInstructions();

        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100 - i; j++) {
                for (int k = 0; k <= 100 - i - j; k++) {
                    int l = 100 - i - j - k;

                    if (getProperty(ingredients, 5, i, j, k, l) == 500) {
                        int score = getScore(ingredients, i, j, k, l);
                        setResult(Math.max(Integer.parseInt(getResult().toString()), score));
                    }
                }
            }
        }
    }
}

