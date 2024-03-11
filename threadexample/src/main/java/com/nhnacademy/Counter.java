package com.nhnacademy;

import java.time.LocalTime;

public class Counter {
    String name = "counter";
    int maxCount = 10;
    int start=0;

    public Counter(String name, int maxCount) {
        this.name=name;
        this.maxCount=maxCount;
    }


    public void run() {
        for(int i=start; i<maxCount; i++){
            try{

                Thread.sleep(1000);
                System.out.println(name+" : "+i);
            } catch(InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        Counter counter=new Counter("counter", 10);
        Counter counter1=new Counter("counter1", 10);
        System.out.println("start : "+LocalTime.now());
        counter.run();
        counter1.run();
        System.out.println("end : "+LocalTime.now());
    }
}
