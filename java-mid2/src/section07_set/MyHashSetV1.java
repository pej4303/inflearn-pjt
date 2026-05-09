package section07_set;

import section05_linkedList.MyLinkedList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashSetV1 {
    // 초기 배열 값
    static final int DEFAULT_CAPACITY = 16;

    // 배열 안에 연결리스트가 있고, 연결 리스트 안에 데이터가 저장되는 구조
    LinkedList<Integer>[] bucket = new LinkedList[DEFAULT_CAPACITY];

    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    /**
     * 생성자
     */
    public MyHashSetV1() {
        // LinkedList 초기화
        this.initBucket();
    }

    public MyHashSetV1(int capacity) {
        this.capacity = capacity;
        // LinkedList 초기화
        this.initBucket();
    }

    /**
     * LinkedList 초기화
     */
    private void initBucket() {
        this.bucket = new LinkedList[this.capacity];
        for (int i = 0; i < this.capacity; i++) {
            this.bucket[i] = new LinkedList<>();
        }
    }

    /**
     * 데이터 저장
     * @param value
     */
    public boolean add(int value) {
        // 1. value를 가지고 해시 인덱스 구하기
        int hashIndex = this.hashIndex(value);

        // 2.구한 해시 인덱스에 값이 있는지 확인
        LinkedList<Integer> list = this.bucket[hashIndex];
        if (list.contains(value)) {
            return false;
        }

        // 3. LinkedList에 값 넣기
        list.add(value);

        // 4. 사이즈 증가
        this.size++;

        return true;
    }

    /**
     * 데이터 삭제
     * @param value
     */
    public boolean remove(int value) {
        // 1. value를 가지고 해시 인덱스 구하기
        int hashIndex = this.hashIndex(value);

        // 2.구한 해시 인덱스에 값 확인
        LinkedList<Integer> list = this.bucket[hashIndex];

        // 3. LinkedList에 값 삭제
        /**
         * ★★★★ 중요 ★★★★
         * remove(Object obj) , remove(int index) 이렇게 2가지 있음
         * 해당 값(value)을 지워야하기 때문에 래퍼 타입으로 변경해서 넘겨줘야 함!!!
         *
         * LinkedList의 remove() 메서드는 이렇게 2가지 있음
         *
         * list.remove(int index): 리스트의 몇 번째 요소를 지울 것인가?
         * list.remove(Object o): 리스트에서 이 객체와 같은 값을 찾아 지울 것인가?
         *
         *
         */
        // list.remove(value); => 10번째 인덱스를 삭제해줘
        // int형 변수를 Integer 객체로 만들어서 전달해야 제대로 인식함
        boolean result = list.remove(Integer.valueOf(value)); // => '10'이라는 값을 삭제해줘

        if (result) {
            // 4. 사이즈 감소
            this.size--;

            return true;
        } else {
            return false;
        }
    }

    /**
     * 해시 인덱스 반환
     * @param value
     * @return
     */
    private int hashIndex(int value) {
        // 나머지 연산
        return value % this.capacity;
    }

    /**
     * 값 여부 확인
     * @param searchValue
     * @return
     */
    private boolean contains(int searchValue) {
        int hashIndex = this.hashIndex(searchValue);
        LinkedList<Integer> list = this.bucket[hashIndex];  // O(1)
        return list.contains(searchValue);  // O(n) : 최악의 경우, 분산되어있기 때문에 O(1)

        /**
         * 만약 this.bucket[hashIndex] 값이 없다면 NullPointerException 발생함
         * 따라서 변수를 할당해서 하는것이 좋음
         */
        // return this.bucket[hashIndex].contains(searchValue);
    }

    @Override
    public String toString() {
        return "MyHashSetV1{" +
                "bucket=" + Arrays.toString(bucket) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        MyHashSetV1 set = new MyHashSetV1();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(2); // 중복
        System.out.println(set);

        // 검색
        int searchValue = 2;
        boolean contains = set.contains(searchValue);
        System.out.println("값 있니? " + contains);

        // 삭제
        boolean removeResult = set.remove(searchValue);
        System.out.println("removeResult = " + removeResult);
    }
}
