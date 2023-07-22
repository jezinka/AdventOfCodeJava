package aoc.days.aoc_2015;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Day14b extends Day14a {

    private Integer time;
    private Map<String, Integer> results = new HashMap<>();

    public Day14b() {
        super();
    }

    public Day14b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        Map<String, Integer> leads = new HashMap<>();

        List<List> instructions = prepareInstructions();
        for (List ins : instructions) {
            leads.put(ins.get(0).toString(), 0);
        }

        for (int i = 1; i <= time; i++) {
            getForSecond(i, instructions);
            Integer max = Collections.max(results.values());
            results.forEach((k, v) -> {
                if (v.equals(max)) {
                    leads.put(k, leads.get(k) + 1);
                }
            });
        }

        this.setResult(Collections.max(leads.values()));
    }

    @Override
    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public Integer getTime() {
        return time;
    }

    @Override
    public Map<String, Integer> getResults() {
        return results;
    }

    @Override
    public void setResults(Map<String, Integer> results) {
        this.results = results;
    }
}

