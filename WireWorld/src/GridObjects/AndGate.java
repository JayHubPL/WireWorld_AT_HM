package GridObjects;

import Coords.Coords;

public class AndGate extends GridObject {
    private final static char[][] andShapeNormal = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 0 ,1, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1 },
            { 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    };

    public AndGate(Coords coords, Orientation orientation) {
        this.relativePos = coords;
        this.orientation = orientation;
        for (int y = 0; y < andShapeNormal.length; y++) {
            for (int x = 0; x < andShapeNormal[y].length; x++ ) {
                if (andShapeNormal[y][x] == 1) {
                    shape.add(new Coords(x, y));
                }
            }
        }
    }
}
