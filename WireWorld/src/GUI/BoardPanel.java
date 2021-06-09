package GUI;

import Grid.Cell;
import Grid.Grid;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private final Grid grid;

    public BoardPanel(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (Cell cell : grid.getGrid().values()) {
            Color color = Color.black;
            switch (cell.getCellState()) {
                case ELECTRONHEAD -> color = Color.red;
                case ELECTRONTAIL -> color = Color.blue;
                case CONDUCTOR -> color = Color.yellow;
            }
            graphics.setColor(color);

            int squareSize = 10;
            int mappingScale = 10;
            graphics.fillRect(cell.getCoords().getX() * mappingScale, cell.getCoords().getY() * mappingScale, squareSize, squareSize);
        }
    }

}
