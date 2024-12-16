package aoc.days.aoc_2024;

import aoc.days.Day;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Day14a extends Day {

    private int MAX_TIME = 100;
    private final int spaceHeight;
    private final int spaceWidth;

    public Day14a() {
        super();
        spaceHeight = 103;
        spaceWidth = 101;
    }

    public Day14a(List<String> input, int maxTime) {
        super(input);
        spaceWidth = 11;
        spaceHeight = 7;
        MAX_TIME = maxTime;
    }

    public Day14a(List<String> input) {
        super(input);
        spaceWidth = 11;
        spaceHeight = 7;
    }

    @Override
    public void resolve() {
        List<Robot> robots = prepareRobotList();

        for (int i = 0; i < MAX_TIME; i++) {
            robots.forEach(Robot::move);
        }

        long res = 1;
        res *= countRobotsInQ(robots, 0, (spaceHeight / 2) - 1, 0, (spaceWidth / 2) - 1);
        res *= countRobotsInQ(robots, (spaceHeight / 2) + 1, spaceHeight, 0, (spaceWidth / 2) - 1);
        res *= countRobotsInQ(robots, 0, (spaceHeight / 2) - 1, (spaceWidth / 2) + 1, spaceWidth);
        res *= countRobotsInQ(robots, (spaceHeight / 2) + 1, spaceHeight, (spaceWidth / 2) + 1, spaceWidth);
        setResult(res);
    }

    List<Robot> prepareRobotList() {
        List<Robot> robots = new ArrayList<>();
        Pattern pattern = Pattern.compile("p=(\\d+),(\\d+) v=(-?\\d+),(-?\\d+)");
        getInput().forEach(line -> {
            var matcher = pattern.matcher(line);
            if (matcher.matches()) {
                Point startingPosition = new Point(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1)));
                robots.add(new Robot(startingPosition, matcher.group(4), matcher.group(3)));
            }
        });
        return robots;
    }


    private long countRobotsInQ(List<Robot> robots, int i0, int i1, int j0, int j1) {
        return robots.stream()
                .filter(r -> r.position.x >= i0 && r.position.x <= i1
                             && r.position.y >= j0 && r.position.y <= j1)
                .count();

    }

    void printRobots(List<Robot> robots) {
        printRobots(robots, spaceHeight, spaceWidth);
    }

    private void printRobots(List<Robot> robots, int height, int width) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int finalI = i;
                int finalJ = j;
                long count = robots.stream().filter(r -> r.position.x == finalI && r.position.y == finalJ).count();
                if (count != 0) {
                    System.out.print(count);
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    class Robot {
        Point position;
        Integer velocityX;
        Integer velocityY;

        public Robot(Point position, String velocityX, String velocityY) {
            this.position = position;
            this.velocityX = Integer.parseInt(velocityX);
            this.velocityY = Integer.parseInt(velocityY);
        }

        public void move() {
            int x = this.position.x + this.velocityX;
            if (x >= spaceHeight) {
                x -= spaceHeight;
            }
            if (x < 0) {
                x += spaceHeight;
            }
            int y = this.position.y + this.velocityY;
            if (y >= spaceWidth) {
                y -= spaceWidth;
            }
            if (y < 0) {
                y += spaceWidth;
            }
            this.position = new Point(x, y);
        }
    }
}
