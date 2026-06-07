package section3_thread.test;

import static util.MyLogger.log;

/**
 * 문제 4: 여러 스레드 사용
 *
 * - 문제 설명
 * Thread-A, Thread-B 두 스레드를 만들어라.
 * Thread-A는 1초에 한 번씩 "A"를 출력한다.
 * Thread-B는 0.5초에 한 번씩 "B"를 출력한다.
 * 이 프로그램은 강제 종료할 때 까지 계속 실행된다.
 *
 * - 실행 결과
 * 10:04:27.000 [ Thread-A] A
 * 10:04:27.000 [ Thread-B] B
 * 10:04:27.507 [ Thread-B] B
 * 10:04:28.006 [ Thread-A] A
 * 10:04:28.012 [ Thread-B] B
 * 10:04:28.518 [ Thread-B] B
 * 10:04:29.011 [ Thread-A] A
 * 10:04:29.023 [ Thread-B] B
 * ... 무한 실행
 */
public class StartTest4Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        log("A");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.setName("Thread-A");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        log("B");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.setName("Thread-B");

        thread1.start();
        thread2.start();
    }
}
