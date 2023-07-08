package aoc;

import aoc.days.AdventDay;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Resolver {

    public static void main(String[] args) {

        String dayName = "";
        if (args.length != 0) {
            dayName = args[0];
        }

        List<AdventDay> days = getDaysByReflection(dayName);

        days.forEach(day ->
                {
                    day.resolve();
                    System.out.println(day.getName() + " -> " + day.getResult());
                }
        );
    }

    private static List<AdventDay> getDaysByReflection(String dayName) {
        List<AdventDay> days = new ArrayList<>();
        Reflections reflections = new Reflections("aoc.days");
        Set<Class<? extends AdventDay>> classes = reflections.getSubTypesOf(AdventDay.class);
        classes.forEach(clazz -> {
            try {
                if (!Modifier.isAbstract(clazz.getModifiers())) {
                    AdventDay day = clazz.getDeclaredConstructor().newInstance();
                    if (dayName.isBlank() || dayName.isEmpty() || day.getName().equals(dayName)) {
                        days.add(day);
                    }
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
        return days.stream().sorted(Comparator.comparing(AdventDay::getName)).toList();
    }
}

