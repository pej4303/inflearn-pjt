package section08_map.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 문제2 - 작업 예약
 *
 * - 문제 설명
 * 서비스를 운영중인데, 낮 시간에는 사용자가 많아서 서버에서 무거운 작업을 하기 부담스럽다.
 * 무거운 작업을 예약해두고 사용자가 없는 새벽에 실행하도록 개발해보자.
 * 다양한 무거운 작업을 새벽에 실행한다고 가정하자.
 * 작업은 자유롭게 구현하고 자유롭게 예약할 수 있어야 한다.
 * 다음 예제 코드와 실행 결과를 참고해서 TaskScheduler클래스를 완성하자.
 * 실행 결과를 참고하자.
 *
 * - 실행 결과
 * 작업 시작
 * 데이터 압축...
 * 자료 백업...
 * 사용하지 않는 자원 정리...
 * 작업 완료
 */
public class TaskScheduler {
    private Queue<Task> tasks = new ArrayDeque<>();
    private int remainingTasks = 0;

    public int getRemainingTasks() {
        return tasks.size();
    }

    // 코드 작성

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void processNextTask() {
        if (!tasks.isEmpty()) {
            Task task = tasks.poll();
            task.execute();
        }
    }
}
