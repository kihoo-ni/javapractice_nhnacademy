package com.example.blockexam02;



class DataBox{
    int data;
    synchronized void inputData(int data){
        this.data=data;
        System.out.println("입력 데이터 : "+data);
    }
    synchronized void outputData(){
        System.out.println("출력 데이터 : "+data);
    }
}

public class blockexam02 {
    public static void main(String[] args) {
        DataBox dataBox= new DataBox();
        Thread t1= new Thread(){
            @Override
            public void run (){
                for(int i=0; i<9; i++){
                    dataBox.inputData(i);
                }
            }
        };
        Thread t2= new Thread(){
            @Override
            public void run (){
                for(int i=0; i<9; i++){
                    dataBox.outputData();
                }
            }
        };
        t1.start();
        t2.start();
    }  

}