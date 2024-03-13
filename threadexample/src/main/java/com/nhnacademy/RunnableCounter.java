package com.nhnacademy;

import java.time.LocalTime;

public class RunnableCounter implements Runnable {
    String name = "counter";
    int maxCount = 10;
    int start = 0;
    int count=0;
    Thread thread;
    

    public RunnableCounter(String name, int maxCount) {
        this.name = name;
        this.maxCount = maxCount;
        this.count=0;
    }

    public RunnableCounter(ThreadGroup group, String name, int maxCount) {
        thread = new Thread(group, this, name);
        this.maxCount = maxCount;
    }
    

    public int getCount(){
        return count;
    }
    
    public void run() {
        while (!Thread.currentThread().isInterrupted() && start < maxCount) {
            try {
                Thread.sleep(1000);
                count++;
                System.out.println(name + " : " + count);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                
            }
        }
    }

    public static void main(String[] args) {
        RunnableCounter r = new RunnableCounter("counter", 10);
        RunnableCounter r1 = new RunnableCounter("counter1", 10);

        Thread runnableCounter = new Thread(r);
        Thread runnableCounter1 = new Thread(r1);
        System.out.println("start : " + LocalTime.now());
        runnableCounter.start();
        runnableCounter1.start();
        while ((runnableCounter.isAlive() || runnableCounter1.isAlive())) {
            if((r.getCount()>=5)&&(r1.getCount()>=5)){
                runnableCounter.interrupt();
                runnableCounter1.interrupt();
            }
        }
        System.out.println("end : " + LocalTime.now());
    }
}
