package com.nhnacademy.semaphore;

import java.util.concurrent.Semaphore;

class ShareResource {
    private final Semaphore semaphore;
    private final int MAX_PERMIT_CNT;

    public ShareResource(int cnt) {
        this.semaphore = new Semaphore(cnt);
        this.MAX_PERMIT_CNT = cnt;
    }

    public void use() throws InterruptedException {
        semaphore.acquire(); // 세마포어 리소스 확보
        System.out.println("acquire");
        try {
            doUse();
        } finally {
            semaphore.release(); // 세마포어 리소스 해제
        }
    }

    protected void doUse() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("douse");
        System.out.println(Thread.currentThread().getName() + " / Finish Time : " + System.currentTimeMillis() + " / available resource count = " + (MAX_PERMIT_CNT - semaphore.availablePermits()));
    }
}

class UserThread extends Thread {
    private final ShareResource resource;

    public UserThread(ShareResource resource) {
        this.resource = resource;
    }

    public void run() {
        try {
            while (true) {
                resource.use();
                System.out.println(Thread.currentThread().getName()+" : run");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {}
    }
}

public class semaphore {
    public static void main(String[] args) {
        ShareResource resource = new ShareResource(3);
        // 10개의 쓰레드가 실행되지만 동시에 리소스에 접근 할 수 있는 쓰레드는 총 3개
        for (int i = 0;i < 10; i++) {
            new UserThread(resource).start();
        }
    }
}
