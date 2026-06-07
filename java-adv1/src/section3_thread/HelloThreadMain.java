package section3_thread;

public class HelloThreadMain {
//    public static void main(String[] args) {
//        System.out.println("main() start :: " + Thread.currentThread().getName());
//        // HelloThread 객체를 생성하고 start() 메서드를 호출
//        HelloThread  helloThread = new HelloThread();
//        System.out.println("start() 호출전 :: " + Thread.currentThread().getName());
//
//        helloThread.start();
//        System.out.println("start() 호출후 :: " + Thread.currentThread().getName());
//
//        System.out.println("main() end :: " + Thread.currentThread().getName());
//    }

    // 데몬스레드 테스트
//    public static void main(String[] args) {
//        /**
//         * 실행하면 바로 종료됨
//         * 이유 : JVM은 사용자 스레드가 종료되면 프로그램이 끝남
//         *        데몬스레드를 기다려주지 않음
//         */
//        System.out.println("main() start :: " + Thread.currentThread().getName());
//
//        DaemonThread daemonThread = new DaemonThread();
//        daemonThread.setDaemon(true);
//        daemonThread.start();
//
//        System.out.println("main() end :: " + Thread.currentThread().getName());
//    }

    // Runable 테스트
    public static void main(String[] args) {
        System.out.println("main() start :: " + Thread.currentThread().getName());

        HelloRunable helloRunable = new HelloRunable();
        Thread thread = new Thread(helloRunable);
        thread.start();

        System.out.println("main() end :: " + Thread.currentThread().getName());
    }
}
