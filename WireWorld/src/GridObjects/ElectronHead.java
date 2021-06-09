package GridObjects;

import Coords.Coords;

public class ElectronHead extends GridObject {
    public ElectronHead(Coords relativePos) {
        super(relativePos);
    }

    @Override
    void setShape() {
        this.shape.add(new Coords());
    }
}
