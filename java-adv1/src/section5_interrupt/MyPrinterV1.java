package section5_interrupt;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class MyPrinterV1 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner sc = new Scanner(System.in);
        while (true) {
            log("프린터할 문서를 입력하세요. 종료(q): ");
            String input = sc.nextLine();
            if ("q".equals(input)) {
                // 프린터 작업 중단
                printer.running = false;
                break;
            }

            printer.add(input);
        }
    }

    static class Printer implements Runnable {
        volatile boolean running = true;
        Queue<String> queue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (running) {
                if (queue.isEmpty()) {
                    continue;
                }

                String job = queue.poll();
                log("출력 시작 : " + job + ", 대기 문서: " + queue);
                sleep(3000);    // 3초 대기
                log("출력 완료");
            }
        }

        public void add(String job) {
            queue.offer(job);
        }
    }
}
