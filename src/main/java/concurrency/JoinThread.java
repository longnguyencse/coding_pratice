package concurrency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class JoinThread extends Thread {
    public int processingCount = 0;

    JoinThread(int count) {
        this.processingCount = count;
        this.setName("Process " + count);
        System.out.println("Thread Created");
    }

    @Override
    public void run() {
        System.out.println("Thread " + this.getName() + " started");

        while (processingCount > 0) {
            try {
                Thread.sleep(1000);
//                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread " + this.getName() + " interrupted");
            }
            processingCount--;
        }

        System.out.println("Thread " + this.getName() + " exiting");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread joinThread = new JoinThread(3);
        Thread joinThread2 = new JoinThread(5);
        joinThread2.start();
        joinThread.start();
        System.out.println("Invoking join");
        joinThread.join();
        joinThread2.join();
        System.out.println("Returned from join");
        assertFalse(joinThread.isAlive());
    }

    @Test
    public void test() throws InterruptedException {
        Thread joinThread = new JoinThread(3);
        joinThread.start();
        System.out.println("Invoking join");
        joinThread.join();
        System.out.println("Returned from join");
        assertFalse(joinThread.isAlive());
    }
}


