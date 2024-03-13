package com.nhnacademy.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker implements Runnable {
    String name;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void run() {
        System.out.println(getName() + " Thread start");
        try {
            Thread.sleep(1999);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getName() + " Thread finish");
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executor.submit(new Worker("Worker" + i));
        }
        // 모든 작업이 완료될 때까지 대기
        executor.shutdown(); //작업완료할경우 executor종료  
        while (!executor.isTerminated()) {
        }

        System.out.println("모든 작업이 완료되었습니다.");

    }
}
