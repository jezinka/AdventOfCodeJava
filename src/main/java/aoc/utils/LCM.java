package aoc.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LCM {

    public static long lcm(List<Long> numbers) {
        if (numbers.stream().anyMatch(n -> n == 0)) {
            return 0;
        }

        List<Map<Integer, Integer>> primeFactors = numbers
                .stream()
                .map(LCM::getPrimeFactors)
                .toList();

        Set<Integer> primeFactorsUnionSet = primeFactors
                .stream()
                .flatMap(primes -> primes.keySet().stream())
                .collect(Collectors.toSet());

        long lcm = 1;

        for (Integer primeFactor : primeFactorsUnionSet) {
            lcm *= Math.pow(primeFactor, primeFactors
                    .stream()
                    .map(k -> k.getOrDefault(primeFactor, 0))
                    .max(Comparator.naturalOrder())
                    .get());
        }

        return lcm;
    }

    private static Map<Integer, Integer> getPrimeFactors(Long number) {
        long absNumber = Math.abs(number);

        Map<Integer, Integer> primeFactorsMap = new HashMap<>();

        for (int factor = 2; factor <= absNumber; factor++) {
            while (absNumber % factor == 0) {
                Integer power = primeFactorsMap.get(factor);
                if (power == null) {
                    power = 0;
                }
                primeFactorsMap.put(factor, power + 1);
                absNumber /= factor;
            }
        }

        return primeFactorsMap;
    }
}
