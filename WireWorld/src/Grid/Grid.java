package Grid;

import Coords.Coords;

import java.util.HashMap;

public class Grid {
    public Grid() {
        grid = new HashMap<>();
    }

    public Grid(HashMap<Coords, Cell> grid) {
        this.grid = grid;
    }

    public HashMap<Coords, Cell> getGrid() {
        return grid;
    }

    private HashMap<Coords, Cell> grid;

    public void nextIteration() {
        for (Cell cell : grid.values()) {
            cell.countNghbrs(this);
        }
        for (Cell cell : grid.values()) {
            cell.updateState();
        }
    }

    @Override
    public String toString() {
        return "Grid{" +
                "grid=" + grid +
                '}';
    }

    public void addCell(Cell cell) {
        grid.put(cell.getCoords(), cell);
    }
}
