package section4_join;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class JoinMain {
    public static void main(String[] args) throws InterruptedException {
        // 방법1) sleep()을 이용
//        test1();

        // 방법2) join()을 이용
        test2();

//        log("START");
//        SumThread task1 = new SumThread(1, 50);
//        SumThread task2 = new SumThread(51, 100);
//
//        new Thread(task1, "task1").start();
//        new Thread(task2, "task2").start();
//
//        // => task1, task2의 계산이 끝내기도 전에 출력해서 값이 이상하게 나오는 문제가 발생함
//        log("task1 result =" + task1.result);
//        log("task2 result =" + task2.result);
//
//        log("END");
    }

    /**
     * 방법1) sleep()을 이용
     */
    public static void test1() {
        log("START");
        SumThread task1 = new SumThread(1, 50);
        SumThread task2 = new SumThread(51, 100);

        new Thread(task1, "task1").start();
        new Thread(task2, "task2").start();

        log("메인 스레드 기다려~");
        sleep(3000);
        log("메인 스레드 일어나!");

        log("task1 result =" + task1.result);
        log("task2 result =" + task2.result);

        log("END");
    }

    /**
     * 방법2) join()을 이용
     */
    public static void test2() throws InterruptedException {
        log("START");
        SumThread task1 = new SumThread(1, 50);
        SumThread task2 = new SumThread(51, 100);

        Thread thread1 = new Thread(task1, "task1");
        Thread thread2 = new Thread(task2, "task2");

        thread1.start();
        thread2.start();

        log("메인 스레드가 task1, task2 끝날때까지 기다려~");
        thread1.join();
        thread2.join();
        log("메인 스레드 일어나!");

        log("task1 result =" + task1.result);
        log("task2 result =" + task2.result);

        log("END");
    }

    static class SumThread implements Runnable {
        int startNum = 0;
        int endNum = 0;
        int result = 0;

        public SumThread(int startNum, int endNum) {
            this.startNum = startNum;
            this.endNum = endNum;
        }

        @Override
        public void run() {
            log("====== 작업시작 ======");

            int sum = 0;
            for (int i= this.startNum; i<= this.endNum; i++) {
                sum += i;
            }
            this.result += sum;

            sleep(2000);
            log("====== 작업 완료 ====== result : " + this.result);
        }
    }
}
