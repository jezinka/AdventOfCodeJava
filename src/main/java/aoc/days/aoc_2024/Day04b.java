package aoc.days.aoc_2024;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.util.List;

public class Day04b extends Day {

    public Day04b() {
        super();
    }

    public Day04b(List<String> input) {
        super(input);
    }

    @Override
    public void resolve() {
        String[][] board = XyUtils.prepareBoard(getInput());

        Integer xmas = 0;

        String m = "M";
        String a = "A";
        String s = "S";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(a)
                    && i - 1 > -1 && j - 1 > -1 && i + 1 < board.length && j + 1 < board.length
                    && ((board[i - 1][j - 1].equals(m) && board[i + 1][j + 1].equals(s)) || (board[i - 1][j - 1].equals(s) && board[i + 1][j + 1].equals(m)))
                    && ((board[i + 1][j - 1].equals(m) && board[i - 1][j + 1].equals(s)) || ((board[i + 1][j - 1].equals(s) && board[i - 1][j + 1].equals(m))))) {
                    xmas++;
                }
            }
        }

        setResult(xmas);
    }
}
