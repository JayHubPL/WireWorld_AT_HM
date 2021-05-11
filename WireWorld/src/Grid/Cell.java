package Grid;

import Coords.Coords;

public class Cell {
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

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }

    public int getNghbrs() {
        return nghbrs;
    }

    public void countNghbrs(Grid grid) {
        nghbrs = 0;
        for (Coords shift : Coords.nghbrhd) {
            Coords shifted = Coords.add(shift, coords);
            if (grid.getGrid().containsKey(shifted)) {
                if (grid.getGrid().get(shifted).getCellState() == CellState.ELECTRONHEAD) {
                    nghbrs++;
                }
            }
        }
    }

    private final Coords coords;
    private CellState cellState;
    private int nghbrs;

    @Override
    public String toString() {
        return "Cell{" +
                "coords=" + coords +
                ", cellState=" + cellState +
                ", nghbrs=" + nghbrs +
                '}';
    }
}
