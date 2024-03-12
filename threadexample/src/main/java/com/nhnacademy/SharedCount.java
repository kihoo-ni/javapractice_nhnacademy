package com.nhnacademy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedCount {
    //Lock lock= new ReentrantLock();
    int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public synchronized void increment() { // synchronized 넣어도됨.
        //lock.lock();
      
          setCount(getCount() + 1);
      
      
        //lock.unlock();
    }

}
