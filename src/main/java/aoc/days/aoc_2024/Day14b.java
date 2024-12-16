package aoc.days.aoc_2024;

import java.util.Comparator;
import java.util.List;

public class Day14b extends Day14a {

    public Day14b() {
        super();
    }

    @Override
    public void resolve() {
        List<Day14a.Robot> robots = prepareRobotList();

        int threshold = 20;
        long counter = 0;
        boolean christmasTree = false;

        while (!christmasTree) {
            counter++;
            robots.forEach(Day14a.Robot::move);

            var sortedX = robots.stream().map(r -> r.position).sorted(Comparator.comparingInt(r -> r.x)).toList();
            var inOrder = 0;
            for (int i = 0; i < sortedX.size() - 1; i++) {
                if (sortedX.get(i).x - sortedX.get(i + 1).x == 1 || sortedX.get(i).x - sortedX.get(i + 1).x == 0) {
                    inOrder++;
                } else {
                    inOrder = 0;
                }
                if (inOrder > threshold) {
                    inOrder = 0;
                    var sortedY = robots.stream().map(r -> r.position).sorted(Comparator.comparingInt(r -> r.y)).toList();
                    for (int j = 0; j < sortedY.size() - 1; j++) {
                        if (sortedY.get(j).y - sortedY.get(j + 1).y == 1 || sortedY.get(j).y - sortedY.get(j + 1).y == 0) {
                            inOrder++;
                        } else {
                            inOrder = 0;
                        }
                        if (inOrder > threshold) {
                            christmasTree = true;
                            break;
                        }
                    }
                }
            }
        }
        printRobots(robots);
        setResult(counter);
    }
}
