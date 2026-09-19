package section3_lambda;

/**
 * @FunctionalInterface : 함수형 인터페이스라고 표시
 * 함수형 인터페이스 : 하나의 추상메소드를 가지는 인터페이스를 의미
 */
@FunctionalInterface
public interface SamInterface {
    public abstract void run();
}
