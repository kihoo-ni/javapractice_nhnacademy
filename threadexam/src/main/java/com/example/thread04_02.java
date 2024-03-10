package com.example;

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println(getName() + ":" + (isDaemon() ? "데몬스레드" : "일반스레드"));
        for (int i = 0; i < 6; i++) {
            System.out.println(getName() + ":" + i + "초 ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }

}

public class thread04_02 {
    public static void main(String[] args) {

        //일반 스레드
        Thread th1 = new MyThread1();
        th1.setDaemon(false);
        th1.setName("th1");
        th1.start();

        //데몬스레드 
        Thread th2 = new MyThread1();
        th2.setDaemon(true);
        th2.setName("th2");
        th2.start();
        
        // 3초후 메인스레드 종료
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }
        System.out.println("main 스레드 종료");
    }

}
