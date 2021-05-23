package gui_test;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame  {

    private JToolBar toolBar;
    private JPanel mainPanel;
    private JButton RUNButton;
    private JTextField inFileTextField;
    private JLabel inFileLabel;
    private JLabel iterationLabel;
    private JTextField textField1;
    private JLabel inSucces;

    public test(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        RUNButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //grab the text from the inFileTextField
                //convert to String
                // use as in  GridObjects gridObjects = TxtIO.readFromTxt("WireWorld/src/input.txt");
                String infilePath = inFileTextField.getText();
                inSucces.setText("wczytano plik: "+ infilePath);
            }
        });
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
    public static void main(String [] args){
        JFrame frame = new test ("myTest");
        frame.setVisible(true);
    }
}
