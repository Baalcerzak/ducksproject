package com.company;

import java.time.LocalTime;

public class Timer implements Runnable{

        LocalTime timer = LocalTime.of(0,0,0);
        GraFrame graFrame;

    public Timer(GraFrame graFrame) {
        this.graFrame = graFrame;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                graFrame.setTimeC(graFrame.getTimeC().plusSeconds(1));
                this.timer = timer.plusSeconds(1);
                graFrame.setCzas();
                if(timer.getSecond()%5==0){
                    Kaczki.speed = Kaczki.speed +1;
                    System.out.println("speed:" +Kaczki.speed);

                }

                Thread.sleep(1000);
            }

        }catch(InterruptedException ignored) {

        }
    }
}



