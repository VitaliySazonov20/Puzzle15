import javax.swing.*;
import java.util.Objects;

public class Cell extends JButton {
    JButton button= new JButton();
    GameWindow window;
    int cellSize=100;
    int x;
    int y;
    Cell[][] cellArray;
    Cell(GameWindow window,int y,int x){
        this.window=window;
        this.x=x;
        this.y=y;
        button.setBounds(x*cellSize+100,y*cellSize+100,cellSize,cellSize);
        if(4*y+x+1!=16)
            button.setText(String.valueOf(4*y+x+1));
        else {
            button.setText(" ");
            window.emptyCellX=x;
            window.emptyCellY=y;
        }
        button.addActionListener(e -> {
            move();
        });
        window.window.add(button);
    }
    public void addArray(Cell[][] cells) {
        this.cellArray=cells;
    }

    public void move() {
        if(x+1<4&& cellArray[y][x+1].button.getText()==" "){
            cellArray[y][x+1].button.setText(button.getText());
            button.setText(" ");
            window.emptyCellX=x;
            window.emptyCellY=y;

        }
        if(x-1>=0&& cellArray[y][x-1].button.getText()==" "){
            cellArray[y][x-1].button.setText(button.getText());
            button.setText(" ");
            window.emptyCellX=x;
            window.emptyCellY=y;
        }
        if(y+1<4&& cellArray[y+1][x].button.getText()==" "){
            cellArray[y+1][x].button.setText(button.getText());
            button.setText(" ");
            window.emptyCellX=x;
            window.emptyCellY=y;
        }
        if(y-1>=0&& cellArray[y-1][x].button.getText()==" "){
            cellArray[y-1][x].button.setText(button.getText());
            button.setText(" ");
            window.emptyCellX=x;
            window.emptyCellY=y;
        }
        window.check();
    }


}
