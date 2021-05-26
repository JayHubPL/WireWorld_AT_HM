package gui_test;

import javax.swing.*;
import java.awt.*;

public class test2 {
    JLabel title;
    JLabel authors;
    JPanel toolBar;
    JPanel tHeader;
    JPanel gridPanel;
    JFrame frame;
        test2() {
            title = new JLabel();
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
            //toolBar.setLayout((new BorderLayout()));


            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 500);
            frame.setResizable(false);
            frame.setVisible(true);
            frame.add(tHeader);
            frame.add(gridPanel);
            frame.add(toolBar);
            //frame.add(authors);
            //frame.add(title);
            //frame.pack();
        }

    public static void main(String args[]) {
    }
}
