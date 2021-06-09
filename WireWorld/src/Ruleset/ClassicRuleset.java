package Ruleset;

import Coords.Coords;
import Grid.Cell;
import Grid.CellState;

import java.util.Vector;

public class ClassicRuleset implements Ruleset {

    @Override
    public Vector<Coords> getNghbrhd() {
        Vector<Coords> nghbrhd = new Vector<>(9);
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                nghbrhd.add(new Coords(x, y));
            }
        }
        nghbrhd.remove(new Coords(0, 0));
        return nghbrhd;
    }

    @Override
    public void updateState(Cell cell) {
        switch (cell.getCellState()) {
            case CONDUCTOR -> {
                if (cell.getNghbrs() == 1 || cell.getNghbrs() == 2) {
                    cell.setCellState(CellState.ELECTRONHEAD);
                }
            }
            case ELECTRONHEAD -> cell.setCellState(CellState.ELECTRONTAIL);
            case ELECTRONTAIL -> cell.setCellState(CellState.CONDUCTOR);
        }
    }
}
