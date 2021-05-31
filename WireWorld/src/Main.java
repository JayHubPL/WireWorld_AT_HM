import Grid.Grid;
import GridObjectConverter.GridObjectConverter;
import GridObjects.GridObjects;
import TxtIO.TxtIO;

public class Main {
    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            GridObjects gridObjects = TxtIO.readFromTxt("WireWorld/src/input.txt");
            Grid grid = GridObjectConverter.convertObjectsToGrid(gridObjects);
            while (n-- != 0)
                grid.nextIteration();
            TxtIO.writeToTxt("WireWorld/src/output.txt", gridObjects, grid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
