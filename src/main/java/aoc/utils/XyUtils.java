package aoc.utils;

import java.awt.*;
import java.util.List;
import java.util.stream.IntStream;

public class XyUtils {
    public static Point movePoint(Point inputPoint, String direction) {
        Point lastPoint = new Point(inputPoint.x, inputPoint.y);
        switch (direction) {
            case "^" -> lastPoint.x++;
            case "v" -> lastPoint.x--;
            case "<" -> lastPoint.y--;
            case ">" -> lastPoint.y++;
        }
        return lastPoint;
    }

    public static String[][] prepareBoard(List<String> input) {
        String[][] resultArray = new String[input.size()][];

        for (int i = 0; i < input.size(); i++) {
            String str = input.get(i);
            resultArray[i] = IntStream
                    .range(0, str.length())
                    .mapToObj(j -> String.valueOf(str.charAt(j)))
                    .toArray(String[]::new);
        }

        return resultArray;

    }

    public static void printBoard(String[][] board) {
        for (String[] row : board) {
            StringBuilder output = new StringBuilder();
            for (String cell : row) {
                output.append(cell);
            }
            System.out.println(output);
        }
        System.out.println();
    }
}
