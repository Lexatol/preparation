package HomeWork3.Task2;

import java.util.concurrent.locks.ReentrantLock;

public class Task2 {
    public static void main(String[] args) {
        IncDec in = new IncDec(10);

        ReentrantLock reentrantLock = new ReentrantLock();
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                reentrantLock.lock();
                in.inc();
                System.out.println("увеличение на ед: " + in.getN());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 5; j++) {
                    in.dec();
                }
                System.out.println("Уменьшили на 5: " + in.getN());
                reentrantLock.unlock();
            }).start();

            new Thread(() -> {
                reentrantLock.lock();
                in.dec();
                System.out.println("уменьшили на ед: " + in.getN());

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 3; j++) {
                    in.inc();
                }
                reentrantLock.unlock();
                System.out.println("Увеличили на три " + in.getN());
            }).start();
        }
    }

}

