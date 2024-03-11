package brickbreak;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;


public class MapGenerator {
    public int map[][];

    public int brickWidth;
    public int brickHeight;

    //블록 생성하는 메소드
    public MapGenerator(int row, int col){
        map=new int[row][col];
        for(int []map1:map){
            for(int j=0; j<map[0].length; j++){
                map1[j]=1; // map 2차원 배열에 블록이 있는지 없는지 체크하기위해 초기값 1로 설정
            }
        }
        brickWidth=540/col; // 블록 너비 설정
        brickHeight=150/row; // 블록 높이 설정

    }

    public void draw(Graphics2D g){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j]>0){
                    g.setColor(Color.gray);
                    g.fillRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight);// 블록회색으로 그리기 
                    g.setStroke(new BasicStroke(3)); //블록 구분 선 
                    g.setColor(Color.BLACK);
                    g.drawRect(j*brickWidth+80, i*brickHeight+50, brickWidth, brickHeight); // 검정색 네모선 그리기 
                }
            }
        }
    }

    public void setBrickValue(int value, int row, int col){
        map[row][col]=value; // 벽돌이 깨진지 안깨진지 구분하기 위한 메소드 
    }
}
