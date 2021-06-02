package TxtIO;

import Coords.Coords;
import Grid.*;
import GridObjects.*;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TxtIO {
    public static GridObjects readFromTxt(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        GridObjects gridObjects = new GridObjects();
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            String[] a1 = Arrays.stream(data.split(":")).map(String::trim).toArray(String[]::new);
            String objectName = a1[0];
            String[] a2 = Arrays.stream(a1[1].split(",")).map(String::trim).toArray(String[]::new);
            int x = Integer.parseInt(a2[0]);
            int y = Integer.parseInt(a2[1]);
            Coords coords = new Coords(x, y);
            GridObject gridObject = null;
            Orientation orientation = Orientation.NORMAL;
            if (a2.length > 2) {
                String o = a2[2].toUpperCase(Locale.ROOT);
                if (o.equals("REVERSED")) {
                    orientation = Orientation.REVERSED;
                }
            }
            switch (objectName) {
                case "Diode" -> gridObject = new Diode(coords, orientation);
                case "AndGate" -> gridObject = new AndGate(coords, orientation);
                case "ElectronHead" -> gridObject = new ElectronHead(coords);
                case "ElectronTail" -> gridObject = new ElectronTail(coords);
            }
            gridObjects.getObjects().add(gridObject);
        }
        scanner.close();
        return gridObjects;
    }

    public static void writeToTxt(String path, GridObjects gridObjects, Grid grid) throws IOException {
        PrintWriter printWriter = new PrintWriter(new FileWriter(path));
        for (GridObject gOb : gridObjects.getObjects()) {
            String objectName = gOb.getClass().getSimpleName();
            if (!(objectName.equals("ElectronHead") || objectName.equals("ElectronTail"))) {
                printWriter.printf("%s: %d, %d, %s\n", objectName, gOb.getCoords().getX(), gOb.getCoords().getY(), gOb.getOrientation());
            }
        }
        for (Cell c : grid.getGrid().values()) {
            if (c.getCellState() == CellState.ELECTRONHEAD) {
                printWriter.printf("%s: %d, %d\n", "ElectronHead", c.getCoords().getX(), c.getCoords().getY());
            } else if (c.getCellState() == CellState.ELECTRONTAIL) {
                printWriter.printf("%s: %d, %d\n", "ElectronTail", c.getCoords().getX(), c.getCoords().getY());
            }
        }
        printWriter.close();
    }
}
