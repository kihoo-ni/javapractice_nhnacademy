package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.lang.Thread;

public class Producer implements Runnable {
    Mart mart;
    Logger logger;

    public Producer(Mart mart) {
        this.mart = mart;
        logger = LogManager.getFormatterLogger(Producer.class);
        Configurator.setLevel(Producer.class.getName(), org.apache.logging.log4j.Level.TRACE);
    }

    @Override
    public void run() {
        System.out.println("생산자 입장");
        while (Thread.currentThread().isAlive()) {
            long now_time = System.currentTimeMillis();
            int num = ThreadLocalRandom.current().nextInt(mart.stucks.length);
            boolean fullwait = true;
            while (System.currentTimeMillis() - now_time < 10000) {// 10초가 경과하지 않을때 동안 계속확인
                if (mart.stucks[num].nownum < mart.stucks[num].maxnum) {// 빈공간이 있다!
                    try {
                        mart.semaphores[num].acquire();
                        mart.accept(num);// 상점에 방문해서 팔고온다.
                        mart.semaphores[num].release();
                        fullwait = false;
                        break;
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
            if (fullwait) {
                logger.warn("판매자 10초 기다린 후 포기함.");
            }
            logger.trace("판매자가 퇴장함.");
            break;
        }
    }
}
