package com.nhnacademy;

import java.util.concurrent.Semaphore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Mart {
    Stuck[] stucks;
    Semaphore[] semaphores;

    public Mart(int num) {
        stucks = new Stuck[num];
        semaphores = new Semaphore[num];
    }

    public void setMart(int number, String name, int max) {
        stucks[number] = new Stuck(name, max);
        stucks[number].nownum = 0;
        semaphores[number] = new Semaphore(1);
    }

    public void accept(int index) {
        stucks[index].nownum++;
        System.out.printf("%s 납품, %d / %d\n", stucks[index].name, stucks[index].nownum, stucks[index].maxnum);
    }// 물건을 납품 받는다.

    public void sell(int index) {
        stucks[index].nownum--;
        System.out.printf("%s 판매, %d / %d\n", stucks[index].name, stucks[index].nownum, stucks[index].maxnum);
    }// 물건을 판다.
}
// 납품한후 어떤걸 팔았는지 알려준다.