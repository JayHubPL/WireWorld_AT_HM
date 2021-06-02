package GridObjects;

import Coords.Coords;

import java.util.Vector;

public class Diode extends GridObject {
    private final static char[][] diodeShapeNormal = {
            { 0, 0, 1, 1, 0, 0 },
            { 1, 1, 1, 0, 1, 1 },
            { 0, 0, 1, 1, 0, 0 }
    };

    private final static char[][] diodeShapeReversed = {
            { 0, 0, 1, 1, 0, 0 },
            { 1, 1, 0, 1, 1, 1 },
            { 0, 0, 1, 1, 0, 0 }
    };

    private void setShape(char[][] charShape) {
        for (int y = 0; y < charShape.length; y++) {
            for (int x = 0; x < charShape[y].length; x++) {
                if (charShape[y][x] == 1) {
                    shape.add(new Coords(x, y - 1));
                }
            }
        }
    }

    public Diode(Coords coords, Orientation orientation) {
        this.relativePos = coords;
        this.orientation = orientation;
        switch (orientation) {
            case NORMAL -> setShape(diodeShapeNormal);
            case REVERSED -> setShape(diodeShapeReversed);
        }
    }
}
