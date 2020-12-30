package com.jokinglove.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印 0 - 100
 *
 * @author <a href="mailto:jokinglove@foxmail.com">JOKING</a>
 * @since 1.0.0
 */
public class ThreeThreadPrintNumberByLock {

    static volatile AtomicInteger cnt = new AtomicInteger(0);

    public static void main(String[] args) {

        final Lock lock = new ReentrantLock();

        for (int i = 0; i < 3; i++) {
            new Thread(new PrintThread(i, lock)).start();
        }
    }

    static class PrintThread implements Runnable {

        private final int i;

        private final Lock lock;

        public PrintThread(int i, Lock lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (cnt.get() > 100) {
                    break;
                }
                if (cnt.get() % 3 == i) {
                    System.out.println("线程 " + i + ":" + cnt.getAndIncrement());
                }
                lock.unlock();
            }
        }
    }
}
