package aoc.days.aoc_2015;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class Day17b extends Day17a {

    private Integer eggnog;

    public Day17b() {
        super();
    }

    public Day17b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Container> containers = getInput().stream().map(Integer::parseInt).sorted(Comparator.reverseOrder()).map(Container::new).toList();
        Set<String> possibleCombinations = ConcurrentHashMap.newKeySet();

        makeCombinations(new ArrayList<>(), containers, possibleCombinations);
        int minContainers = Collections.min(possibleCombinations.stream().map(comb -> comb.split("#").length).toList());
        setResult(possibleCombinations.stream().filter(comb -> comb.split("#").length == minContainers).count());
    }

    public Integer getEggnog() {
        return eggnog;
    }

    public void setEggnog(Integer eggnog) {
        this.eggnog = eggnog;
    }
}

