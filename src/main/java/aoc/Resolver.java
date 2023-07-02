package aoc;

import aoc.days.Day;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
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

        List<Day> days = getDaysByReflection(dayName);

        days.forEach(day ->
                {
                    day.resolve();
                    System.out.println(day.getName() + " -> " + day.getResult());
                }
        );
    }

    private static List<Day> getDaysByReflection(String dayName) {
        List<Day> days = new ArrayList<>();
        Reflections reflections = new Reflections("aoc.days");
        Set<Class<? extends Day>> classes = reflections.getSubTypesOf(Day.class);
        classes.forEach(clazz -> {
            try {
                Day day = clazz.getDeclaredConstructor().newInstance();
                if (dayName.isBlank() || dayName.isEmpty() || day.getName().equals(dayName)) {
                    days.add(day);
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        });
        return days.stream().sorted(Comparator.comparing(Day::getName)).toList();
    }
}

