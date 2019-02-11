package com.denis.interview.multithreading.blockingqueue;

import java.util.concurrent.BlockingQueue;


public class MyThread implements Runnable {

    private int value;
    private BlockingQueue<Integer> queue;


    public MyThread(int value, BlockingQueue<Integer> queue) {
        this.value = value;
        this.queue = queue;
    }


    @Override
    public void run() {

        System.out.println("Task " + value + " is now pending...");

        try {
            while (true) {
                int task = queue.take();

                if (task != value) {
                    System.out.println("Task " + value + " got task " + task + " instead -re queing");
                    queue.add(task);
                } else {
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
        System.out.println("Finished task " + value);

        System.out.println("Registering task " + (value + 1) + " to run next");
        queue.add(value + 1);
    }
}
