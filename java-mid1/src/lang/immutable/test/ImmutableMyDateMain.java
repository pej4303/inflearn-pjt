package lang.immutable.test;

public class ImmutableMyDateMain {
    public static void main(String[] args) {
        ImmutableMyDate date1 = new ImmutableMyDate(2024,1,1);
//        ImmutableMyDate date2 = date1;
        System.out.println("date1 = " + date1);
//        System.out.println("date2 = " + date2);
        System.out.println("2025 -> date1");

        // 불변 객체에서 속성값을 변경하는 경우 무조건 반환값을 받아야 함!
        ImmutableMyDate date2  = date1.withYear(2025);
        System.out.println("date1 = " + date1);
        System.out.println("date2 = " + date2);
    }
}
