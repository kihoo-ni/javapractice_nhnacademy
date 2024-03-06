package com.nhnacademy;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;

public class FrameDemo2 {
    public static class MyCanvas extends Canvas{
        @Override
        public void paint(Graphics g){
            super.paint(g);
            int[] first = {450,900};
            recursivedraw(g,first, 0, 200.0);
        }
        public static void recursivedraw(Graphics g,int[] first,int angle,Double length){
            int[] second = {first[0] + (int) (length * Math.sin(Math.toRadians(angle))),first[1] - (int) (length * Math.cos(Math.toRadians(angle)))};
            g.drawLine(first[0], first[1], second[0], second[1]);
            length *= 0.7 ;//길이 줄인다.
            if(length <=1){
                return;
            }
            recursivedraw(g, second, angle-30, length);
            recursivedraw(g, second, angle+30, length);
        }
    }

    public static void main(String[] args) {
        Frame frame = new Frame("RepeatedTree");
        frame.setSize(1300,1300);
        frame.add(new MyCanvas());
        frame.setVisible(true);
    }
}