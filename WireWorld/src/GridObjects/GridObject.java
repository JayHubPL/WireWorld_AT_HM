package GridObjects;

import Coords.Coords;

import java.util.Vector;

public abstract class GridObject {
    protected final Vector<Coords> shape;
    protected Coords relativePos;
    protected Orientation orientation;

    GridObject() {
        shape = new Vector<>();
    }

    protected GridObject(Coords relativePos, Orientation orientation) {
        this();
        this.relativePos = relativePos;
        this.orientation = orientation;
        setShape();
    }

    protected GridObject(Coords relativePos) {
        this(relativePos, Orientation.NORMAL);
    }

    abstract void setShape();

    public Orientation getOrientation() {
        return orientation;
    }

    public Coords getCoords() {
        return relativePos;
    }

    public Vector<Coords> getShape() {
        return shape;
    }
}
