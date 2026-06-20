package section5_interrupt;

public class YieldMain {
    private final static int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "-" + i);
                // 1. empty : 하나의 스레드가 연달아 실행되다가 다른 스레드로 넘어감
                // 2. sleep : 해당 스레드는 TIMED_WAITING 상태 이후 다시 RUNNABLE 상태로 변경됨
                //            의도적으로 실행 흐름을 끊어서 다른 스레드가 실행될 기회를 줌
//                sleep(1);
                // 3. yield : RUNNABLE 상태를 유지하면서 CPU를 양보함
//                Thread.yield();
            }
        }
    }
}
