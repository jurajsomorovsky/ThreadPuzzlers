package de.upb.threadpuzzlers;

import java.util.concurrent.atomic.AtomicInteger;

public class IncrementPuzzleSolution2 {

    private static AtomicInteger counter = new AtomicInteger(0);

    private static final int MAX = 5000;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                counter.getAndIncrement();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                counter.getAndIncrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
