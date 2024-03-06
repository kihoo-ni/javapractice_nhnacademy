package com.nhnacademy;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class tree {

    public static class MyCanvas3 extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            int[]start={500,1000};
            int[]finish={500,700};
            drwTree(g, start, finish, 0, start[1]-finish[1] );
        }

        public static void drwTree(Graphics g, int[] start, int[] finish, int angle, double length) {
            
            
            g.drawLine(start[0], start[1], finish[0], finish[1]);
            length *= 0.5;
            if (length <= 0.1) {
                return;
            }
            int []newfinish={finish[0]+(int)(length*Math.sin(Math.toRadians(angle))),finish[1]-(int)(length*Math.cos(Math.toRadians(angle)))};
            start[0]=finish[0];
            start[1]=finish[1];
            drwTree(g, start, newfinish, angle - 40, length);
            drwTree(g, start, newfinish, angle + 40, length);
        }
    }

    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setSize(1000, 1000);

        MyCanvas3 panel = new MyCanvas3();
        fr.add(panel);
        fr.setVisible(true);
    }

}
