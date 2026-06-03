package section09_iterable;

import java.util.Arrays;

public class MyUser implements Comparable<MyUser> {
    private String name;
    private int age;

    public MyUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(MyUser o) {
        System.out.println("MyUser.compareTo :: o = " + o.toString());
        return this.age < o.age ? -1 : (this.age == o.age ? 0 : 1);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + this.name + '\'' +
                ", age=" + this.age +
                '}';
    }

    public static void main(String[] args) {
        MyUser user1 = new MyUser("user1", 34);
        MyUser user2 = new MyUser("user2", 27);
        MyUser user3 = new MyUser("user3", 42);

        MyUser[] users = {user1, user2, user3};

        Arrays.sort(users);

        System.out.println(Arrays.toString(users));
    }
}
