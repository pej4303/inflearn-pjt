package section3_thread.test;

/**
 * 문제 2: Runnable 구현
 *
 * - 문제 설명
 * 다음 요구사항에 맞게 멀티스레드 프로그램을 작성해라.
 * 1. CounterRunnable 이라는 이름의 클래스를 만들자, 이 클래스는 Runnable 인터페이스를 구현해야 한다.
 * 2. CounterRunnable 은 1부터 5까지의 숫자를 1초 간격으로 출력해야 한다.
 *    앞서 우리가 만든 log() 기능을 사용해서 출력해라.
 * 3. main() 메서드에서 CounterRunnable의 인스턴스를 이용해서 Thread를 생성하고 실행해라.
 * 4. 스레드의 이름은 "counter"로 지정해야 한다.
 *
 * - 실행 결과
 * 09:53:36.705 [  counter] value: 1
 * 09:53:37.713 [  counter] value: 2
 * 09:53:38.719 [  counter] value: 3
 * 09:53:39.725 [  counter] value: 4
 * 09:53:40.726 [  counter] value: 5
 */
public class StartTest2Main {
}
