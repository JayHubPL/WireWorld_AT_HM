package GridObjects;

import Coords.Coords;

import java.util.HashMap;

public class GridObjects {
    public HashMap<Coords, GridObject> getObjects() {
        return objects;
    }

    private HashMap<Coords, GridObject> objects;
}
