package com.example.stateexample03;

class MyThread extends Thread {
    @Override
    public void run() {
            for (int i = 0; i < 100000000L; i++) {
                // 시간지연
        }

    }
}

class MyThread1 extends Thread{
    MyThread myThread;
    public MyThread1(MyThread myThread){
        this.myThread=myThread;

    }

    @Override
    public void run(){
         try {
            myThread.join(3000);
        } catch (InterruptedException e) {
            System.out.println("join 중 inerrupt 발생 ");

            for (int i = 0; i < 100000000L; i++) {
                // 시간지연
        } 
        }
    }
}

public class Stateexample03 {
    public static void main(String[] args) {
      MyThread myThread=new MyThread();

      MyThread1 myThread1=new MyThread1(myThread);
      myThread.start();
      myThread1.start();
      

      try{ Thread.sleep(1000);} catch(InterruptedException e){}
      System.out.println("스레드 상태 : "+myThread.getState());
      System.out.println("스레드 상태 : "+myThread1.getState());
      
      myThread1.interrupt();
      System.out.println("스레드 상태 : "+myThread.getState());
      System.out.println("스레드 상태 : "+myThread1.getState());
      
    }
}
