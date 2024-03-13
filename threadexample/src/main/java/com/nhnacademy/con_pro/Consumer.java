package com.nhnacademy.con_pro;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer implements Runnable {
    private String name;
    private Store store;

    public Consumer(String name, Store store) {
        this.name = name;
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true) {
                store.enter(); // 매장 입장
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000)); // 1초 ~ 10초 사이 대기
                store.buy(); // 물건 구매
                store.exit(); // 매장 퇴장 
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

