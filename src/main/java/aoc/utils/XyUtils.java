package aoc.utils;

import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class XyUtils {

    public static final String ON = "#";
    public static final String OFF = " ";

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
        System.out.println(boardDisplay(board));
    }

    public static String boardDisplay(String[][] board) {
        return "\n" + Arrays.stream(board).map(line -> StringUtils.join(line, "")).collect(Collectors.joining("\n"));
    }

    public static void copyArray(String[][] source, String[][] dest) {
        for (int i = 0; i < dest.length; i++) {
            System.arraycopy(source[i], 0, dest[i], 0, dest[i].length);
        }
    }

    public static long getLit(String[][] board) {
        return Arrays.stream(board).mapToLong(strings -> Arrays.stream(strings).filter(string -> string.equals(ON)).count()).sum();
    }
}
