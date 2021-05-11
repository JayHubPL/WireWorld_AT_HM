package TxtIO;

import Coords.Coords;
import GridObjects.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class TxtIO {
    public static GridObjects readFromTxt(String path) throws FileNotFoundException {
        File inputFile = new File(path);
        Scanner scanner = new Scanner(inputFile);
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
                String o = a2[2];
                if (o.equals("Reversed")) {
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
    public static void writeToTxt(String path) {

    }
}
