package section2;

public class GenericMethod {
    public static Object objMethod(Object obj) {
        System.out.println("Object print : " + obj);
        return obj;
    }

    /**
     * 제네릭 메소드
     * @param t
     * @return
     * @param <T>
     */
    public static <T> T genericMethod(T t) {
        System.out.println("generic print : " + t);
        return t;
    }
    // 제네릭 메서드도 타입 제한을 할 수 있다.
    public static <T extends Number> T numberMethod(T t) {
        System.out.println("number print : " + t);
        return t;
    }

    public static void main(String[] args) {
        Integer num = 10;

        Object object = GenericMethod.objMethod(num);
        // => Object 타입으로 반환된다.

        // 타입 인자 명시적 전달
        // 제네릭 메소드는 호출이 될때 타입이 정의된다.
        Integer resultNum = GenericMethod.<Integer>genericMethod(num);
        // => Integer 타입으로 반환된다.
        System.out.println("resultNum = " + resultNum);
    }
}
