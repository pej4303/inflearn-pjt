package section5_interrupt;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static util.MyLogger.log;

public class MyPrinterV3 {
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
                thread.interrupt();
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
            // 플래그 대신 interrupted() 이용
            while (!Thread.interrupted()) {
                if (queue.isEmpty()) {
                    // 큐가 비어 있을 때 CPU를 잠깐 양보해서 낭비를 줄이기 위해서
                    Thread.yield();
                    continue;
                }

                try {
                    String job = queue.poll();
                    log("출력 시작 : " + job + ", 대기 문서: " + queue);
                    Thread.sleep(3000);
                    log("출력 완료");
                } catch (InterruptedException e) {
                    log("인터럽트");
                    break;
                }
            }
            log("프린터 종료");
        }

        public void add(String job) {
            queue.offer(job);
        }
    }
}
