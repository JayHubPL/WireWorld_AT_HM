package GridObjects;

import Coords.Coords;

public class OrGate extends GridObject {
    static private final int[][] orShapeNormal = {
            {0, 1, 1, 0, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 1, 1, 1},
            {1, 0, 0, 1, 0},
            {0, 1, 1, 0, 0},
    };

    static private final int[][] orShapeReversed = {
            {0, 0, 1, 1, 0},
            {0, 1, 0, 0, 1},
            {1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 1, 0},
    };

    public OrGate(Coords relativePos, Orientation orientation) {
        super(relativePos, orientation);
    }

    @Override
    void setShape() {
        int[][] shape = orShapeNormal;
        int yOffset = 1;
        if (orientation == Orientation.REVERSED) {
            shape = orShapeReversed;
            yOffset = 2;
        }
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[y].length; x++) {
                if (shape[y][x] == 1) {
                    this.shape.add(new Coords(x, y - yOffset));
                }
            }
        }
    }
}
