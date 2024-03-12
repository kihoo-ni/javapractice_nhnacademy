package com.nhnacademy;

public class Exam1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            long count = 0;
            System.out.println("threadname : "+Thread.currentThread().getName());
            while (count < 10000000) {
                count++;
                try {
                    System.out.println("threadname1 : "+Thread.currentThread().getName());
                    System.out.println("threadstae : "+Thread.currentThread().getState());
                    Thread.sleep(1000);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        System.out.println("threadstate: " + thread.getState());
        System.out.println("threadname: "+thread.getName());
        System.out.println("main1-1: " + Thread.currentThread().getState());
        System.out.println("main1-1: " + Thread.currentThread().getName());


        thread.start();

        while (thread.isAlive()) {
            System.out.println("main2 : " + Thread.currentThread().getState());
            System.out.println("main3 : " + Thread.currentThread().getName());
            Thread.sleep(500);
        }
        System.out.println("main4: " + thread.getState());

    }
}
