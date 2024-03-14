package com.nhnacademy;

import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

public class Consumer implements Runnable {
    Mart mart;
    Logger logger;

    public Consumer(Mart mart) {
        this.mart = mart;
        this.logger = LogManager.getLogger(Consumer.class);
        Configurator.setLevel(Consumer.class.getName(), org.apache.logging.log4j.Level.TRACE);
    }

    @Override
    public void run() {
        while (Thread.currentThread().isAlive()) {
            logger.trace("소비자가 입장함.");
            long now_time = System.currentTimeMillis();
            int num = ThreadLocalRandom.current().nextInt(mart.stucks.length);
            boolean fullwait = true;
            while (System.currentTimeMillis() - now_time < 10000) {
                if (mart.stucks[num].nownum >= 1) {
                    try {
                        mart.semaphores[num].acquire();
                        mart.sell(num);
                        mart.semaphores[num].release();
                        fullwait = false;
                        break;
                    } catch (InterruptedException e) {
                        e.getStackTrace();
                    }
                }
            }
            if (fullwait) {
                logger.warn("소비자가 10초 기다린 후 포기함.");
            }
            logger.trace("소비자가 퇴장함.");
            break;
        }
    }
}
