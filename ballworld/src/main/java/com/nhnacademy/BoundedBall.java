package com.nhnacademy;

import java.awt.Color;
import java.awt.Rectangle;

public class BoundedBall extends MovableBall {
    Rectangle bounds;

    public BoundedBall(int x, int y, int radius, Color color){
        super(x, y, radius, color);

        bounds=new Rectangle(x-radius, y-radius, 2*radius, 2*radius);
    }

    public void setBounds(Rectangle bounds){
        this.bounds=bounds;
    }

    public Rectangle getBounds(){
        return bounds;
    }


    


}
