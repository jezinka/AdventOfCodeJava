package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.util.List;

public class Day04a extends Day {

    public Day04a() {
        super();
    }

    public Day04a(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        String[][] board = XyUtils.prepareBoard(getInput());

        Integer xmas = 0;

        String x = "X";
        String m = "M";
        String a = "A";
        String s = "S";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (!board[i][j].equals(x)) {
                    continue;
                }

                if (i + 3 < board.length && board[i + 1][j].equals(m) && board[i + 2][j].equals(a) && board[i + 3][j].equals(s)) {
                    xmas++;
                }
                if (i - 3 > -1 && board[i - 1][j].equals(m) && board[i - 2][j].equals(a) && board[i - 3][j].equals(s)) {
                    xmas++;
                }
                if (j - 3 > -1 && board[i][j - 1].equals(m) && board[i][j - 2].equals(a) && board[i][j - 3].equals(s)) {
                    xmas++;
                }
                if (j + 3 < board.length && board[i][j + 1].equals(m) && board[i][j + 2].equals(a) && board[i][j + 3].equals(s)) {
                    xmas++;
                }
                if (i + 3 < board.length && j + 3 < board.length && board[i + 1][j + 1].equals(m) && board[i + 2][j + 2].equals(a) && board[i + 3][j + 3].equals(s)) {
                    xmas++;
                }
                if (i - 3 > -1 && j - 3 > -1 && board[i - 1][j - 1].equals(m) && board[i - 2][j - 2].equals(a) && board[i - 3][j - 3].equals(s)) {
                    xmas++;
                }
                if (i + 3 < board.length && j - 3 > -1 && board[i + 1][j - 1].equals(m) && board[i + 2][j - 2].equals(a) && board[i + 3][j - 3].equals(s)) {
                    xmas++;
                }
                if (j + 3 < board.length && i - 3 > -1 && board[i - 1][j + 1].equals(m) && board[i - 2][j + 2].equals(a) && board[i - 3][j + 3].equals(s)) {
                    xmas++;
                }
            }
        }

        setResult(xmas);
    }
}
