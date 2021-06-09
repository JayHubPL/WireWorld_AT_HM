package Ruleset;

import Coords.Coords;
import Grid.Cell;

import java.util.Vector;

public interface Ruleset {
    Vector<Coords> getNghbrhd();

    void updateState(Cell cell);
}
