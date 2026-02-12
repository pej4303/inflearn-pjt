package section2.animal;

/**
 * 제네릭 클래스 -> 제네릭 메소드로 변경
 */
public class AnimalMethod {
    public static <T extends Animal> void checkup(T t) {
        System.out.println("동물 이름: " + t.getName());
        System.out.println("동물 크기: " + t.getSize());
        t.sound();
    }

    public static <T extends Animal> T bigger(T t1, T t2) {
        return t1.getSize() > t2.getSize() ? t1 : t2;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("재롱이", 30);
        Cat cat = new Cat("덕배", 40);

        // 타입 매개변수 추론이 가능해서 생략 할 수 있다.
        AnimalMethod.checkup(dog);
        // == AnimalMethod.<Dog>checkup(dog);


    }
}
