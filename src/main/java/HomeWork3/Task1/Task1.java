package HomeWork3.Task1;

public class Task1 {
    public static void main(String[] args) {
        PingPong ping = new PingPong();
        PingPong pong = new PingPong();

        Thread myThread1 = new Thread(() -> {
            synchronized (ping) {
                for (int i = 0; i < 5; i++) {
                    ping.write("Ping");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread1.start();

        Thread myThread2 = new Thread(() -> {
            synchronized (pong) {
                for (int i = 0; i < 5; i++) {
                    pong.write("Pong");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        myThread2.start();
    }
}
