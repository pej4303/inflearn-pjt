package section02.test.unit;

public class UnitPrinter {
    // UnitPrinter.printV1() 은 제네릭 메서드로 구현해야 한다
    public static <T extends Shuttle> void printV1(T shuttle) {
        shuttle.showInfo();
    }

    // UnitPrinter.printV2()는 와일드카드로 구현해야 한다.
    public static void printV2(Shuttle<?> shuttle) {
        shuttle.showInfo();
    }
}
