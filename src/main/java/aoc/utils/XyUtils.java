package aoc.utils;

import java.awt.*;

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
}
