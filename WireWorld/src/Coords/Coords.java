package Coords;

import java.util.Objects;

public class Coords {
    final private int x;
    final private int y;

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coords() {
        this(0, 0);
    }

    static public Coords add(Coords a, Coords b) {
        return new Coords(a.x + b.x, a.y + b.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coords)) return false;
        Coords coords = (Coords) o;
        return x == coords.x && y == coords.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
