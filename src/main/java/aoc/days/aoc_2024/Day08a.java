package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.awt.*;
import java.util.List;
import java.util.*;

public class Day08a extends Day {

    public Day08a() {
        super();
    }

    public Day08a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {

        String[][] board = XyUtils.prepareBoard(getInput());
        HashMap<String, List<Point>> antennas = antennasXY(board);
        Set<Point> antinodes = getAntinodes(antennas, board);

        setResult(antinodes.size());
    }

    private Set<Point> getAntinodes(HashMap<String, List<Point>> antennas, String[][] board) {
        Set<Point> antinodes = new HashSet<>();

        for (Map.Entry<String, List<Point>> antenna : antennas.entrySet()) {
            Set<List<Point>> pairs = preparePairs(antenna);

            for (List<Point> pair : pairs) {
                List<Point> possibles = preparePossibles(pair);
                antinodes.addAll(possibles);
            }
        }
        return antinodes;
    }

    List<Point> preparePossibles(List<Point> pair) {
        int xLength = Math.abs(pair.get(0).x - pair.get(1).x);
        int yLength = Math.abs(pair.get(0).y - pair.get(1).y);

        List<Point> possibles = new ArrayList<>();
        for (int i = 0; i < getInput().size(); i++) {
            for (int j = 0; j < getInput().get(0).length(); j++) {
                if (((j - pair.get(0).y) * (pair.get(1).x - pair.get(0).x)) - ((pair.get(1).y - pair.get(0).y) * (i - pair.get(0).x)) == 0) {
                    if (isValidPoint(pair, i, j, xLength, yLength)) {
                        possibles.add(new Point(i, j));
                    }
                }
            }
        }
        return possibles;
    }

    boolean isValidPoint(List<Point> pair, int i, int j, int xLength, int yLength) {
        return (i != pair.get(0).x || j != pair.get(0).y) && (i != pair.get(1).x || j != pair.get(1).y)
               && ((Math.abs(i - pair.get(0).x) == xLength && Math.abs(j - pair.get(0).y) == yLength)
                   || (Math.abs(i - pair.get(1).x) == xLength) && (Math.abs(j - pair.get(1).y) == yLength));
    }

    private Set<List<Point>> preparePairs(Map.Entry<String, List<Point>> antenna) {
        Set<List<Point>> pairs = new HashSet<>();

        List<Point> value = antenna.getValue();
        for (int i = 0; i < value.size() - 1; i++) {
            for (int j = i + 1; j < value.size(); j++) {
                pairs.add(List.of(value.get(i), value.get(j)));
            }
        }
        return pairs;
    }

    private HashMap<String, List<Point>> antennasXY(String[][] board) {
        HashMap<String, List<Point>> antennas = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].equals(".")) {
                    if (!antennas.containsKey(board[i][j])) {
                        antennas.put(board[i][j], new ArrayList<>());
                    }
                    antennas.get(board[i][j]).add(new Point(i, j));
                }
            }
        }
        return antennas;
    }

    private void printBoardWithAntinodes(String[][] board, Set<Point> antinodes) {
        for (int i = 0; i < board.length; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < board[i].length; j++) {
                int finalI = i;
                int finalJ = j;
                if (antinodes.stream().anyMatch(a -> a.x == finalI && a.y == finalJ)) {
                    row.append("#");
                } else {
                    row.append(board[i][j]);
                }
            }
            System.out.println(row);
        }
    }
}
