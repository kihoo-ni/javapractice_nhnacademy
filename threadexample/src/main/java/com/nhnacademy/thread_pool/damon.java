package com.nhnacademy.thread_pool;

import com.nhnacademy.thread_pool.RunnableCounter;

public class damon {
        public static void main(String[] args) throws InterruptedException {
            RunnableCounter counter1 = new RunnableCounter("counter1", 100);
            RunnableCounter counter2 = new RunnableCounter("counter2", 100);
    
            // counter2.thread.setDaemon(true);
    
            counter1.start();
            counter2.start();
    
            Thread.sleep(5000);
            counter1.stop();
    
            System.out.println("Main Thread terminated");
        }
    }
