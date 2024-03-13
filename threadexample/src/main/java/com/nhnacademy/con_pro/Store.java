package com.nhnacademy.con_pro;

import java.util.LinkedList;
import java.util.Queue;

public class Store {
    private final int MAX_ITEMS = 10;
    private final int MAX_CUSTOMERS = 5;
    private Queue<Object>items;
    private int customerCount;

    public Store() {
        items = new LinkedList<>();
        customerCount = 0;
    }

    public synchronized void enter() throws InterruptedException {
        while (customerCount >= MAX_CUSTOMERS) {
            System.out.println("매장 정원 초과!");
            System.out.println("while: "+customerCount);
            wait();
        }
        System.out.println("손님 입장!");
        System.out.println("while 밖: " +customerCount);
        customerCount++;
    }

    public synchronized void exit() {
        customerCount--;
        System.out.println("손님 퇴장!");
        System.out.println("exit: "+customerCount);
        notifyAll(); // 소비자 퇴장 시 대기 중인 소비자에게 알림
    }

    public synchronized void buy() throws InterruptedException {
        while (items.isEmpty()) {
            System.out.println("재고 소진!");
            System.out.println("items empty " +items.size());
            wait();
        }
        items.poll();
        System.out.println("items poll " +items.size());
        notifyAll(); // 물건을 구매한 후 대기 중인 생산자에게 알림
    }
    
    public synchronized void sell() throws InterruptedException {
        while (items.size() >= MAX_ITEMS) {
            System.out.println("재고가 충분하여 입고 중단!");
            wait();
            System.out.println("items max " +items.size());
        }
        items.add(new Object());
        System.out.println("입고!");
        System.out.println("items add " +items.size());
        notifyAll(); // 물건을 판매한 후 대기 중인 소비자에게 알림
    }
}
