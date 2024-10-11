

package lang.immutable.test;

public class ImmutableMyDate {
    private final int year;
    private final int month;
    private final int day;
    public ImmutableMyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // 불변 객체에서 속성을 변경할때는 "with"라는 문구를 사용함
    public ImmutableMyDate withYear(int year) {
        return new ImmutableMyDate(year, month, day);
    }
    public ImmutableMyDate withMonth(int month) {
        return new ImmutableMyDate(year, month, day);
    }
    public ImmutableMyDate withDay(int day) {
        return new ImmutableMyDate(year, month, day);
    }
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
