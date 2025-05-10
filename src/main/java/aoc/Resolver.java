package aoc;

import aoc.days.AdventDay;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Resolver {
    public static void main(String[] args) {
        String dayName = args.length > 0 ? args[0] : "";
        List<AdventDay> days = findDays(dayName);
        days.parallelStream()
                .map(Resolver::resolveAndFormatDay)
                .sorted()
                .forEachOrdered(System.out::println);
    }

    private static List<AdventDay> findDays(String dayName) {
        return new Reflections("aoc.days").getSubTypesOf(AdventDay.class).stream()
                .filter(clazz -> !clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers()))
                .map(Resolver::instantiate)
                .filter(day -> day != null && (StringUtils.isBlank(dayName) || day.getName().startsWith(dayName)))
                .sorted(Comparator.comparing(AdventDay::getName))
                .collect(Collectors.toList());
    }

    private static AdventDay instantiate(Class<? extends AdventDay> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            return null;
        }
    }

    private static String resolveAndFormatDay(AdventDay day) {
        long startTime = System.currentTimeMillis();
        day.resolve();
        long endTime = System.currentTimeMillis();
        return String.format("%s -> %-20s(%d ms)", day.getName(), day.getResult(), endTime - startTime);
    }
}