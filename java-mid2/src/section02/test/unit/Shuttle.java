package section02.test.unit;

import section02.test.unit.BioUnit;

public class Shuttle<T extends BioUnit> {
    private T unit;

    public void in(T t) {
        unit = t;
    }

    public void showInfo() {
        System.out.println("이름: %s, HP: %d".formatted(unit.getName(), unit.getHp()));
    }
}
