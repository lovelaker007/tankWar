package com.laker.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    // 控制坦克的方向
    Direction direction = Direction.UP;
    // 定义自己的主战坦
    Tank myTank = new Tank(200, 200, Direction.UP);

    public TankFrame(){
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("Tank War");
        this.setVisible(true);

        this.addKeyListener(new KeyListenLaker());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }

    class KeyListenLaker extends KeyAdapter{
        boolean left = false;
        boolean up = false;
        boolean right = false;
        boolean down = false;

        private void handleDirByCode() {
            if(left) direction = Direction.LEFT;
            if(up) direction = Direction.UP;
            if(right) direction = Direction.RIGHT;
            if(down) direction = Direction.DOWN;

            myTank.setDirection(direction);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int code = e.getKeyCode();
            switch(code){
                case KeyEvent.VK_LEFT:
                    left = true;
                    break;
                case KeyEvent.VK_UP :
                    up = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    right = true;
                    break;
                case KeyEvent.VK_DOWN :
                    down = true;
                    break;
                default:
                    break;
            }

            // 根据按键改变方向
            handleDirByCode();

            // lakerToDo 内部类调用外部类的方法
            // repaint 会调用外部类的paint方法
            // repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            left = false;
            up = false;
            right = false;
            down = false;
        }
    }

}
