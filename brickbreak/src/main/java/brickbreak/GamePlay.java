package brickbreak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class GamePlay extends JPanel implements KeyListener, ActionListener {
    private boolean play = false;
    private int score = 0; // 점수 0점으로 초기화
    private int totalBricks = 21; // 전체 벽돌 갯수
    private Timer timer; // thread대신 사용한 Timer 객체
    private int delay = 8; // repaint() 되는데 걸리는 시간
    private int playerX = 310; // 공튀기는 바의 위치(x좌표)
    private int ballPosX = 120; // 공위치(x좌표)
    private int ballPosY = 350; // 공위치(y좌표)
    private int ballXDir = -1; // 볼이 반대방향으로 가게하기위해 -1줌
    private int ballYDir = -2; // 볼이 반대방향으로 가게하기위해 -2줌
    private MapGenerator map; // MapGenerator클래스의 맵 객체

    public GamePlay() {
        map = new MapGenerator(3, 7); // 3x7짜리 벽돌그리는 맵 생성
        addKeyListener(this);
        setFocusable(true); // 키가 포커싱되게 해줌.
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this); // delay시간만큼 반복해서 keyListener 실행됨.
        timer.start(); // 타이머 시작
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(1, 1, 692, 592); // 배경화면 흰색으로 설정
        map.draw((Graphics2D) g);
        g.setColor(Color.black);
        g.fillRect(0, 0, 3, 592); // 배경테두리 설정
        g.fillRect(0, 0, 692, 3); // 배경테두리 설정
        g.fillRect(691, 0, 3, 592); // 배경테두리 설정

        g.setColor(Color.black);
        g.setFont(new Font("serif", Font.BOLD, 25));
        g.drawString("" + score, 590, 30); // 스코어 점수

        g.setColor(Color.blue);
        g.fillRect(playerX, 550, 100, 8); // 공 던지기 바

        g.setColor(Color.green);
        g.fillOval(ballPosX, ballPosY, 20, 20); // 공

        if (ballPosY > 570) { // 볼 y좌표의 위치가 570을 넘으면 게임패배 판정
            play = false;
            ballXDir = 0;
            ballYDir = 0;
            g.setColor((Color.black));
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("게임 패배! 점수는 : " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("다시 시작하려면 엔터버튼 누르세요 ", 150, 340);

        }

        if (totalBricks == 0) { // 전체 벽돌 갯수가 0이면 게임승리 판정
            play = false;
            ballYDir = -2;
            ballXDir = -1;
            g.setColor(Color.black);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("게임 승리! 점수는 : " + score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("다시 시작하려면 엔터버튼 누르세요 ", 150, 340);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (play) {
            if (new Rectangle(ballPosX, ballPosY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ballYDir = -ballYDir; // 게임이 실행되면 공의 각끝점을 감싸는 직사각형과 공튀기는 바와의 겹치는 점이 있다면 y축의 반대방향으로 보내기

            }
            A: for (int i = 0; i < map.map.length; i++) { // 이중 루프를 빠져나오기 위해 A: 설정
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) { // 벽돌배열의 값이 각각 1인것은 깨지지 않는 벽돌임, 따라서 해당 벽돌과 공의 부딪힘을 튕기게 해주는 조건을 고려함.
                        int brickX = j * map.brickWidth + 80;
                        int brickY = i * map.brickHeight + 50;
                        int bricksWidth = map.brickWidth;
                        int bricksHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX, brickY, bricksWidth, bricksHeight);
                        Rectangle ballrect = new Rectangle(ballPosX, ballPosY, 20, 20);
                        Rectangle brickrect = rect;
                        if (ballrect.intersects(brickrect)) { // 벽돌을 감싸는 사각형과 공의 끝점을 감싸는 사각형의 겹치는 부분이 있는 것을 가정함
                            map.setBrickValue(0, i, j); // 겹친다고 할경우 벽돌배열의 해당 벽돌값을 0으로 만들어서 벽돌을 소멸시킴.
                            totalBricks--; // 벽돌갯수 감소시킴
                            score += 5; // 점수 5점씩 증가함.
                            if (ballPosX + 19 <= brickrect.x || ballPosX + 1 >= brickrect.x + bricksWidth) {
                                ballXDir = -ballXDir; // 벽돌과 공이 접하는 지점과 충돌이 일어날경우 좌표값 반대로 변경
                            } else {
                                ballYDir = -ballYDir;
                            }
                            break A; // 이중루프를 빠져나옴
                        }
                    }
                }
            }
            ballPosX += ballXDir; // 볼위치 변경
            ballPosY += ballYDir; // 볼위치 변경
            if (ballPosX < 0) { // 볼방향 변경
                ballXDir = -ballXDir;
            }
            if (ballPosY < 0) { //볼방향 변경
                ballYDir = -ballYDir;
            }
            if (ballPosX > 670) {// 볼방향 변경 
                ballXDir = -ballXDir;
            }

        }
        repaint(); //다시 그리게끔 paintComponent()메소드 호출 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // 키보드 오른쪽 누르면 움직임
            if (playerX >= 600) {
                playerX = 600;
            } else {
                moveRight();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) { // 키보드 왼쪽 누르면 움직임
            if (playerX < 10) {
                playerX = 10;
            } else {
                moveLeft();
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) { // 엔터치면 게임 초기화
            if (!play) {
                ballPosX = 120;
                ballPosY = 350;
                ballXDir = -1;
                ballYDir = -2;
                score = 0;
                playerX = 310;
                totalBricks = 21;
                map = new MapGenerator(3, 7);
                repaint();
            }
        }
    }

    public void moveRight() { // 오른쪽으로 20만큼 이동
        play = true;
        playerX += 20;
    }

    public void moveLeft() { // 왼쪽으로 20만큼 이동
        play = true;
        playerX -= 20;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
