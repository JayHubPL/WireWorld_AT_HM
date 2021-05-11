package GridObjects;

import Coords.Coords;

import java.util.HashMap;
import java.util.Vector;

public class GridObjects {
    public GridObjects() {
        objects = new Vector<>();
    }

    public Vector<GridObject> getObjects() {
        return objects;
    }

    private Vector<GridObject> objects;

    @Override
    public String toString() {
        return "GridObjects{" +
                "objects=" + objects +
                '}';
    }
}
