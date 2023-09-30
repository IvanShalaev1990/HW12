package org.task.two;

import java.util.ArrayList;
import java.util.List;

/**
 * this class displays numbers to the console and if the number is divisible by three it displays "Fizz"
 * if by five then it displays "Buzz", and if it is divisible by three and five then it displays "FizzBuzz".
 *
 * @author Shalaiev Ivan.
 * @version 1.0.0 30.09.2023
 */
public class Processor {
    private static final int LIST_CAPACITY = 10;
    private static final int CONSUMER_DELAY_MS = 2000;

    private List<Integer> listOfInteger = new ArrayList<>();
    private Object lock = new Object();

    /**
     * Add to @listOfInteger an elements.
     */
    public void producer() {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (listOfInteger.size() == LIST_CAPACITY) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                listOfInteger.add(value++);
                lock.notifyAll();
            }

        }
    }

    /**
     * Remove from @listOfInteger an element and displays to the console it.
     */
    public void consumer() {
        while (true) {
            synchronized (lock) {
                while (listOfInteger.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (listOfInteger.get(0) % 3 != 0 && listOfInteger.get(0) % 5 != 0) {
                    int value = listOfInteger.remove(0);
                    System.out.println("removed value is: " + value);
                    lock.notifyAll();
                }
            }
            try {
                Thread.sleep(CONSUMER_DELAY_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Remove from @listOfInteger an element and displays to the console "FizzBuzz".
     */
    public void consumerFizzBuzz() {
        while (true) {

            synchronized (lock) {
                while (listOfInteger.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (listOfInteger.get(0) % 3 == 0 && listOfInteger.get(0) % 5 == 0) {
                    listOfInteger.remove(0);
                    System.out.println("removed value is: " + "FizzBuzz");
                    lock.notifyAll();
                }
            }
            try {
                Thread.sleep(CONSUMER_DELAY_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Remove from @listOfInteger an element and displays to the console "Fizz".
     */
    public void consumerFizz() {
        while (true) {

            synchronized (lock) {
                while (listOfInteger.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (listOfInteger.get(0) % 3 == 0 && listOfInteger.get(0) % 5 != 0) {
                    listOfInteger.remove(0);
                    System.out.println("removed value is: " + "Fizz");
                    lock.notifyAll();
                }
            }
            try {
                Thread.sleep(CONSUMER_DELAY_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Remove from @listOfInteger an element and displays to the console "Buzz".
     */
    public void consumerBuzz() {
        while (true) {
            synchronized (lock) {
                while (listOfInteger.isEmpty()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (listOfInteger.get(0) % 3 != 0 && listOfInteger.get(0) % 5 == 0) {
                    listOfInteger.remove(0);
                    System.out.println("removed value is: " + "Buzz");
                    lock.notifyAll();
                }
            }
            try {
                Thread.sleep(CONSUMER_DELAY_MS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
