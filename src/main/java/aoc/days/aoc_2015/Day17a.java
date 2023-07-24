package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


public class Day17a extends Day {

    private Integer eggnog;

    public Day17a() {
        super();
        setEggnog(150);
    }

    public Day17a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        List<Container> containers = getInput().stream().map(Integer::parseInt).sorted(Comparator.reverseOrder()).map(Container::new).toList();
        Set<String> possibleCombinations = ConcurrentHashMap.newKeySet();

        makeCombinations(new ArrayList<>(), containers, possibleCombinations);

        setResult(possibleCombinations.size());
    }

    protected void makeCombinations(List<Container> currentCombination, List<Container> containers, Set<String> possibleCombinations) {
        Integer containersVolume = currentCombination.stream().map(Container::getVolume).reduce(0, Integer::sum);

        if (containersVolume.equals(getEggnog())) {
            possibleCombinations.add(currentCombination.stream().map(Container::getId).sorted().collect(Collectors.joining("#")));
            return;
        }

        if (containersVolume > getEggnog()) {
            return;
        }

        containers.parallelStream().forEach(container -> {
            List<Container> combinations = new ArrayList<>(currentCombination);
            combinations.add(container);
            List<Container> leftovers = containers.stream().filter(c -> !c.equals(container)).collect(Collectors.toList());
            makeCombinations(combinations, leftovers, possibleCombinations);
        });
    }

    public Integer getEggnog() {
        return eggnog;
    }

    public void setEggnog(Integer eggnog) {
        this.eggnog = eggnog;
    }

    class Container {
        UUID id;
        int volume;

        public Container(int volume) {
            this.id = UUID.randomUUID();
            this.volume = volume;
        }

        public int getVolume() {
            return volume;
        }

        public String getId() {
            return id.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Container container = (Container) o;
            return id.equals(container.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }
}

