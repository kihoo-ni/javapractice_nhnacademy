package com.nhnacademy;

public class SelfRunnableCounter implements Runnable {
    int count;
    int maxCount;
    Thread thread;

    public SelfRunnableCounter(String name, int maxCount) {
        this.maxCount = maxCount;
        count = 0;
        thread = new Thread(this, name);
    }

    public void start() {
        thread.start();
    }

    public int getCount(){
        return count;
    }
    
    @Override
    public void run() {
        while (count < maxCount) {
            try {
                ++count;    
                System.out.println(thread.getName() + " : " + count);
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        SelfRunnableCounter src=new SelfRunnableCounter("test", 10);
        src.start();
      

    }
}
