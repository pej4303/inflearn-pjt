package section3_thread;

import static util.MyLogger.log;

public class ManyThread {
//    public static void main(String[] args) {
//        log("main() start");
//
//        HelloRunable  helloRunable = new HelloRunable();
//
//        Thread thread1 = new Thread(helloRunable);
//        thread1.start();
//        Thread thread2 = new Thread(helloRunable);
//        thread2.start();
//        Thread thread3 = new Thread(helloRunable);
//        thread3.start();
//
//        log("main() end");
//    }

    // Runnable 이용
//    public static void main(String[] args) {
//        log("main() start");
//
//        MyRunnable myRunnable = new MyRunnable();
//
//        Thread thread1 = new Thread(myRunnable);
//        thread1.start();
//        Thread thread2 = new Thread(myRunnable);
//        thread2.start();
//        Thread thread3 = new Thread(myRunnable);
//        thread3.start();
//
//        log("main() end");
//    }

    // 익명 클래스를 이용
//    public static void main(String[] args) {
//        log("main() start");
//
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                log("run()");
//            }
//        });
//
//        thread1.start();
//
//        log("main() end");
//    }

    // 람다 이용
    public static void main(String[] args) {
        log("main() start");

        Thread thread1 = new Thread(() -> log("run()"));

        thread1.start();

        log("main() end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }
}
