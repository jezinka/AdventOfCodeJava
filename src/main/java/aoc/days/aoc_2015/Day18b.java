package aoc.days.aoc_2015;

import java.util.List;


public class Day18b extends Day18a {

    public Day18b() {
        super();
        stuckOnLights();
    }

    public Day18b(List<String> input) {
        super(input);
        stuckOnLights();
    }

    @Override
    protected String getNewState(int i, int j) {
        String[][] board = getBoard();

        if ((i == 0 && j == 0) ||
                (i == 0 && j == board.length - 1) ||
                (i == board.length - 1 && j == 0) ||
                (i == board.length - 1 && j == board.length - 1)) {
            return ON;
        }

        return super.getNewState(i, j);
    }

    private void stuckOnLights() {
        String[][] board = getBoard();
        board[0][0] = ON;
        board[0][board.length - 1] = ON;
        board[board.length - 1][0] = ON;
        board[board.length - 1][board.length - 1] = ON;
    }
}

