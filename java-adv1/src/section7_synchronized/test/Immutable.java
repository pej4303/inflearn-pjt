package section7_synchronized.test;

/**
 * 문제3 -  final필드
 *
 * - 문제 설명
 * 다음에서 value필드(멤버 변수)는 공유되는 값이다. 멀티스레드 상황에서 문제가 될 수 있을까?
 *
 * => 공유 자원을 사용하는 중간에 다른 스레드에서 값을 변경하면 문제가 발생함
 */
class Immutable {
    private final int value;
    public Immutable(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
