package com.nhnacademy;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.Thread;

public class Main {
    static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);// 스캐너 만든다.
        System.out.print("가게의 품목 개수 입력 : ");
        int menu = scanner.nextInt();// 품목 개수 입력

        Mart mart = new Mart(menu);
        System.out.printf("%d개의 품목을 가진 상점을 만들었습니다.\n", menu);
        for (int i = 0; i < menu; i++) {
            System.out.printf("%d번째 품목의 종류를 입력해주세요.\n", i + 1);
            String s = scanner.next();
            System.out.printf("%s의 최대 납품 개수", s);
            int maxnum = scanner.nextInt();
            mart.setMart(i, s, maxnum);
        } // 각 품목의 이름과 최대 개수를 입력해서 마트에 넣는다.

        System.out.print("최대 몇명 입장 가능한가요?");
        int a = scanner.nextInt();
        ExecutorService executor = Executors.newFixedThreadPool(a);
        // threadpool세팅해서 최대 입장을 만든다. 여기에 thread들 들어간다.
        System.out.print("손님은 총 몇명인가요?");
        int consumernum = scanner.nextInt();
        // 손님의 명수 입력
        System.out.print("생산자는 총 몇명인가요?");
        int producenum = scanner.nextInt();
        // 생산자는 총 몇명?

        scanner.close();// 스캐너 닫는다.
        for (int j = 0; j < producenum; j++) {
            executor.submit(new Producer(mart));
        }
        for (int i = 0; i < consumernum; i++) {
            executor.submit(new Consumer(mart));
        }

        // threadpool에 생산자와 소비자를 넣는다.

        try {
            Thread.sleep(5 * 60 * 1000);
            executor.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } // 5분간 오픈
    }
}