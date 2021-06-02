package gui_test;

import Grid.*;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Grid grid;
    private int boardHeight = 600;
    private int boardWidth = 600;
    private int squareSize = 10;
    private int mappingScale = 10;

    public Board (Grid grid) {
        this.grid = grid;
    }

    public void setGeneration (Grid grid) {
        this.grid = grid;
    }

    @Override
    public void paintComponent (Graphics graphics) {
        super.paintComponent(graphics);
        if (grid == null) {

        }
        for (Cell cell : grid.getGrid().values()) {
            Color color = new Color (0,0,0);
            switch (cell.getCellState()) {
                case ELECTRONHEAD -> color = new Color (255, 0, 0);
                case ELECTRONTAIL -> color = new Color (0,0,255);
                case CONDUCTOR -> color = new Color (255, 255, 0);
            }
            graphics.setColor(color);
            graphics.fillRect(cell.getCoords().getX()*mappingScale, cell.getCoords().getY()*mappingScale, squareSize, squareSize);
        }

        /*rysowanie planszy*/
//        for (int i = 0; i < grid.getHeight(); i++) {
//            for (int j = 0; j < grid.getWidth(); j++) {
//                graphics.setColor(generation.getCell(i,j).getColor());
//                graphics.fillRect(j * squareSize, i * squareSize, squareSize, squareSize);
//            }
//        }


        /*rysowanie siatki*/
//        graphics.setColor(Color.darkGray);
//        for (int i = 0; i < generation.getHeight(); i++) {
//            graphics.fillRect(i * squareSize, 0, 1, generation.getHeight() * squareSize);
//        }
//        for (int i = 0; i < generation.getWidth(); i++) {
//            graphics.fillRect(0, i * squareSize, generation.getWidth() * squareSize, 1);
//        }

    }

}
