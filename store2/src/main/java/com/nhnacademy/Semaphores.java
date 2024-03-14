package com.nhnacademy;

public class Semaphores {
    private int permits;

    public int getPermits(){
        return permits;
    }
    public Semaphores(int permits) {
        if (permits < 0) {
            throw new IllegalArgumentException("Permits must be non-negative");
        }
        this.permits = permits;
    }

    public synchronized void acquire() throws InterruptedException {
        while (permits == 0) {
            wait(); // 스레드가 허가를 기다립니다.
        }
        permits--; // 허가를 획득합니다.
    }

    public synchronized void release() throws InterruptedException {
        permits++; // 허가를 반환합니다.
        notify(); // 대기중인 스레드를 깨웁니다.
    }
}
