package Clock_GUI;
/*
Callum Jenkins
Title
23/09/2020 of 09, 2020
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GUI implements ActionListener {

    //In the scope of all methods
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    private JButton reset;
    private JLabel label;
    private JLabel iconLabel;
    int count = 0;

    public GUI() throws IOException {

        //objects
        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Start");
        reset = new JButton("Reset");
        label = new JLabel("00:00:00");


        //panel
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30 , 10, 30)); //Sets border using borderfactory, createEmptyBorder((Top, Right, Bottom, Left)px)
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(reset);
        panel.add(label);

        //frame
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Clock");
        frame.pack();
        frame.setVisible(true);

        //click button
        clickEvent c = new clickEvent();
        button.addActionListener(c);

        //reset button
        resetEvent r = new resetEvent();
        reset.addActionListener(r);
    }

    public class clickEvent implements ActionListener {
        public void actionPerformed(ActionEvent c) {
            Clock c1 = new Clock();
            for (int i = 0; i < 300; i++)
            {
                label.setText(c1.tick());
            }
        }
    }

    public class resetEvent implements ActionListener {
        public void actionPerformed(ActionEvent r) {
            count = 0;
            label.setText("Number of clicks: " + count);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) throws IOException {

        new GUI();
    }
}
