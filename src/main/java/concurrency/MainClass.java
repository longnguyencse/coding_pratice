package concurrency;

class YieldThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " in control");
        }
    }
}

class YieldThreadLow extends Thread {

    public YieldThreadLow(String name) {
        this.setPriority(3);
        this.setName(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " in control 1111");
        }
    }
}

public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        YieldThread threadA = new YieldThread();
//        YieldThreadLow threadB  = new YieldThreadLow("Low priority");
//        threadB.start();
        threadA.start();
//        threadA.join();
        for (int i = 0; i < 5; i++) {
            Thread.yield();
            System.out.println(Thread.currentThread().getName() + " in control");
        }
//        threadB.run();
    }
}
