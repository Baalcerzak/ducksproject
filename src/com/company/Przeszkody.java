package com.company;

import javax.swing.*;

public class Przeszkody extends JButton implements Runnable {

    //NIE DZIALAJĄ NIE WIEM DLACZEGO(NIE MIAŁEM CZASU SIĘ DOWIEDŹIEĆ)
    boolean moveRight;
    int cloudHeight = 70;
    int cloudWidth = 70;
    int cloudSpeed = 2;

    public Przeszkody() {
        int y = (int) (Math.random() * 350);
        int random = (int) (Math.random() * 2);
        if (random == 0) {
            setBounds(
                    70, y, cloudWidth, cloudHeight
            );
            moveRight = true;


        }else{
            moveRight = false;
            setBounds(770, y, cloudWidth, cloudHeight);

        }
        setVisible(true);
    }

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()){
            if(moveRight) {
                setBounds(getX() + cloudSpeed, getY(), cloudWidth, cloudHeight);
                if(getX() >= 770){
                    return;
                }
            }else {
                setBounds(getX() - cloudSpeed, getY(), cloudWidth, cloudHeight);
                if(getX() <= -70){
                    return;

                }
            }
        }

        }
    }

