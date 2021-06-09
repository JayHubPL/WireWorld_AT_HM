package GridObjects;

import Coords.Coords;

public class Diode extends GridObject {
    private final static int[][] diodeShapeNormal = {
            {0, 0, 1, 1, 0, 0},
            {1, 1, 1, 0, 1, 1},
            {0, 0, 1, 1, 0, 0}
    };

    private final static int[][] diodeShapeReversed = {
            {0, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 0}
    };

    public Diode(Coords relativePos, Orientation orientation) {
        super(relativePos, orientation);
    }

    void setShape() {
        int[][] shape = diodeShapeNormal;
        if (orientation == Orientation.REVERSED) shape = diodeShapeReversed;
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                if (shape[y][x] == 1) {
                    this.shape.add(new Coords(x, y - 1));
                }
            }
        }
    }
}
