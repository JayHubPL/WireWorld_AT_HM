package GridObjects;

import Coords.Coords;

public class ElectronTail extends GridObject {
    public ElectronTail(Coords relativePos) {
        super(relativePos);
    }

    @Override
    void setShape() {
        this.shape.add(new Coords());
    }
}
