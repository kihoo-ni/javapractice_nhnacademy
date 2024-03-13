package com.nhnacademy.con_pro;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 10000)); // 1초 ~ 10초 사이 대기
                store.sell(); // 물건 납품
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

