package com.nhnacademy;

import javax.swing.JOptionPane;

public class Interruptexam {
    public static void main(String[] args) throws Exception {
        Interruptexam1 th1 = new Interruptexam1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
        th1.interrupt(); // interrupt()를 호출하면, interrupted상태가 true가 된다.
        System.out.println("isInterrupted():" + th1.isInterrupted());
    }
}

class Interruptexam1 extends Thread {
	public void run() {
		int i = 10;

		

			try {
                while(i!=0 && !isInterrupted()) {
                    System.out.println(i--);
                for(long k=0; k<10000000000L; k++){

                }
                }
				Thread.sleep(1000);  // 1초 지연
			} catch(InterruptedException e) {}
            System.out.println("카운트가 종료되었습니다.");
		}

	} // main
