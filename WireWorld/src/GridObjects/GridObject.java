package GridObjects;

import Coords.Coords;

import java.util.Vector;

public abstract class GridObject {
    protected Coords relativePos;
    protected Vector<Coords> shape;

    public Orientation getOrientation() {
        return orientation;
    }

    protected Orientation orientation;

    protected GridObject() {
        shape = new Vector<>();
        orientation = Orientation.NORMAL;
    }

    public Coords getCoords() {
        return relativePos;
    }

    public Vector<Coords> getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return "GridObject{" +
                "relativePos=" + relativePos +
                ", shape=" + shape +
                '}';
    }
}
