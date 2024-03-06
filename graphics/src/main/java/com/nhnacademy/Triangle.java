package com.nhnacademy;

import javax.swing.*;
import java.awt.*;

public class Triangle extends JPanel {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;
    private static final int DEPTH = 10; // 프랙탈의 깊이

    // 프랙탈 삼각형을 그리는 메서드
    private void drawFractal(Graphics g, int depth, int x1, int y1, int x2, int y2, int x3, int y3) {
        if (depth == DEPTH) {
            return;
        }
        // 깊이가 최대이면 삼각형을 그린다
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);
       
        // 새로운 삼각형을 그리고 깊이를 줄여 재귀 호출한다

        drawFractal(g, depth + 1, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2, (x3 + x1) / 2, (y3 + y1) / 2);
        drawFractal(g, depth + 1, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2, (x2 + x3) / 2, (y2 + y3) / 2);
        drawFractal(g, depth + 1, (x3 + x1) / 2, (y3 + y1) / 2, (x2 + x3) / 2, (y2 + y3) / 2, x3, y3);
    }

    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 삼각형의 꼭지점 좌표 설정
        int x1 = WIDTH / 2;
        int y1 = 100;
        int x2 = 100;
        int y2 = HEIGHT - 100;
        int x3 = WIDTH - 100;
        int y3 = HEIGHT - 100;

        // 프랙탈 삼각형 그리기
        drawFractal(g, 0, x1, y1, x2, y2, x3, y3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Fractal Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Triangle triangle = new Triangle();
        frame.add(triangle);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}