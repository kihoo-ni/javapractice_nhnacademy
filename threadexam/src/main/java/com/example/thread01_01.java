package com.example;
//스레드 상속하는 방식으로 구현!  상속해서 한번에 해결하거나 두개의 쓰레드로 해결하는 방법 두가지를 구현해보기

public class thread01_01 {
    
    public static void main(String[] args) {
        //숫자번호 (먼저나오게)
        int[] array={1,2,3,4,5};

        StrThread th1=new StrThread();
        th1.start();
           
        for(int  i=0; i<array.length; i++){
            System.out.println("숫자번호 : "+array[i]);
            try {
             Thread.sleep(200);   
            } catch (Exception e) {
            }
        }
        
    }
} 


class StrThread extends Thread{
    @Override
    public void run(){
        
        //한글번호 (나중에 나오게)
        String[] arrStrings={"하나","둘","셋","넷","다섯"};
        try {
            Thread.sleep(100);
        } catch (Exception e) {
        }
        
        
        for(int  i=0; i<arrStrings.length; i++){
            System.out.println("한글번호 : "+arrStrings[i]);
            try {
             Thread.sleep(200);   
            } catch (Exception e) {
            }
        }
    }
}