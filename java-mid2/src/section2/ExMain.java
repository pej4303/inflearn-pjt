package section2;

import section2.animal.Animal;
import section2.animal.Box;
import section2.animal.Cat;
import section2.animal.Dog;

public class ExMain {
//    public static void main(String[] args) {
//        // 생성 시점에 T의 타입이 결정된다.
//        GenericBox<Integer> box = new GenericBox<>();
//        box.setValue(1);
////        box.setValue("문자열");    // Integer 타입만 허용되며 컴파일 오류가 발생한다.
//
//        // Integer 타입으로 캐스팅할 필요가 없다.
//        Integer integer = box.getValue();
//
//        System.out.println(integer);
//
//        // raw 타입 = 원시 타입 => 내부적으로 Object 타입이 된다.
//        /**
//         * Q. 이러한 원시 타입이 있는 이유는?
//         * A. 하위 호환성 때문
//         */
//        // => raw 타입은 권장하지 않는다.
//        GenericBox box2 = new GenericBox();
//        // => 권장방식
//        GenericBox<Object> box3 = new GenericBox<>();
//    }
    
    public static void main(String[] args) {
        Animal animal = new Animal("동물", 0);
        Dog dog = new Dog("백재롱", 30);
        Cat cat = new Cat("김덕배", 20);

        // Aniaml 타입으로 지정되어서 Dog와 Cat도 넣을 수 있다.
        Box<Animal> animalBox = new Box<>();
        animalBox.set(dog);
        Dog findDog = (Dog) animalBox.get();
        System.out.println("findDog = " + findDog);
    }
}
