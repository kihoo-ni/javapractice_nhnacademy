package com.nhnacademy;

public class SemaphoreTest {

    public static void main(String[] args) {
        Semaphores semaphores = new Semaphores(2);
        Thread thread1 = new Thread(new Semaphoreusing(semaphores, 5), "Thread-1");
        Thread thread2 = new Thread(new Semaphoreusing(semaphores, 10), "Thread-2");
        thread1.start();
        thread2.start();
    }
}

class Semaphoreusing implements Runnable {
    private Semaphores semaphores;
    private int count;
    private int nowcount;

    public Semaphoreusing(Semaphores s, int count) {
        this.semaphores = s;
        this.count = count;
        this.nowcount = 0;
    }

    @Override
    public void run() {
        while (nowcount < count) {
            try {
                System.out.println("0번째: "+Thread.currentThread().getName() + " now : " + nowcount+", permits : "+semaphores.getPermits());
                semaphores.acquire();
                System.out.println("1번째:  "+Thread.currentThread().getName() + " now : " + nowcount+", permits : "+semaphores.getPermits());
                nowcount++;
                System.out.println("2번째: "+Thread.currentThread().getName() + " now : " + nowcount+", permits : "+semaphores.getPermits());
                semaphores.release();
                System.out.println("3번째: "+Thread.currentThread().getName() + " now : " + nowcount+", permits : "+semaphores.getPermits());
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // 인터럽트 상태 재설정
                System.err.println(Thread.currentThread().getName() + " interrupted");
            }
        }
    }
}
