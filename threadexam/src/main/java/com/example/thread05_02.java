package com.example;

//공유객체
class MyData {
    int data = 3;

    public synchronized void plusData() {
        int myData = data;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
        }
        this.data = myData + 1;

    }
}

// 공유객체를 사용하는 스레드
class PlusThread extends Thread {
    MyData myData;

    public PlusThread(MyData myData) {
        this.myData = myData;
    }

    @Override
    public void run() {
        this.myData.plusData();
        System.out.println(getName() + "실행결과 : " + myData.data);
    }
}

public class thread05_02 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        Thread plusThread1 = new PlusThread(myData);
        plusThread1.setName("PlusThread");
        plusThread1.start();

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }

        Thread plusThread2= new PlusThread(myData);
        plusThread2.setName("PlusThread2");
        plusThread2.start();

    }
}
