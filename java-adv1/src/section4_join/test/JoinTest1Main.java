package section4_join.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 * 문제1 - join() 활용1
 *
 * - 문제설명
 * 다음 코드를 작성하고, 코드를 실행하기 전에 로그가 어떻게 출력될지 예측해 보자.
 * 그리고 총 실행 시간이 얼마가 걸릴지 예측해 보자.
 *
 * - 실행결과
 */
public class JoinTest1Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyTask(), "t1");
        Thread t2 = new Thread(new MyTask(), "t2");
        Thread t3 = new Thread(new MyTask(), "t3");

        t1.start(); // 3초
        t1.join();  // 대기

        t2.start(); // 3초
        t2.join();  // 대기

        t3.start(); // 3초
        t3.join();  // 대기

        // 총 9초 걸림
        System.out.println("모든 스레드 실행 완료");
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                log(i);
                sleep(1000);
            }
        }
    }
}
