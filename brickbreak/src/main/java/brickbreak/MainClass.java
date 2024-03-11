package brickbreak;

import javax.swing.JFrame;

public class MainClass {
    public static void main(String[] args) {

        JFrame frame = new JFrame(); // 화면 객체생성

        GamePlay gamePlay = new GamePlay();

        frame.setBounds(10, 10, 700, 600);
        frame.setTitle("벽돌깨기게임");
        frame.setResizable(false); // 사이즈 조정 못하게끔 함.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x누르면 프로세스 종료됨.
        frame.add(gamePlay);
        frame.setVisible(true); // 화면 보이게끔 해줌

        //게임설명
        //상하좌우 키보드 누르면 시작함.
        //죽으면 엔터누르면 다시시작함.
    }
}
