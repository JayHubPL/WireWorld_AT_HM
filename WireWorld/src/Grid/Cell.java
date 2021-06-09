package Grid;

import Coords.Coords;

public class Cell {
    private final Coords coords;
    private CellState cellState;
    private int nghbrs;

    public Cell(Coords coords, CellState cellState) {
        this.coords = coords;
        this.cellState = cellState;
        nghbrs = 0;
    }

    public Cell(int x, int y, CellState cellState) {
        this(new Coords(x, y), cellState);
    }

    public Cell(Coords coords) {
        this(coords, CellState.CONDUCTOR);
    }

    public Coords getCoords() {
        return coords;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public int getNghbrs() {
        return nghbrs;
    }

    public void setNghbrs(int nghbrs) {
        this.nghbrs = nghbrs;
    }
}
