package section3_thread;

public class HelloRunable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
    }
}
