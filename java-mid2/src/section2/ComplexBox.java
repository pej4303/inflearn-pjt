package section2;

import section2.animal.Animal;
import section2.animal.Cat;
import section2.animal.Dog;

public class ComplexBox<T extends Animal> {
    private T animal;

    public void set(T animal) {
        this.animal = animal;
    }

    //  Q. 제네릭 타입과 제네릭 메서드의 우선순위
    public <T1> T1 printAndReturn(T1 t1) {
        System.out.println("animal className = " + animal.getClass());
        System.out.println("t1 className = " + t1.getClass());
        return t1;
    }

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이", 100);
        Cat cat = new Cat("고양이", 30);

        // 제네릭 타입: Dog
        ComplexBox<Dog> complexBox = new ComplexBox<>();
        complexBox.set(dog);

        // 제네릭 메서드의 타입 : Cat
        // 제네릭 타입보다 제네릭 메서드가 높은 우선순위를 가진다.
        // 그래서 printAndReturn() 은 제네릭 타입과 무관하게 적용된다.
        Cat result = complexBox.printAndReturn(cat);
        System.out.println("result =" + result);
    }
}
