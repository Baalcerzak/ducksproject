package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {

    JButton b1 = new JButton("New Game");
    JButton b2 = new JButton("High scores");
    JButton b3 = new JButton("Exit");

    public Menu(){
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(3,1,0,0));

        menu.add(b1);
        menu.add(b2);
        menu.add(b3);

        b1.addActionListener(this);
        b3.addActionListener(e -> System.exit(0));

        b1.setToolTipText("Ropocznij nową przygodę!");
        b2.setToolTipText("Zobacz najlepszych graczy!");
        b3.setToolTipText("Wyjdź");

        add(menu);
        pack();
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

        @Override
         public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
            dispose();
            new PoziomTrudnosciPanel();
        }
    }


}




