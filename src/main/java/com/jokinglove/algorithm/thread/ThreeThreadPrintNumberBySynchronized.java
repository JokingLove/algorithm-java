package com.jokinglove.algorithm.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 三个线程交替打印 0 - 100
 *
 * @author <a href="mailto:jokinglove@foxmail.com">JOKING</a>
 * @since 1.0.0
 */
public class ThreeThreadPrintNumberBySynchronized {

    static volatile AtomicInteger cnt = new AtomicInteger(0);

    public static void main(String[] args) {

        final Object lock = new Object();

        for (int i = 0; i < 3; i++) {
            new Thread(new PrintThread(i, lock)).start();
        }
    }

    static class PrintThread implements Runnable {

        private final int i;

        private final Object lock;

        public PrintThread(int i, Object lock) {
            this.i = i;
            this.lock = lock;
        }

        @Override
        public void run() {
            while(true) {
                synchronized (lock) {
                    if(cnt.get() > 100) {
                        break;
                    }
                    if(cnt.get() % 3 == i) {
                        System.out.println("线程 " + i + ":" + cnt.getAndIncrement());
                    }
                }
            }
        }
    }
}
