package GridObjectConverter;

import Coords.Coords;
import Grid.*;
import GridObjects.*;

import java.util.HashMap;

public class GridObjectConverter {
    public static Grid convertObjectsToGrid(GridObjects gridObjects) {
        HashMap<Coords, Cell> grid = new HashMap<>();
        for (GridObject gridObject : gridObjects.getObjects().values()) {
            for (Coords relativeCoords : gridObject.getShape()) {
                Coords cellCoords = Coords.add(relativeCoords, gridObject.getCoords());
                grid.put(cellCoords, new Cell(cellCoords)); // ustalanie stanu komórki jest potrzbene
            }
        }
        return new Grid(grid);
    }
}
