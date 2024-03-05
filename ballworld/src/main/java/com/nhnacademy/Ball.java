package com.nhnacademy;


public class Ball {
     int x; //x좌표
     int y; //y좌표
     int radius; //반지름


    
    public Ball(int x, int y, int radius) {
        if(radius<=0){
            throw new IllegalArgumentException("반지름은 0보다 커야 합니다.");
        }

        if((x+(long)radius>Integer.MAX_VALUE)
        || (x-(long)radius<Integer.MIN_VALUE)
        || (y+(long)radius>Integer.MAX_VALUE)
        || (y-(long)radius<Integer.MIN_VALUE)
        ) throw new IllegalArgumentException("볼이 정수공간 범위초과");

        this.x=x;
        this.y=y;
        this.radius=radius;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getRadius() {
        return this.radius;
    }

    @Override
    public String toString() {
     //   return "("+getX()+","+getY()+","+getRadius()+")";
       return String.format("(%d,%d,%d)", getX(), getY(), getRadius());
    }



}
