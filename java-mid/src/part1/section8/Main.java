package part1.section8;

public class Main {
    public static void main(String[] args) {
        NestedOuter nestedOuter = new NestedOuter();

        NestedOuter.Nested nested = new NestedOuter.Nested();
        nested.print();

        System.out.println("nested = " + nested.getClass());
    }
}
