package com.nhnacademy;

import javax.swing.JFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class TestEventFrame extends JFrame {
    public TestEventFrame() {
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent arg0) {
                System.out.println("mouse drag: " + arg0.getX() + "," + arg0.getY());
            }

            @Override
            public void mouseMoved(MouseEvent arg0) {
                System.out.println("mouse move: " + arg0.getX() + "," + arg0.getY());
            }

        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent arg0) {
                System.out.println("key presse : " + arg0.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
    }

    public static void main(String[] args) {
        TestEventFrame frame = new TestEventFrame();

        frame.setSize(600, 500);

        frame.setVisible(true);
    }

  

}
