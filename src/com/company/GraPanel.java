package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GraPanel extends JPanel {

    private Image img;

    GraPanel(){
        super();
        try {
            img = ImageIO.read(new File("obrazki/grass.jpg"));
            img = img.getScaledInstance(700,500,Image.SCALE_SMOOTH);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img,0,0,null);
    }

}
