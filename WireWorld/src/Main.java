import Grid.*;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        grid.addCell(new Cell(0,0,CellState.ELECTRONHEAD));
        grid.addCell(new Cell(1,0,CellState.ELECTRONHEAD));
        grid.addCell(new Cell(2,0,CellState.ELECTRONHEAD));
        grid.nextIteration();
        System.out.println(grid);
    }
}
