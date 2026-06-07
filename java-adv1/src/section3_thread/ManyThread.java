package section3_thread;

import static util.MyLogger.log;

public class ManyThread {
    public static void main(String[] args) {
        log("main() start");

        HelloRunable  helloRunable = new HelloRunable();

        Thread thread1 = new Thread(helloRunable);
        thread1.start();
        Thread thread2 = new Thread(helloRunable);
        thread2.start();
        Thread thread3 = new Thread(helloRunable);
        thread3.start();

        log("main() end");
    }
}
