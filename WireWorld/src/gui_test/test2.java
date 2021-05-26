package gui_test;

import Grid.Grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;


public class test2 extends JFrame {
    private JLabel title, authors;
    private JPanel toolBar, tHeader, gridPanel;
    private JTextField nrIterations;
    private JButton start, run, save, load, reset, next;
    private final JFileChooser fileChooser = new JFileChooser();
    private Color clr = new Color(255, 0, 0);
    private Grid grid;
    private

    test2() {


        initializeFrame();
        initializeMenu();
        initializeGrid();


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
        setSize(400, 500);
        setTitle("WireWorld");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
    }

    private void initializeMenu(){

        start = new JButton("Start");
        start.setBackground(new Color(21, 158, 23));
        start.setForeground(Color.white);
        start.setBounds(10, 300, 75, 50);
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
        next.setBounds(95, 300, 150, 50);
        next.setFocusPainted(false);
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //grid.nextIteration();
            }
        });
        add(next);

        //reset
        reset = new JButton("reset");
        reset.setBackground(clr);
        reset.setForeground(Color.white);
        reset.setBounds(255, 300, 115 , 50);
        reset.setFocusPainted(false);
        reset.setHorizontalTextPosition(JButton.CENTER);
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //co sie dzieje po resecie - wartosci z powrotem na domyślne
            }
        });
        add(reset);

        //wczytywanie z pliku
        load = new JButton("Wczytaj");
        load.setBackground(Color.BLUE);
        load.setForeground(Color.white);
        load.setBounds(10, 375, 100, 50);
        load.setFocusPainted(false);
        load.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File picked = fileChooser.getSelectedFile();
                   //załadowanie pliku do struktury
                }
            }
        });
        add(load);

        //zapis do pliku
        save = new JButton("Zapisz");
        save.setBackground(Color.BLUE);
        save.setForeground(Color.white);
        save.setBounds(270, 375, 100, 50);
        save.setFocusPainted(false);
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File save = fileChooser.getSelectedFile();
                    //zapis do pliku
                }
            }
        });
        add(save);

    }

    private void initializeGrid(){

    }

    public static void main(String args[]) {
        new test2();

    }
}
