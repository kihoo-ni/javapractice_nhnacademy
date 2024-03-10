package com.example;

//쓰레드 객체가져오기, 이름 설정, 쓰레드 수 가져오기
public class thread03_01 {
    public static void main(String[] args) {
        // 1. 객체가져오기
        Thread th1 = Thread.currentThread(); // 메인스레드는 내가만든것이 아니라서 현재스레드 가져오기

        System.out.println("스레드 이름 : " + th1.getName());
        System.out.println("동작하는 스레드 수 : " + th1.activeCount());

        // 2. 스레드 이름 자동지정
        for (int i = 0; i < 3; i++) {
            Thread th2 = new Thread();
            System.out.println(th2.getName());
            th2.start();
        }

        // 3. 스레드 이름 직접 지정
        for (int i = 0; i < 3; i++) {
            Thread th2  = new Thread();
            th2.setName(i + "번째 스레드");
            System.out.println(th2.getName());
            th2.start(); 
        }

        // 4. 스레드 이름 자동지정
        for (int i = 0; i < 3; i++) {
            Thread th2 = new Thread();
            System.out.println(th2.getName());
            th2.start();
        }

        //5 스레드 수 출력
        System.out.println("동작하는 스레드 수 : "+Thread.activeCount());
    }
}
