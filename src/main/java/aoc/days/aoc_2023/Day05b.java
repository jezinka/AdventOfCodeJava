package aoc.days.aoc_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Day05b extends Day05a {

    public Day05b() {
        super();
    }

    public Day05b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        String line = getInput().get(0);
        MappingMap mappingMap = getMappingMap();

        List<Mapping> seedRanges = new ArrayList<>();

        List<Long> seedList = splitParseGetIntList(line.substring(line.indexOf(":") + 2)).stream().toList();

        for (int i = 0; i <= seedList.size() - 2; i += 2) {
            Long start = seedList.get(i);
            Long range = seedList.get(i + 1);

            seedRanges.add(new Mapping(start, null, range));
        }

        Long minLocation = 0L;

        boolean seedInRange = false;
        while (!seedInRange) {
            Long seed = doMappingTillTheStart(minLocation, mappingMap);
            seedInRange = seedRanges.stream().anyMatch(range -> range.isInStartRange(seed));
            if (!seedInRange) {
                minLocation++;
            }
        }
        setResult(minLocation);
    }

    Long doMappingTillTheStart(Long location, MappingMap mappingMap) {

        Long humidity = mapped(mappingMap.humidityToLocation(), location);
        Long temperature = mapped(mappingMap.temperatureToHumidity(), humidity);
        Long light = mapped(mappingMap.lightToTemperature(), temperature);
        Long water = mapped(mappingMap.waterToLight(), light);
        Long fertilizer = mapped(mappingMap.fertilizerToWater(), water);
        Long soil = mapped(mappingMap.soilToFertilizer(), fertilizer);
        Long seed = mapped(mappingMap.seedToSoil(), soil);

//        System.out.println("seed = " + seed +
//                "; soil = " + soil +
//                "; fertilizer = " + fertilizer +
//                "; water = " + water +
//                "; light = " + light +
//                "; temperature = " + temperature +
//                "; humidity = " + humidity +
//                "; location = " + location);
        return seed;
    }

    private static Long mapped(List<Mapping> mappings, Long item) {
        Optional<Mapping> mapping = mappings
                .stream()
                .filter(m -> m.isInDestinationRange(item))
                .findFirst();
        return mapping.map(m -> item - (m.destinationStart - m.sourceStart)).orElse(item);
    }
}
