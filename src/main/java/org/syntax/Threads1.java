package org.syntax;

/**
 * Threads allows a program to operate more efficiently by doing multiple things at the same time.
 * Threads can be used to perform complicated tasks in the background without interrupting the main program.
 * 2 ways of creating a thread and main differences of these 2 ways:
 * 1) By extending the Thread class and overriding its run() method
 *    - You cannot extend any other class, because you are already extending class Thread
 *    - The thread can be run by creating an instance of the class and call its start()
 *    - We can wait for a thread to end by calling join() method
 * 2) By implementing the Runnable interface
 *    - It is possible to extend from another class
 *    - The thread can be run by passing an instance of the class to a Thread object's constructor
 *      and then calling the thread's start() method.
 *    - We can check if a thread already ended by calling isAlive() method
 *
 * In this class, we will be implementing option 1. For implementation of option 2, @see class {@link Threads2}
 */
public class Threads1 extends Thread {

    public static int sharedVariable = 0;

    public static void main(String[] args) throws InterruptedException {
        /*
        If the class extends the Thread class, the thread can be run by creating an instance of the class
        and call its start() method
         */
        Threads1 object = new Threads1();
        object.start();     //start a separate thread in which we will be incrementing variable

        System.out.println("This code is outside of the thread");

        //Waiting for thread to end: we call join() method
        object.join();

        //Thread is already ended, so we can print variable that was incremented in thread
        System.out.println("Value of sharedVariable that was incremented inside a thread: " + sharedVariable);
    }

    /**
     * Thread will print output and increment static variable 1000 times
     */
    @Override
    public void run() {
        System.out.println("This code is running in a thread");
        for (int i = 0; i < 1000; i++) {
            sharedVariable++;
        }
    }
}
