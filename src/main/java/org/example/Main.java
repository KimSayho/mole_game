package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Main extends JFrame {
    private Random random = new Random();

    class Background extends Thread {
        private JLabel label;
        private JLabel molelabel;
        private JLabel hammerlabel;
        private int x = random.nextInt(getWidth() - 100);
        private int y = random.nextInt(getHeight() - 100);

        class Hammer extends JLabel {
            private int x = 0;
            private int y = 0;




            public void move(int deltaX, int deltaY) {
                x += deltaX;
                y += deltaY;
            }
        }


        public Background(String background, String mole,String hammer) {
            ImageIcon icon = new ImageIcon(mole);
            Image changeImg = icon.getImage().getScaledInstance(60, 80, Image.SCALE_SMOOTH);
            ImageIcon newicon = new ImageIcon(changeImg);

            ImageIcon icon2 = new ImageIcon(hammer);
            Image changeImg2 = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
            ImageIcon newicon2 = new ImageIcon(changeImg2);

            // 배경 설정
            label = new JLabel();
            label.setIcon(new ImageIcon(background));
            label.setBounds(0, 0, getWidth(), getHeight());
            add(label);

            // 두더지 설정
            molelabel = new JLabel(newicon);
            molelabel.setBounds(x, y, 60, 80);
            add(molelabel);

            hammerlabel = new JLabel(newicon2);
            hammerlabel.setBounds(x,y,40,40);
            add(hammerlabel);

            // 키 리스너 추가
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {
                }

                @Override
                public void keyPressed(KeyEvent e) {
                    int keyCode = e.getKeyCode();
                    int step = 5;

                    // 방향키를 누를 때 망치 이동
                    if (keyCode == KeyEvent.VK_LEFT) {

                    } else if (keyCode == KeyEvent.VK_RIGHT) {

                    } else if (keyCode == KeyEvent.VK_UP) {

                    } else if (keyCode == KeyEvent.VK_DOWN) {

                    }

                    // 스페이스 바를 누를 때 망치와 두더지 위치 체크
                    if (keyCode == KeyEvent.VK_SPACE) {
                            MoleLocation();

                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                }
            });
        }

        private void MoleLocation() {
            x = random.nextInt(getWidth() - 100);
            y = random.nextInt(getHeight() - 100);
            molelabel.setBounds(x, y, 60, 80);
        }

        public void run() {
            while (true) {
                MoleLocation();
                repaint();
                setComponentZOrder(molelabel, 0);
                try {
                    Thread.sleep(3000);
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

        Background backgroundThread = new Background("background.jpg", "mole.png","hammer.png");
        backgroundThread.start();

        // 포커스 설정
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        setVisible(true);
    }


    public static void main(String[] args) {
        Main t = new Main();
    }
}