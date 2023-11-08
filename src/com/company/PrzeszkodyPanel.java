package com.company;

import javax.swing.*;
import java.awt.*;

public class PrzeszkodyPanel extends JPanel  {
    public PrzeszkodyPanel() {


       setLayout(null);
       setOpaque(false);


        Thread c = new Thread(
                ()->{
                    try{
                        while (!Thread.currentThread().isInterrupted()){
                            Przeszkody cloud = new Przeszkody();
                            add(cloud);
                            Thread spawnC = new Thread(cloud);
                            spawnC.start();
                            Thread.sleep(1000);

                        }
                    }catch (InterruptedException e){
                    }


                }
        );
        c.start();

    }
}
