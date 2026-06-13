package section4_join.test;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

/**
 * 문제2 - join() 활용2
 *
 * - 문제설명
 * 문제1의 코드를 변경해서 전체 실행 시간을 3초로 앞당겨보자.
 * 실행 결과를 참고하자.
 *
 * - 실행결과
 * 10:29:46.321 [       t1] 1
 * 10:29:46.321 [       t3] 1
 * 10:29:46.321 [       t2] 1
 * 10:29:47.325 [       t2] 2
 * 10:29:47.329 [       t3] 2
 * 10:29:47.329 [       t1] 2
 * 10:29:48.330 [       t3] 3
 * 10:29:48.330 [       t1] 3
 * 10:29:48.330 [       t2] 3
 * 모든 스레드 실행 완료
 */
public class JoinTest2Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new JoinTest1Main.MyTask(), "t1");
        Thread t2 = new Thread(new JoinTest1Main.MyTask(), "t2");
        Thread t3 = new Thread(new JoinTest1Main.MyTask(), "t3");

        // 동시에 실행됨
        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

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
