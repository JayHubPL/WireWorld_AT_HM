package GridObjects;

import Coords.Coords;

public class AndGate extends GridObject {
    public AndGate(Coords coords, Orientation orientation) {
        this.relativePos = coords;
        this.orientation = orientation;
    }
}
