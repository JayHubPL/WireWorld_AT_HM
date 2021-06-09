package GUI;

import Grid.Grid;
import GridObjectConverter.GridObjectConverter;
import GridObjects.GridObject;
import TxtIO.TxtIO;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;


public class GUI extends JFrame {
    private final JFileChooser fileChooser;
    private JLabel loaded;
    private JLabel saved;
    private JLabel iterations;
    private JPanel gridPanel;
    private Grid grid;
    private Vector<GridObject> gridObjects;
    private JTextField numberIt;
    private File inputFile;
    private int iter;
    private int currIter;
    private boolean stopped;

    public GUI() {
        iter = 5;
        currIter = 0;
        stopped = true;
        fileChooser = new JFileChooser();

        initializeFrame();
        initializeMenu();
    }

    private void initializeFrame() {
        setSize(450, 600);
        setTitle("WireWorld");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        JLabel title = new JLabel();
        title.setText("WireWorld");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setOpaque(true);
        title.setBounds(150, 10, 100, 50);
        add(title);

        JLabel authors = new JLabel();
        authors.setForeground(Color.BLACK);
        authors.setFont(new Font("Arial", Font.PLAIN, 8));
        authors.setText("Amelia Tabor i Hubert Mazur");
        authors.setBounds(260, 13, 120, 20);
        add(authors);


    }

    private void initializeGrid() {
        if (gridPanel != null) {
            this.remove(gridPanel);
        }
        gridPanel = new BoardPanel(grid);
        gridPanel.setBackground(Color.black);
        gridPanel.setBounds(30, 75, 375, 200);
        gridPanel.setVisible(true);
        add(gridPanel);
        gridPanel.repaint();
    }

    private void initializeMenu() {

        JButton start = new JButton("Start");
        start.setBackground(new Color(21, 158, 23));
        start.setForeground(Color.white);
        start.setBounds(55, 300, 75, 50);
        start.setFocusPainted(false);
        start.addActionListener(e -> {
            try {
                gridObjects = TxtIO.readFromTxt(inputFile.getPath());
                if (!stopped) return;
                currIter = 0;
                stopped = false;
                grid = GridObjectConverter.convertObjectsToGrid(gridObjects);
                initializeGrid();
                new Thread(() -> {
                    while (++currIter < iter) {
                        try {
                            Thread.sleep(750);
                        } catch (InterruptedException exception) {
                            exception.printStackTrace();
                        }
                        if (stopped) return;
                        grid.nextIteration();
                        gridPanel.repaint();
                    }
                    stopped = true;
                }).start();
            } catch (FileNotFoundException exception) {
                System.err.println("Plik wejsciowy nie moze byc ponownie wczytany.");
            } catch (NullPointerException exception) {
                System.err.println("Nie wczytano żadnego pliku wejściowego.");
            }
        });
        add(start);

        //następna iteracja
        JButton next = new JButton("następna iteracja");
        next.setBackground(Color.MAGENTA);
        next.setForeground(Color.white);
        next.setBounds(140, 300, 150, 50);
        next.setFocusPainted(false);
        next.addActionListener(e -> {
            try {
                grid.nextIteration();
                gridPanel.repaint();
                currIter++;
            } catch (NullPointerException exception) {
                System.err.println("Nie wczytano żadnego pliku wejściowego.");
            }
        });
        add(next);

        //reset
        JButton reset = new JButton("reset");
        reset.setBackground(Color.red);
        reset.setForeground(Color.white);
        reset.setBounds(297, 300, 75, 50);
        reset.setFocusPainted(false);
        reset.setHorizontalTextPosition(JButton.CENTER);
        reset.addActionListener(e -> {
            try {
                gridObjects = TxtIO.readFromTxt(inputFile.getPath());
                grid = GridObjectConverter.convertObjectsToGrid(gridObjects);
                initializeGrid();
                currIter = 0;
                stopped = true;
            } catch (FileNotFoundException exception) {
                System.err.println("Plik wejsciowy nie moze byc ponownie wczytany.");
            } catch (NullPointerException exception) {
                System.err.println("Nie wczytano żadnego pliku wejściowego.");
            }
        });
        add(reset);


        //liczba iteracji
        iterations = new JLabel("liczba iteracji");
        iterations.setBounds(175, 350, 100, 50);
        add(iterations);

        //wczytanie liczby iteracji
        numberIt = new JTextField();
        numberIt.setBounds(140, 400, 150, 25);
        numberIt.setHorizontalAlignment(JTextField.CENTER);
        numberIt.addActionListener(e -> {
            //zapisanie do struktury liczby iteracji do wykonania
            iter = Integer.parseInt(numberIt.getText());
            iterations.setText("liczba iteracji " + iter);
        });
        add(numberIt);

        JLabel messeges = new JLabel();
        messeges.setForeground(Color.BLUE);
        messeges.setFont(new Font("Arial", Font.BOLD, 12));
        messeges.setOpaque(true);
        messeges.setBounds(30, 425, 300, 30);
        messeges.setVisible(true);
        add(messeges);

        //wczytywanie z pliku
        JButton load = new JButton("Wczytaj");
        load.setBackground(Color.BLUE);
        load.setForeground(Color.white);
        load.setBounds(30, 375, 100, 50);
        load.setFocusPainted(false);

        loaded = new JLabel();
        loaded.setForeground(Color.BLUE);
        loaded.setFont(new Font("Arial", Font.PLAIN, 12));
        loaded.setOpaque(true);
        loaded.setBounds(30, 450, 300, 30);
        loaded.setVisible(false);
        add(loaded);
        load.addActionListener(e -> {
            if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                inputFile = fileChooser.getSelectedFile();
                try {
                    gridObjects = TxtIO.readFromTxt(inputFile.getPath());
                    loaded.setText("wczytano z pliku:" + inputFile.getPath());
                    loaded.setVisible(true);
                    grid = GridObjectConverter.convertObjectsToGrid(gridObjects);
                    initializeGrid();
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(load);

        //zapis do pliku
        JButton save = new JButton("Zapisz");
        save.setBackground(Color.BLUE);
        save.setForeground(Color.white);
        save.setBounds(300, 375, 100, 50);
        save.setFocusPainted(false);

        saved = new JLabel();
        saved.setForeground(Color.BLUE);
        saved.setFont(new Font("Arial", Font.PLAIN, 12));
        saved.setOpaque(true);
        saved.setBounds(30, 475, 300, 30);
        saved.setVisible(false);
        add(saved);

        save.addActionListener(e -> {
            if (gridObjects == null || grid == null) {
                System.err.println("Nie wczytano żadnego pliku wejściowego.");
                return;
            }
            if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File output = fileChooser.getSelectedFile();
                //zapis do pliku
                try {
                    TxtIO.writeToTxt(output.getPath(), gridObjects, grid);
                } catch (IOException exception) {
                    System.err.println("Blad wypisywania do pliku");
                }
                saved.setText("zapisano do pliku:" + output.getPath());
                saved.setVisible(true);
            }
        });
        add(save);

    }
}
