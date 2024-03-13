package com.nhnacademy.con_pro;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Thread producerThread = new Thread(producer);
        producerThread.start();

        for (int i = 1; i <= 20; i++) {
            Consumer consumer = new Consumer("Consumer-" + i, store);
            Thread consumerThread = new Thread(consumer);
            consumerThread.start();
        }
    }
}
