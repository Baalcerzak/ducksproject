package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Kaczki extends JButton implements Runnable {

    int hp;
    static int speed;
    int width = 80;
    int height = 80;
    boolean moveRight;
    int color;
    Image image;
    GraFrame graFrame;


    public Kaczki(GraFrame graFrame) {

        this.graFrame = graFrame;
        int y = (int) (Math.random() * 350);
        int random = (int) (Math.random() * 2);
        System.out.println(random);
        color = (int) (Math.random() * 3) + 1;

            if (random == 0) {
                setBounds(
                        -80, y, width, height
                );
                moveRight = true;
                switch (color) {
                    case 1 -> {
                        hp = 3;
                        try {
                            image = ImageIO.read(new File("obrazki/kaczoryellow1.png"));
                            image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                            setIcon(new ImageIcon(image));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    case 2 -> {
                        hp = 2;
                        try {
                            image = ImageIO.read(new File("obrazki/kaczorblue1.png"));
                            image = image.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
                            setIcon(new ImageIcon(image));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    case 3 -> {
                        hp = 1;
                        try {
                            image = ImageIO.read(new File("obrazki/kaczor1.png"));
                            image = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
                            setIcon(new ImageIcon(image));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                switch (color) {
                    case 1 -> {
                        hp = 3;
                        try {
                            image = ImageIO.read(new File("obrazki/kaczoryellow1op.png"));
                            image = image.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                            setIcon(new ImageIcon(image));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                    case 2 -> {
                        hp = 2;
                        try {
                            image = ImageIO.read(new File("obrazki/kaczorblue1op.png"));
                            image = image.getScaledInstance(190, 190, Image.SCALE_SMOOTH);
                            setIcon(new ImageIcon(image));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    case 3 -> {
                        hp = 1;
                        try {
                            image = ImageIO.read(new File("obrazki/kaczor1op.png"));
                            image = image.getScaledInstance(140, 140, Image.SCALE_SMOOTH);
                            setIcon(new ImageIcon(image));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
                setBounds(700, y, getWidth(), getHeight());
                moveRight = false;
            }

            setOpaque(false);
            setContentAreaFilled(false);
            setBorderPainted(false);


        }



    @Override
    public void run() {
        while(getX() < 700 + width && !Thread.currentThread().isInterrupted()){
            if(moveRight) {
                setBounds(getX() + speed, getY(), width, height);
                if(getX() >= 780){
                    graFrame.setHpB(graFrame.getHpB()-1);
                    graFrame.setHpLabel();
                    return;
                }
            }else {
                setBounds(getX() - speed, getY(), width, height);
                if(getX() <= -80){
                    graFrame.setHpB(graFrame.getHpB()-1);
                    graFrame.setHpLabel();
                    return;

                }
            }
            if(graFrame.getHpB() == 0){
                graFrame.closeGame();

            }
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                return;

            }


        }



    }
}











