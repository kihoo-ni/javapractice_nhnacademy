package com.example.blockexam01;

class MyBlockTest{
    //공유객체
    MyClass mc= new MyClass();

    //세개의 스레드 필드생성
    Thread t1= new Thread("thread1"){
        @Override
        public void run(){
            mc.syncMehtod();
        }
    };
    
    
    Thread t2= new Thread("thread1"){
        @Override
        public void run(){
            mc.syncMehtod();
        }
    };
    
    
    Thread t3= new Thread("thread1"){
        @Override
        public void run(){
            mc.syncMehtod();
        }
    };
    
    
    void startAll(){
        t1.start();
        t2.start();
        t3.start();
    }

    class MyClass{
        synchronized void syncMehtod(){
            try{ Thread.sleep(100);} catch(InterruptedException e){}
            System.out.println("--"+Thread.currentThread().getName()+"--");
            System.out.println("thread1 : "+ t1.getState());
            System.out.println("thread2 : "+ t2.getState());
            System.out.println("thread3 : "+ t3.getState());
            for (int i = 0; i < 100000000L; i++) {
                // 시간지연
        } 
        }
    }
}

public class blockexam01 {
    public static void main(String[] args) {
        MyBlockTest my=new MyBlockTest();
        my.startAll();
    }   
}
