package section05;

public class Section05Main {
    public static void main(String[] args) {
        MyGenericLinkedList<String> list = new MyGenericLinkedList<>();
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");

        String str = list.get(0);
        System.out.println("str =" + str);
    }
}
