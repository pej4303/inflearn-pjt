package section5_interrupt;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class InterruptMain {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "myTask");
        thread.start();

        sleep(100);    // 0.1초 대기
        log("작업 중단 지시");
        thread.interrupt();
        log("MyTask 스레드 인터럽트 상태1 = " + thread.isInterrupted());
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            // => 스레드가 시작될 때 최초로 1번만 인터럽트 상태를 읽어옴
            // boolean interrupted = Thread.currentThread().isInterrupted();

            // while 조건식에서 실시간으로 인터럽트 상태를 확인해야 중단됨
//            while (!Thread.currentThread().isInterrupted()) {
//                log("작업중");
//            }

            // 현재 스레드가 인터럽트 상태인지를 체크, 인터럽트 상태도 변경함
            while (!Thread.interrupted()) {
                log("작업중");
            }
            log("MyTask 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted());

            try {
                log("자원 정리");
                Thread.sleep(1000);
                log("자원 종료");
            } catch (InterruptedException e) {
                log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                log("MyTask 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }

            log("작업완료");
        }
    }
}
