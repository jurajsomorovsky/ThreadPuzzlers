package de.upb.threadpuzzlers;

public class VisibilityPuzzle {
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