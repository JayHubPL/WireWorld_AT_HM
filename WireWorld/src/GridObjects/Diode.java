package GridObjects;

import Coords.Coords;

import java.util.Vector;

public class Diode extends GridObject {
    public Diode(Coords coords, Orientation orientation) {
        this.relativePos = coords;
        this.orientation = orientation;
    }
}
