package Grid;

import Coords.Coords;
import Ruleset.ClassicRuleset;
import Ruleset.Ruleset;

import java.util.HashMap;

public class Grid {
    private final HashMap<Coords, Cell> grid;
    private final Ruleset ruleset;

    public Grid(HashMap<Coords, Cell> grid, Ruleset ruleset) {
        this.grid = grid;
        this.ruleset = ruleset;
    }

    public Grid(HashMap<Coords, Cell> grid) {
        this(grid, new ClassicRuleset());
    }

    public HashMap<Coords, Cell> getGrid() {
        return grid;
    }

    public void updateNghbrsCount() {
        for (Cell cell : grid.values()) {
            int nghbrs = 0;
            for (Coords shift : ruleset.getNghbrhd()) {
                Coords shifted = Coords.add(shift, cell.getCoords());
                if (grid.containsKey(shifted)) {
                    if (grid.get(shifted).getCellState() == CellState.ELECTRONHEAD) {
                        nghbrs++;
                    }
                }
            }
            cell.setNghbrs(nghbrs);
        }
    }

    public void nextIteration() {
        updateNghbrsCount();
        for (Cell cell : grid.values()) {
            ruleset.updateState(cell);
        }
    }
}
