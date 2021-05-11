import Grid.*;
import GridObjects.GridObjects;
import TxtIO.TxtIO;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
//        Grid grid = new Grid();
//        grid.addCell(new Cell(0,0,CellState.ELECTRONHEAD));
//        grid.addCell(new Cell(1,0,CellState.ELECTRONHEAD));
//        grid.addCell(new Cell(2,0,CellState.ELECTRONHEAD));
//        grid.addCell(new Cell(2,2,CellState.ELECTRONHEAD));
//        grid.nextIteration();
//        System.out.println(grid);
        try {
            GridObjects gridObjects = TxtIO.readFromTxt("WireWorld/src/input.txt");
            System.out.println(gridObjects);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
