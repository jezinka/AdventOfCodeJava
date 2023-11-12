package aoc.days.aoc_2015;

import aoc.days.Day;

import java.util.ArrayList;
import java.util.List;

import static aoc.utils.XyUtils.*;


public class Day18a extends Day {

    private boolean showPreview = false;
    private int steps;
    private String[][] board;

    public Day18a() {
        super();
        board = prepareBoard(getInput());
        setSteps(100);
    }

    public Day18a(List<String> input) {
        super(input);
        showPreview = true;
        board = prepareBoard(getInput());
    }

    @Override
    public void resolve() {
        if (showPreview) printBoard(board);

        for (int s = 0; s < steps; s++) {
            String[][] tempBoard = new String[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    tempBoard[i][j] = getNewState(i, j);
                }
            }
            copyArray(tempBoard, board);
            if (showPreview) printBoard(board);
        }

        long counter = getLit(board);
        setResult(counter);
    }

    protected String getNewState(int i, int j) {
        List<String> neighbours = new ArrayList<>();
        for (int k = Math.max(0, i - 1); k <= Math.min(board.length - 1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(board[i].length - 1, j + 1); l++) {
                if (k != i || l != j) {
                    neighbours.add(board[k][l]);
                }
            }
        }

        if (neighbours.stream().filter(light -> light.equals(ON)).count() == 3 || (board[i][j].equals(ON) && neighbours.stream().filter(light -> light.equals(ON)).count() == 2)) {
            return ON;
        }
        return OFF;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }
}

