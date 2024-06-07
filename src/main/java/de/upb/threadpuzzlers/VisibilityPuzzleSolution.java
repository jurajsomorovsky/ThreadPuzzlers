package de.upb.threadpuzzlers;

public class VisibilityPuzzleSolution {

    private static volatile boolean stop = false;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread started");
            while (!stop) {
                // busy-wait
            }
            System.out.println("Thread stopped");
        });

        t1.start();

        Thread.sleep(1000);

        stop = true;
    }
}

/**
 * Solution: The thread t1 might not stop because of visibility issues. Without
 * proper synchronization, changes to the stop variable made by one thread might
 * not be visible to another thread. Declaring stop as volatile would solve this
 * problem. *
 */
