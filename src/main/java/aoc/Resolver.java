package aoc;

import aoc.days.AdventDay;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Resolver {
    public static void main(String[] args) {
        var dayName = args.length != 0 ? args[0] : "";
        List<AdventDay> days = getDaysByReflection(dayName);
        executeDays(days);
    }

    private static List<AdventDay> getDaysByReflection(String dayName) {
        List<AdventDay> days = new ArrayList<>();
        Set<Class<? extends AdventDay>> classes = getAdventDayClasses();

        classes.stream()
                .filter(clazz -> !Modifier.isAbstract(clazz.getModifiers()))
                .map(Resolver::instantiateAdventDay)
                .filter(Objects::nonNull)
                .filter(day -> StringUtils.isBlank(dayName) || day.getName().startsWith(dayName))
                .sorted(Comparator.comparing(AdventDay::getName))
                .forEach(days::add);

        return days;
    }

    private static Set<Class<? extends AdventDay>> getAdventDayClasses() {
        Reflections reflections = new Reflections("aoc.days");
        return reflections.getSubTypesOf(AdventDay.class);
    }

    private static AdventDay instantiateAdventDay(Class<? extends AdventDay> clazz) {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void executeDays(List<AdventDay> days) {
        List<String> results = days.parallelStream()
                .map(Resolver::resolveAndFormatDay)
                .toList();
        results.stream().sorted(String::compareTo).forEach(System.out::println);
    }

    private static String resolveAndFormatDay(AdventDay day) {
        var startTime = System.currentTimeMillis();
        day.resolve();
        var endTime = System.currentTimeMillis();
        return formatDayResult(day, startTime, endTime);
    }

    private static String formatDayResult(AdventDay day, long startTime, long endTime) {
        return day.getName() + " -> " + StringUtils.rightPad(day.getResult().toString(), 20) + "(" + (endTime - startTime) + " ms)";
    }
}

