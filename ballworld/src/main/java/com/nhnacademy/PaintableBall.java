package com.nhnacademy;

import java.awt.Color;
import java.awt.Graphics;

public class PaintableBall extends Ball {
    public static final Color DEFAULT_COLOR = Color.BLACK;

    int x;
    int y;
    int radius;
    Color color;

    public PaintableBall(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_COLOR);

    }

    /**
     * 
     * @param color
     * @throws IllegalArgumentException color는 null 허용안함
     */
    public PaintableBall(int x, int y, int radius, Color color) {
        super(x, y, radius);

        if (color == null) {
            throw new IllegalArgumentException();
        }
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public synchronized void setColor(Color color) {
        this.color = color;
    }

    /**
     * 
     * @param g
     * @throws IllegalArgumentException g는 null 허용안함
     */
    public void paint(Graphics g) {

        if (g == null) {
            throw new IllegalArgumentException();
        }
        Color origianColor = g.getColor();

        g.setColor(getColor());
        g.fillOval(getX(), getY(), getRadius() * 2, getRadius() * 2);

        g.setColor(origianColor);
    }

}

