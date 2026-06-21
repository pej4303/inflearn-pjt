package section6_volatile;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class VolatileMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "myTask");
        thread.start();

        // runFlag를 변경하였으나 MyTask는 계속 무한루프를 돌고 있는 상황 => 메모리 가시성 문제
        sleep(1000);
        log("runFlag를 false로 변경");
        task.runFlag = false;
        log("runFlag = " + task.runFlag);

        log("main 종료");
    }

    static class MyTask implements Runnable {
        boolean runFlag = true;

        @Override
        public void run() {
            log("task 시작");
            while (runFlag) {
                // runFlag가 false가 되면 나감
            }
            log("task 종료");
        }
    }
}
