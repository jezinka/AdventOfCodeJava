package aoc.days.aoc_2016;

import aoc.days.Day;
import aoc.utils.XyUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc.utils.XyUtils.OFF;
import static aoc.utils.XyUtils.ON;

public class Day08a extends Day {

    private static final String TURN_ON_INSTRUCTION = "rect (\\d+)x(\\d+)";
    private static final String ROTATE_ROW_INSTRUCTION = "rotate row y=(\\d+) by (\\d+)";
    private static final String ROTATE_COLUMN_INSTRUCTION = "rotate column x=(\\d+) by (\\d+)";

    private Integer xMax;
    private Integer yMax;
    private String[][] board;

    public Day08a() {
        super();
        xMax = 50;
        yMax = 6;
    }

    public Day08a(List<String> input) {
        super(input);
    }

    public Day08a(List<String> input, int x, int y) {
        super(input);
        xMax = x;
        yMax = y;
    }

    @Override
    public void resolve() {
        board = new String[yMax][xMax];
        String[][] tempBoard = new String[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = OFF;
            }
        }

        for (String line : getInput()) {
            XyUtils.copyArray(board, tempBoard);

            Matcher matcherTurnOn = Pattern.compile(TURN_ON_INSTRUCTION).matcher(line);
            if (matcherTurnOn.matches()) {
                int x = Integer.parseInt(matcherTurnOn.group(1));
                int y = Integer.parseInt(matcherTurnOn.group(2));

                for (int i = 0; i < y; i++) {
                    for (int j = 0; j < x; j++) {
                        tempBoard[i][j] = ON;
                    }
                }
            } else {
                Matcher matcherRotateRow = Pattern.compile(ROTATE_ROW_INSTRUCTION).matcher(line);
                if (matcherRotateRow.matches()) {
                    int row = Integer.parseInt(matcherRotateRow.group(1));
                    int offset = Integer.parseInt(matcherRotateRow.group(2));

                    for (int j = 0; j < board[row].length; j++) {
                        int newPosition = (j + offset) % board[row].length;
                        tempBoard[row][newPosition] = board[row][j];
                    }
                } else {
                    Matcher matcherRotateColumn = Pattern.compile(ROTATE_COLUMN_INSTRUCTION).matcher(line);
                    if (matcherRotateColumn.matches()) {
                        int column = Integer.parseInt(matcherRotateColumn.group(1));
                        int offset = Integer.parseInt(matcherRotateColumn.group(2));

                        for (int j = 0; j < board.length; j++) {
                            int newPosition = (j + offset) % board.length;
                            tempBoard[newPosition][column] = board[j][column];
                        }
                    }
                }
            }

            XyUtils.copyArray(tempBoard, board);
        }

        setResult(XyUtils.getLit(board));
    }

    public String[][] getBoard() {
        return board;
    }
}
