package GridObjects;

import Coords.Coords;

import java.util.Vector;

public class ElectronHead extends GridObject {
    public ElectronHead(Coords coords) {
        this.relativePos = coords;
        this.shape.add(new Coords(0,0));
    }
}
