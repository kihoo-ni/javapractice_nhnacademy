package com.nhnacademy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LivelockExample livelock = new LivelockExample();
        new Thread(livelock::operation1, "T1").start();
   //     new Thread(new Runnable() { public void run() { livelock.operation1(); } }, "T1").start();
   //     new Thread(() -> livelock.operation1(), "T1").start();
        new Thread(livelock::operation2, "T2").start();
    }

    public void operation1() {
        while (true) {
            if (lock1.tryLock()) {
                System.out.println("lock1 acquired, trying to acquire lock2.");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (lock2.tryLock()) {
                    System.out.println("lock2 acquired.");
                    try {
                        System.out.println("executing first operation.");
                        break;
                    } finally {
                        lock2.unlock();
                    }
                } else {
                    System.out.println("cannot acquire lock2, releasing lock1.");
                    lock1.unlock();
                    continue;
                }
            }
        }
        lock1.unlock();
    }

    public void operation2() {
        while (true) {
            if (lock2.tryLock()) {
                System.out.println("lock2 acquired, trying to acquire lock1.");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (lock1.tryLock()) {
                    System.out.println("lock1 acquired.");
                    try {
                        System.out.println("executing second operation.");
                        break;
                    } finally {
                        lock1.unlock();
                    }
                } else {
                    System.out.println("cannot acquire lock1, releasing lock2.");
                    lock2.unlock();
                    continue;
                }
            }
        }
        lock2.unlock();
    }

}
