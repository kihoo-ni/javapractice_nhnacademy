package com.example.stateexample02;

class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("interupt 발생");
            for (int i = 0; i < 100000000L; i++) {
                // 시간지연
            }
        }

    }
}

public class Stateexample02 {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
        
        try{ Thread.sleep(100);} catch(InterruptedException e){}
        System.out.println("스레드 상태 : "+myThread.getState());
        
        myThread.interrupt();
        try{ Thread.sleep(100);} catch(InterruptedException e){}
        
        System.out.println("스레드 상태 : "+myThread.getState());

    }
}
