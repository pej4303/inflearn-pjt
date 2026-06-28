package section7_synchronized.test;

import static util.MyLogger.log;

/**
 * 문제2 -  지역 변수의 공유
 *
 * - 문제 설명
 * 다음 코드에서 MyTask의 run() 메서드는 두 스레드에서 동시에 실행한다.
 * 다음 코드의 실행 결과를 예측해보자.
 * 그리고 localValue 지역 변수에 동시성 문제가 발생하는지 하지 않는지 생각해보자.
 *
 * => 지역변수는 공유되는 자원이 아니여서 동시성 문제가 발생하지 않음!
 *
 */
public class SyncTest2Main {
    public static void main(String[] args) throws InterruptedException {
        MyCounter myCounter = new MyCounter();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };
        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        thread1.start();
        thread2.start();
    }

    static class MyCounter {
        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue = localValue + 1;
            }
            log("결과: " + localValue);
        }
    }
}
