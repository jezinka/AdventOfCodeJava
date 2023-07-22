package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Day14a extends Day {

    private Integer time;
    private Map<String, Integer> results = new HashMap<>();

    public Day14a() {
        super();
        time = 2503;
    }

    public Day14a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<List> instructions = new ArrayList();
        this.getInput().forEach(line -> {
            Matcher matcher = Pattern.compile("(\\w+) can fly (\\d+) km/s for (\\d+) seconds, but then must rest for (\\d+) seconds\\.").matcher(line);
            if (matcher.matches()) {
                instructions.add(List.of(matcher.group(1), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4))));
            }
        });

        instructions.forEach(i -> {
            String reindeerName = i.get(0).toString();
            int speed = (int) i.get(1);
            int movingTime = (int) i.get(2);
            int restTime = (int) i.get(3);

            int sum = 0;
            int fullPeriod = this.getTime() / (movingTime + restTime);
            int residue = this.getTime() % (movingTime + restTime);
            sum += fullPeriod * speed * movingTime;
            if (residue >= movingTime) {
                sum += movingTime * speed;
            } else {
                sum += residue * speed;
            }
            results.put(reindeerName, sum);
        });

        this.setResult(Collections.max(results.values()));
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Map<String, Integer> getResults() {
        return results;
    }

    public void setResults(Map<String, Integer> results) {
        this.results = results;
    }
}

