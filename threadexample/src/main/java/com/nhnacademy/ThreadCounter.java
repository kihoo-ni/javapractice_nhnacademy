package com.nhnacademy;

import java.time.LocalTime;

public class ThreadCounter extends Thread {
    String name = "counter";
    int maxCount = 10;
    int start = 0;

    public ThreadCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
    }

    @Override
    public void run() {
        for (int i = start; i < maxCount; i++) {
            try {

                Thread.sleep(1000);
                System.out.println(name + " : " + i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        ThreadCounter counter = new ThreadCounter("counter", 10);
        ThreadCounter counter1 = new ThreadCounter("counter1", 10);
        System.out.println("start : " + LocalTime.now());
        counter.start();
        counter1.start();
        while(counter.isAlive() || counter1.isAlive())
            ;
        
        System.out.println("end : " + LocalTime.now());
    }
}
