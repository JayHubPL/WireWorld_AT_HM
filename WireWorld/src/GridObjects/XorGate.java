package GridObjects;

import Coords.Coords;

public class XorGate extends GridObject {
    final static private int[][] xorShapeNormal = {
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
            {1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
    };

    final static private int[][] xorShapeReversed = {
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1},
            {0, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
    };

    public XorGate(Coords relativePos, Orientation orientation) {
        super(relativePos, orientation);
    }

    @Override
    void setShape() {
        int yOffset = 4;
        int[][] shape = xorShapeNormal;
        if (orientation == Orientation.REVERSED) {
            yOffset = 6;
            shape = xorShapeReversed;
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
