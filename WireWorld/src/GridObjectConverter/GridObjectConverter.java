package GridObjectConverter;

import Coords.Coords;
import Grid.Cell;
import Grid.CellState;
import Grid.Grid;
import GridObjects.GridObject;

import java.util.HashMap;
import java.util.Vector;

public class GridObjectConverter {
    public static Grid convertObjectsToGrid(Vector<GridObject> gridObjects) {
        HashMap<Coords, Cell> grid = new HashMap<>();
        for (GridObject gridObject : gridObjects) {
            String objectName = gridObject.getClass().getSimpleName();
            CellState cellState = CellState.CONDUCTOR;
            if (objectName.equals("ElectronHead")) {
                cellState = CellState.ELECTRONHEAD;
            } else if (objectName.equals("ElectronTail")) {
                cellState = CellState.ELECTRONTAIL;
            }
            for (Coords relativeCoords : gridObject.getShape()) {
                Coords cellCoords = Coords.add(relativeCoords, gridObject.getCoords());
                grid.put(cellCoords, new Cell(cellCoords, cellState));
            }
        }
        return new Grid(grid);
    }
}
