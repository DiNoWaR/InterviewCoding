package com.denis.interview.multithreading.blockingqueue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueEx {

    public static void main(String[] args) throws Exception {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1, true);

        for (int i = 5; i >= 1; i--) {
            Thread.sleep(100);
            new Thread(new MyThread(i, queue)).start();
        }
        queue.add(1);
    }

}
