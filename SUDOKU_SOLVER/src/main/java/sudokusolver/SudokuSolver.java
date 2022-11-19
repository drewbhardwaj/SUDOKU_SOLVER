package sudokusolver;

import javax.swing.*;

public class SudokuSolver {
    static final int GRID_SIZE = 9;
    static int[][] board;

    public static void main(String[] args) {
         board = new int[][]{
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0 ,0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };
        if (solveBoard(board)) {
            System.out.println("Solved.");
        }
        else {
            System.out.println("Unsolvable.");
        }
        printBoard(board);

        // for GUI class;
        JFrame fr = new JFrame();
        fr.add(new GUI());
        fr.pack();
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);
        fr.setVisible(true);

    }
    private static void printBoard(int[][] board){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static boolean solveBoard(int[][] board){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0){
                    for (int k = 1; k <= GRID_SIZE; k++) {
                        if (isValidPlacement(board, k, i, j)){
                            board[i][j] = k;
                            if (solveBoard(board)) return true;
                            else board[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean isValidPlacement(int[][] board, int num, int row, int col){
        return !isNoInRow(board, num, row)
                && !isNoInCol(board, num, col)
                && !isNoInBox(board, num, row, col);
    }
    private static boolean isNoInRow(int[][] board, int num, int row){
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[row][i] == num){
                return true;
            }
        }
        return false;
    }
    private static boolean isNoInCol(int[][] board, int num, int col){
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num){
                return true;
            }
        }
        return false;
    }
    private static boolean isNoInBox(int[][] board, int num, int row, int col){
        int locBoxRow = row - row % 3;
        int locBoxCol = col - col % 3;
        for (int i = locBoxRow; i < locBoxRow+3; i++) {
            for (int j = locBoxCol; j < locBoxCol+3; j++) {
                if (board[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }
}
