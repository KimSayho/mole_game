package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;


public class Main extends JFrame {
    private Random random = new Random();
    class Background extends Thread {
        private JLabel label;
        private JLabel molelabel;
        private int x = random.nextInt(getWidth() - 100);
        private int y = random.nextInt(getHeight() - 100);

        public Background(String background, String mole) {
            ImageIcon icon = new ImageIcon(mole);
            Image changeImg = icon.getImage().getScaledInstance(60,80,Image.SCALE_SMOOTH);
            ImageIcon newicon = new ImageIcon(changeImg);




            // 배경 설정
            label = new JLabel();
            label.setIcon(new ImageIcon(background));
            label.setBounds(0,0,getWidth(),getHeight());
            add(label);

            // 두더지 설정
            molelabel = new JLabel(newicon);
            molelabel.setBounds(x,y,60,80);
            add(molelabel);



        }
        private void MoleLocation(){
            x = random.nextInt(getWidth() - 100);
            y = random.nextInt(getHeight() - 100);
            molelabel.setBounds(x,y,60,80);
        }
        public void run() {
            while (true) {
                MoleLocation();
                repaint();
                setComponentZOrder(molelabel, 0);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Main() {
        setTitle("Mole_game");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        (new Background("background.jpg","mole.png")).start();
        setVisible(true);
    }
    public static void main(String[] args) {
        Main t = new Main();
    }
}