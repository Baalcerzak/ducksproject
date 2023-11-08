package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.time.LocalTime;

public class GraFrame extends JFrame {
    int score = 0;
    int hpB = 10;
    LocalTime timeC = LocalTime.of(0,0,0);
    JLabel pozostaleHP = new JLabel("  Pozostałe życia: "+hpB);
    JLabel czas = new JLabel("Czas: "+timeC);
    JLabel wynik = new JLabel("Wynik:"+score);


    public GraFrame(int poziomTrudnosci){

        Image image;
        setSize(700,600);
        setLayout(new BorderLayout());

        JPanel upgrade = new JPanel();
        add(upgrade, BorderLayout.NORTH);
        upgrade.setPreferredSize(new Dimension(700,100));
        upgrade.setLayout(new BoxLayout(upgrade,BoxLayout.X_AXIS));
        upgrade.setVisible(true);
        upgrade.setBackground(Color.BLUE);

        JPanel hpPanel = new JPanel();
        JPanel timePanel = new JPanel();
        timePanel.setLayout(new GridLayout(2,1,0,0));

        timePanel.setPreferredSize(new Dimension(200,50));
        timePanel.setBackground(Color.ORANGE);

        timePanel.add(czas);
        timePanel.add(wynik);
        upgrade.add(timePanel);

        hpPanel.setPreferredSize(new Dimension(200,50));
        hpPanel.setBackground(Color.PINK);

        upgrade.add(hpPanel);
        hpPanel.add(pozostaleHP);

        GraPanel game = new GraPanel();
        //add(game);
        game.setLayout(null);
        game.setVisible(true);


        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        PrzeszkodyPanel przeszkodyPanel = new PrzeszkodyPanel();
        JLayeredPane lay = new JLayeredPane();

        lay.add(przeszkodyPanel,1,0);
        przeszkodyPanel.setBounds(0,0,getWidth(),getHeight());
        lay.add(game,0,0);
        game.setBounds(0,0,getWidth(),getHeight());
        add(lay);
        lay.setVisible(true);

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK+KeyEvent.SHIFT_DOWN_MASK);
        game.getInputMap().put(keyStroke,"key");
        game.getActionMap().put("end", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });

        Kaczki.speed = poziomTrudnosci;
        Thread t = new Thread(
                ()->{

                    try {
                        while (!Thread.currentThread().isInterrupted()) {
                            Kaczki duck = new Kaczki(this);
                            game.add(duck);
                            Thread spawnD = new Thread(duck);
                            spawnD.start();
                            duck.addActionListener(e -> {
                                duck.hp--;
                                System.out.println("Stan hp " + duck.hp);
                                if(duck.hp == 0){
                                    duck.setVisible(false);
                                    score++;
                                    wynik.setText("Wynik:"+score);
                                    spawnD.interrupt();

                                }
                            });
                            int sleep = switch (poziomTrudnosci){
                                case 1-> 1600;
                                case 2-> 1200;
                                case 4-> 1000;
                                default -> 0;
                            };
                            Thread.sleep(sleep);
                        }
                    } catch(InterruptedException ignored){
                    }
                }

        );


        t.start();
        Timer timer = new Timer(this);
        Thread timerT = new Thread(timer);
        timerT.start();





    }


    public void setHpB(int hpB) {
        this.hpB = hpB;
    }
    public void setHpLabel(){
        pozostaleHP.setText("Pozostałe życia: "+hpB);
    }

    public int getHpB() {
        return hpB;
    }
    public void closeGame(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    public void setTimeC(LocalTime timeC){this.timeC = timeC;}
    public void setCzas(){czas.setText("Czas; "+timeC);}
    public LocalTime getTimeC(){return timeC;}




}
