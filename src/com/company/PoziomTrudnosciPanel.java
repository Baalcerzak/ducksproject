package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PoziomTrudnosciPanel extends JFrame {

    JButton b1 = new JButton("Easy");
    JButton b2 = new JButton("Medium");
    JButton b3 = new JButton("Hard");


    PoziomTrudnosciPanel() {

        setFont(new Font(null, Font.PLAIN, 10));
        setLayout(new GridLayout(1, 1, 0, 0));


        add(b1);
        add(b2);
        add(b3);

        b1.addActionListener(e -> {
            if(e.getSource()==b1){
                dispose();
              SwingUtilities.invokeLater(()->new GraFrame(1));
            }
        });
        b2.addActionListener(e -> {
            if(e.getSource()==b2){
                dispose();
                SwingUtilities.invokeLater(()->new GraFrame(2));
            }
        });
        b3.addActionListener(e -> {
            if(e.getSource()==b3){
                dispose();
                SwingUtilities.invokeLater(()->new GraFrame(4));
            }
        });


        pack();
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


}