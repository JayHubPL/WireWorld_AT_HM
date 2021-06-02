package gui_test;

import Grid.Grid;
import GridObjectConverter.GridObjectConverter;
import GridObjects.GridObjects;
import TxtIO.TxtIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GUI extends JFrame {
    private JLabel title, authors, loaded, saved, iterations, messeges;
    private JPanel toolBar, tHeader, gridPanel;
    private JTextField nrIterations;
    private JButton start, run, save, load, reset, next;
    private final JFileChooser fileChooser = new JFileChooser();
    private final Color clr = new Color(255, 0, 0);
    private Grid grid;
    private GridObjects gridObjects;
    private JTextField numberIt;
    private File inputFile;

    public GUI() {

        initializeFrame();
        // initializeGrid();
        initializeMenu();



           /* title = new JLabel();
            title.setText("WireWorld");
            title.setHorizontalTextPosition(JLabel.CENTER);
            title.setForeground(Color.BLACK);
            title.setFont(new Font("Arial", Font.BOLD, 20));
            title.setBackground(new Color(116, 179, 212));
            title.setOpaque(true);
            title.setVerticalAlignment(JLabel.TOP);
            title.setHorizontalAlignment(JLabel.CENTER);

            authors = new JLabel();
            authors.setForeground(Color.BLACK);
            authors.setFont(new Font("Arial", Font.PLAIN, 10));
            authors.setHorizontalTextPosition(JLabel.CENTER);
            authors.setText("Amelia Tabor i Hubert Mazur");
            authors.setBackground(new Color(116, 179, 212));
            authors.setOpaque(true);
            authors.setVerticalAlignment(JLabel.TOP);
            authors.setHorizontalAlignment(JLabel.RIGHT);

            run =new JButton();
            run.setBounds(100, 400, 100, 75);
            run.setText("RUN");
            run.setVerticalAlignment(JLabel.BOTTOM);
            run.setHorizontalAlignment(JLabel.CENTER);

            inField = new JTextField();
           // inField.setHorizontalAlignment(JLabel.LEFT);
            inField.setBounds(0,450,175,50);

            tHeader = new JPanel();
            tHeader.setBackground(new Color(116, 179, 212));
            tHeader.setBounds(0, 0, 400, 50);
            //tHeader.setLayout((new BorderLayout()));
            tHeader.add(title);
            tHeader.add(authors);

            gridPanel = new JPanel();
            gridPanel.setBackground(Color.black);
            gridPanel.setBounds(0, 50, 400, 400);
            //gridPanel.setLayout((new BorderLayout()));

            toolBar = new JPanel();
            toolBar.setBackground(new Color(116, 179, 212));
            toolBar.setBounds(0, 450, 400, 50);
            toolBar.setLayout((new FlowLayout()));
            toolBar.add(run);
            toolBar.add(inField);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           // this.setSize(400, 500);
           // this.setResizable(false);
            this.setVisible(true);
            this.add(tHeader);
            this.add(gridPanel);
            this.add(toolBar);
            //this.add(inField);
            this.pack();*/

    }

    private void initializeFrame(){
        setSize(450, 600);
        setTitle("WireWorld");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        title = new JLabel();
        title.setText("WireWorld");
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        //title.setBackground(new Color(116, 179, 212));
        title.setOpaque(true);
        title.setBounds(150, 10,100, 50);
        add(title);

        authors = new JLabel();
        authors.setForeground(Color.BLACK);
        authors.setFont(new Font("Arial", Font.PLAIN, 8));
        authors.setText("Amelia Tabor i Hubert Mazur");
        authors.setBounds(260, 13,120, 20);
        add(authors);


    }

    private void initializeGrid() {
        if (gridPanel != null) {
            this.remove(gridPanel);
        }
        gridPanel = new Board(grid);
        gridPanel.setBackground(Color.black);
        gridPanel.setBounds(30, 75, 375, 200);
        //gridPanel.setLayout((new BorderLayout()));
        gridPanel.setVisible(true);
        add(gridPanel);
        gridPanel.repaint();
    }

    private void initializeMenu(){

        start = new JButton("Start");
        start.setBackground(new Color(21, 158, 23));
        start.setForeground(Color.white);
        start.setBounds(55, 300, 75, 50);
        start.setFocusPainted(false);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //uruchomienie programu
            }
        });
        add(start);

        //następna iteracja
        next = new JButton("następna iteracja");
        next.setBackground(Color.MAGENTA);
        next.setForeground(Color.white);
        next.setBounds(140, 300, 150, 50);
        next.setFocusPainted(false);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                grid.nextIteration();
                gridPanel.repaint();
            }
        });
        add(next);

        //reset
        reset = new JButton("reset");
        reset.setBackground(clr);
        reset.setForeground(Color.white);
        reset.setBounds(297, 300, 75 , 50);
        reset.setFocusPainted(false);
        reset.setHorizontalTextPosition(JButton.CENTER);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    gridObjects = TxtIO.readFromTxt(inputFile.getPath());
                    grid = GridObjectConverter.convertObjectsToGrid(gridObjects);
                    initializeGrid();
                } catch (FileNotFoundException exception) {
                    System.err.println("Plik wejsciowy nie moze byc ponownie wczytany.");
                }
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
        numberIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //zapisanie do struktury liczby iteracji do wykonania
                int nr = (int)(Double.parseDouble(numberIt.getText()));
                iterations.setText("liczba iteracji " + nr);
            }
        });
        add(numberIt);

        messeges = new JLabel();
        messeges.setForeground(Color.BLUE);
        messeges.setFont(new Font("Arial", Font.BOLD, 12));
        messeges.setOpaque(true);
        messeges.setBounds(30, 425,300, 30);
        messeges.setVisible(true);
        add(messeges);

        //wczytywanie z pliku
        load = new JButton("Wczytaj");
        load.setBackground(Color.BLUE);
        load.setForeground(Color.white);
        load.setBounds(30, 375, 100, 50);
        load.setFocusPainted(false);

        loaded = new JLabel();
        loaded.setForeground(Color.BLUE);
        loaded.setFont(new Font("Arial", Font.PLAIN, 12));
        loaded.setOpaque(true);
        loaded.setBounds(30, 450,300, 30);
        loaded.setVisible(false);
        add(loaded);
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    inputFile = fileChooser.getSelectedFile();
                    try {
                        GridObjects gridObjects = TxtIO.readFromTxt(inputFile.getPath());
                        System.out.println("\nWczytane obiekty:\n");
                        System.out.println(gridObjects);

                        //DLACZEGO TO NIE DZIAŁA??? (nie wyświetla się label)

                        loaded.setText("wczytano z pliku:"+ inputFile.getPath());
                        loaded.setVisible(true);

                        gridObjects = TxtIO.readFromTxt(inputFile.getPath());
                        grid = GridObjectConverter.convertObjectsToGrid(gridObjects);

                        initializeGrid();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        add(load);

        //zapis do pliku
        save = new JButton("Zapisz");
        save.setBackground(Color.BLUE);
        save.setForeground(Color.white);
        save.setBounds(300, 375, 100, 50);
        save.setFocusPainted(false);

        saved = new JLabel();
        saved.setForeground(Color.BLUE);
        saved.setFont(new Font("Arial", Font.PLAIN, 12));
        saved.setOpaque(true);
        saved.setBounds(30, 475,300, 30);
        saved.setVisible(false);
        add(saved);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File output = fileChooser.getSelectedFile();
                    //zapis do pliku
                    try {
                        TxtIO.writeToTxt(output.getPath(), gridObjects, grid);
                    } catch (IOException exception) {
                        System.err.println("Blad wypisywania do pliku");
                    }
                    saved.setText("zapisano do pliku:"+ output.getPath());
                    saved.setVisible(true);
                }
            }
        });
        add(save);

    }

//    public static void main(String args[]) {
//        new GUI();
//    }
}
