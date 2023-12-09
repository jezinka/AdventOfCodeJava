package aoc.days.aoc_2023;

import aoc.days.Day;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day05a extends Day {

    public Day05a() {
        super();
    }

    public Day05a(List<String> input) {
        super(input);
    }

    private Integer i = 2;

    @Override
    public void resolve() {

        String line = getInput().get(0);
        MappingMap mappingMap = getMappingMap();
        List<Long> seeds = splitParseGetIntList(line.substring(line.indexOf(":") + 2));

        setResult(doMappingTillTheEnd(seeds, mappingMap));
    }

    Long doMappingTillTheEnd(List<Long> seeds, MappingMap mappingMap) {

        final Long[] end = {Long.MAX_VALUE};
        seeds.forEach(s ->
                {
                    Long soil = mapped(mappingMap.seedToSoil(), s);
                    Long fertilizer = mapped(mappingMap.soilToFertilizer(), soil);
                    Long water = mapped(mappingMap.fertilizerToWater(), fertilizer);
                    Long light = mapped(mappingMap.waterToLight(), water);
                    Long temperature = mapped(mappingMap.lightToTemperature(), light);
                    Long humidity = mapped(mappingMap.temperatureToHumidity(), temperature);
                    Long location = mapped(mappingMap.humidityToLocation(), humidity);
                    end[0] = Math.min(location, end[0]);
                }
        );
        return end[0];
    }

    MappingMap getMappingMap() {
        List<Mapping> seedToSoil = prepareOfInput();
        List<Mapping> soilToFertilizer = prepareOfInput();
        List<Mapping> fertilizerToWater = prepareOfInput();
        List<Mapping> waterToLight = prepareOfInput();
        List<Mapping> lightToTemperature = prepareOfInput();
        List<Mapping> temperatureToHumidity = prepareOfInput();
        List<Mapping> humidityToLocation = prepareOfInput();
        return new MappingMap(seedToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation);
    }

    record MappingMap(List<Mapping> seedToSoil, List<Mapping> soilToFertilizer, List<Mapping> fertilizerToWater,
                      List<Mapping> waterToLight, List<Mapping> lightToTemperature,
                      List<Mapping> temperatureToHumidity, List<Mapping> humidityToLocation) {
    }

    private static Long mapped(List<Mapping> mappings, Long item) {
        Optional<Mapping> mapping = mappings
                .stream()
                .filter(m -> m.isInStartRange(item))
                .findFirst();
        return mapping.map(m -> m.destinationStart - m.sourceStart + item).orElse(item);
    }

    private List<Mapping> prepareOfInput() {
        List<Mapping> mappings = new ArrayList<>();

        String mappingLine = getInput().get(++i);
        while (!mappingLine.isEmpty()) {
            if (!StringUtils.isNumeric(mappingLine.substring(0, 1))) {
                mappingLine = getInput().get(++i);
            }
            List<Long> s = splitParseGetIntList(mappingLine);
            mappings.add(new Mapping(s));
            if (i > getInput().size() - 2) {
                break;
            }
            mappingLine = getInput().get(++i);
        }
        return mappings;
    }

    static List<Long> splitParseGetIntList(String l) {
        return Arrays.stream(l.split(" ")).map(Long::parseLong).collect(Collectors.toList());
    }

    static class Mapping {
        Long sourceStart;
        Long destinationStart;
        Long range;

        public Mapping(Long sourceStart, Long destinationStart, Long range) {
            this.sourceStart = sourceStart;
            this.destinationStart = destinationStart;
            this.range = range;
        }

        public Mapping(List<Long> s) {
            this.sourceStart = s.get(1);
            this.destinationStart = s.get(0);
            this.range = s.get(2);
        }

        public boolean isInStartRange(Long s) {
            return sourceStart <= s && s < sourceStart + range;
        }

        public boolean isInDestinationRange(Long s) {
            return destinationStart <= s && s < destinationStart + range;
        }
    }
}
