package com.nhnacademy;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Panel;



public class FramDemo1 {
    public static class MyCanvas extends Canvas{

        @Override
        public void paint(Graphics g){
            super.paint(g);
            g.clearRect(0, 0, getWidth(), getHeight());
            int[] x = {300,550,800};
            int[] y = {600,0,600};
            recursivedraw(g,x, y);
        }
        public static void recursivedraw(Graphics g, int[] x, int[] y){
            if(Math.pow(x[0]-x[1], 2)+Math.pow(y[0]-y[1], 2)<16){
                return;
            }
            g.drawPolygon(x, y, 3);
            int[] triangleupx = {(x[0]+x[1])/2,x[1],(x[1]+x[2])/2};
            int[] triangleupy = {(y[0]+y[1])/2,y[1],(y[1]+y[2])/2};
            recursivedraw(g, triangleupx, triangleupy);//위쪽 삼각형
            int[] trianglerightx = {(x[0]+x[2])/2,(x[1]+x[2])/2,x[2]};
            int[] trianglerighty = {(y[0]+y[2])/2,(y[1]+y[2])/2,y[2]};
            recursivedraw(g, trianglerightx, trianglerighty);//오른쪽 삼각형

            int[] triangleleftx = {x[0],(x[0] + x[1])/2,(x[0]+ x[2])/2};
            int[] trianglelefty = {y[0],(y[0] + y[1])/2,(y[0]+ y[2])/2}; 
            recursivedraw(g, triangleleftx, trianglelefty);//왼쪽 삼각형
            
            
        }
        
    } 
    
     
    public static void main(String[] args) {
        Frame frame = new Frame("RepeatedTriangle");
        frame.setSize(1400, 1400);

        frame.add(new MyCanvas());
        frame.setVisible(true);
        
    }
}
