package section07_set;

import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private List<String> list = new ArrayList<>();

    /**
     * 항목 추가
     * @param value
     */
    public void add(String value) {
        if (!this.contains(value)) {
            list.add(value);
        }
    }

    /**
     * 항목 유무 판단
     * @param value
     * @return
     */
    public boolean contains(String value) {
        for (String item : this.list) {
            if (item.equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 항목 제거
     * @param value
     */
    public void remove(String value) {
        if (this.contains(value)) {
            this.list.remove(value);
        }

        /**
         * ArrayList$Itr.checkForComodification 오류 발생함
         * 원인 : Java의 ArrayList는 fail-fast 구조라서 생성 시점의 상태를 기억해두고
         *        순회 중에 리스트가 변경되면 바로 예외를 발생시킴
         * 방법: removeIf 사용 또는 리스트 복사본 사용
         *       list.removeIf(i -> 조건);
         */
//        for (String item : this.list) {
//            if (item.equals(value)) {
//                this.list.remove(value);
//            }
//        }
    }

    @Override
    public String toString() {
        return "MyHashSet{" +
                "list=" + list +
                '}';
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add("1");
        myHashSet.add("2");
        myHashSet.add("3");
        myHashSet.add("4");
        myHashSet.add("5");
        System.out.println(myHashSet);


        System.out.println(myHashSet.contains("2"));
        System.out.println(myHashSet.contains("99"));

        myHashSet.remove("3");
        System.out.println(myHashSet);
    }
}
