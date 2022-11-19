package sudokusolver;

import javax.swing.*;
import java.awt.*;

import static sudokusolver.SudokuSolver.GRID_SIZE;
import static sudokusolver.SudokuSolver.board;


public class GUI extends JPanel {
    JButton[][] btn = new JButton[GRID_SIZE][GRID_SIZE];
    GUI(){
        this.setPreferredSize(new Dimension(500, 550));
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                btn[i][j] = new JButton(String.valueOf(board[i][j]));
                btn[i][j].setFocusable(false);
                btn[i][j].setFont(new Font("Segoe UI",Font.BOLD, 30));
                this.add(btn[i][j]);
            }
        }
    }
}
