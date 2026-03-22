package section02_generic.animal;

import section03_generic2.animal.Animal;

public class Cat extends Animal {
    public Cat(String name, int size) {
        super(name, size);
    }

    @Override
    public void sound() {
        System.out.println("야옹");
    }
}
