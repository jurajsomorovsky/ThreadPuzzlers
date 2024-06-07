package de.upb.threadpuzzlers;

public class IncrementPuzzleSolution1 {

    private static int counter = 0;

    private static final int MAX = 5000;

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                synchronized (lock) {
                    counter++;
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}

/**
 * Solution: The expected output should be 10000, but due to the lack of
 * synchronization, the actual output will be unpredictable and typically less
 * than 10000. This happens because the counter++ operation is not atomic. It
 * involves reading the current value, incrementing it, and writing it back,
 * which can be interleaved between threads. *
 */
