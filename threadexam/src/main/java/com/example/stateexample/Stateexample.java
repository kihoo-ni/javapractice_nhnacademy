package com.example.stateexample;

public class Stateexample {
    public static void main(String[] args) {
        // 스레드 상태저장
        Thread.State state;

        // 객체생성
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100000000L; i++) {
                    // 시간지연
                }
            }
        };

        state=thread.getState();
        System.out.println("스레드 상태: "+state);

        // 스레드 시작
        thread.start();
        state=thread.getState();
        System.out.println("스레드 상태: "+state);
        
        //스레드 종료
        try{
            thread.join();
        } catch(InterruptedException e){
            
        }
        state=thread.getState();
        System.out.println("스레드 상태: "+state);
    }
}
