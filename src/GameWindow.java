import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class GameWindow {
    JFrame window = new JFrame();
    int WIDTH = 600;
    int HEIGHT = 600;
    int emptyCellX;
    int emptyCellY;

    Cell[][] cells = new Cell[4][4];

    GameWindow() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell(this, i, j);

                window.add(cells[i][j]);
            }
        }
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                cell.addArray(cells);
            }
        }
        shuffle();
        for (Cell[] cellRow : cells) {
            for (Cell cell : cellRow) {
                cell.button.setEnabled(true);
            }
        }

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setLayout(null);
        window.setVisible(true);
    }

    private void shuffle() {
        Random random = new Random();
        int state;
        for (int i = 0; i < 100; i++) {
            state = random.nextInt(4);
            if (state == 0 && emptyCellX + 1 < 4) {
                cells[emptyCellY][emptyCellX + 1].move();
            }
            if (state == 1 && emptyCellX - 1 >= 0) {
                cells[emptyCellY][emptyCellX - 1].move();
            }
            if (state == 2 && emptyCellY + 1 < 4) {
                cells[emptyCellY + 1][emptyCellX].move();
            }
            if (state == 3 && emptyCellY - 1 >= 0) {
                cells[emptyCellY - 1][emptyCellX].move();
            }

        }
    }

    public void check() {
        boolean gameOver = true;
        outerLoop:
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if(i==3 && j==3)
                    continue;
                if (!cells[i][j].button.getText().equals(String.valueOf((4 * i) + j + 1))) {
                    System.out.println(i+" and "+ j+ " not in right place");
                    gameOver = false;
                    break outerLoop;
                }
            }
        }
        if (gameOver) {
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    cells[i][j].button.setEnabled(false);
                }
            }
        }
    }
}
