package org.task.one;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class demonstrates how to print numbers every second and a message every five seconds using threads.
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 30.09.2023
 */
public class TaskOne {
    public static void main(String[] args) {
        printEverySecond();
        printEveryFiveSecond();
    }

    /**
     * Prints a message every five seconds.
     */
    private static void printEveryFiveSecond() {
        Thread one = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Five seconds have passed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        one.start();
    }

    /**
     * Prints numbers every second.
     */
    private static void printEverySecond() {
        AtomicInteger i = new AtomicInteger();
        Thread one = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println(i.incrementAndGet());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        one.start();
    }
}
