package Coords;

import java.util.Objects;
import java.util.Vector;

public class Coords {
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    final private int x;
    final private int y;
    final static public Vector<Coords> nghbrhd = generateNghbrhd();

    public Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static private Vector<Coords> generateNghbrhd() {
        Vector<Coords> v = new Vector<>(9);
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                v.add(new Coords(x, y));
            }
        }
        v.remove(new Coords(0, 0));
        return v;
    }

    static public Coords add(Coords a, Coords b) {
        return new Coords(a.x + b.x, a.y + b.y);
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

    @Override
    public String toString() {
        return "Coords{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
