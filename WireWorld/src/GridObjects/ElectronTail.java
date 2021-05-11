package GridObjects;

import Coords.Coords;

public class ElectronTail extends GridObject {
    public ElectronTail(Coords coords) {
        this.relativePos = coords;
        this.shape.add(new Coords(0,0));
    }
}
