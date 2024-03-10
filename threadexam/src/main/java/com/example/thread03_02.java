package com.example;

//우선순위

class MyThread extends Thread{
    @Override
    public void run(){
        for(long i=0; i<100000000; i++){
            //시간 지연용 
        }

        System.out.println(getName()+"우선순위 : "+getPriority());
    }
}

public class thread03_02 {
    public static void main(String[] args) {
        //cpu core
        System.out.println("코어수 : "+Runtime.getRuntime().availableProcessors());


        //1.디폴트 우선순위
        for(int i=0; i<3; i++){
            Thread  thread= new MyThread();
             thread.start();
        }

        //2. 우선순위지정
        for(int i=0; i<10; i++){
            Thread  thread= new MyThread();
             thread.setName(i+"번째 스레드");
             if(i==7)thread.setPriority(10);
             thread.start();
             }
    }
}