package de.upb.threadpuzzlers;

public class IncrementPuzzle {

    private static int counter = 0;

    private static final int MAX = 5000;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                counter++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < MAX; i++) {
                counter++;
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter);
    }
}
