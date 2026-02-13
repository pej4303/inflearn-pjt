package section2;

import section2.animal.Animal;

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

    /**
     * 와일드카드(?) 제네릭 메서드
     * @param box
     */
    public static void printWildCard(GenericBox<?> box) {
        // ? == <? extends Object>
        System.out.println("? = " + box.getValue());
    }
    // 와일드카드도 타입 매개변수를 제한 할 수 있음
    // 와일드카드는 이미 만들어진 제네릭 타입을 활용 할 때 사용하는 것이다.
    public static void printWildCard2(GenericBox<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println("name = " + animal.getName());
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
