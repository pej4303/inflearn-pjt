package section07_set;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/**
 * - Integer만 저장 할 수 있었던 MyHashSetV1 을 개선
 * - 모든 타입을 저장 할 수 있도록 LinkedList를 Object 타입으로 변경함
 */
public class MyHashSetV2 {
    // 초기 배열 값
    private static final int DEFAULT_CAPACITY = 16;

    // 배열 안에 연결리스트가 있고, 연결 리스트 안에 데이터가 저장되는 구조
    private LinkedList<Object>[] bucket = new LinkedList[DEFAULT_CAPACITY];

    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    /**
     * 생성자
     */
    public MyHashSetV2() {
        // LinkedList 초기화
        this.initBucket();
    }

    public MyHashSetV2(int capacity) {
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
    public boolean add(Object value) {
        // 1. value를 가지고 해시 인덱스 구하기
        int hashIndex = this.hashIndex(value);

        // 2.구한 해시 인덱스에 값이 있는지 확인
        LinkedList<Object> list = this.bucket[hashIndex];
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
    public boolean remove(Object value) {
        // 1. value를 가지고 해시 인덱스 구하기
        int hashIndex = this.hashIndex(value);

        // 2.구한 해시 인덱스에 값 확인
        LinkedList<Object> list = this.bucket[hashIndex];

        // 3. LinkedList에 값 삭제
        boolean result = list.remove(value);

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
    private int hashIndex(Object value) {
        // 1. 해시코드 구하기
        int hashCode = Objects.hashCode(value);
//        System.out.println("hashCode = " + hashCode);
        // 2. 음수 방지를 위해 절댓값으로 변경 후 나머지 연산
        return Math.abs(hashCode) % this.capacity;
    }

    /**
     * 값 여부 확인
     * @param searchValue
     * @return
     */
    private boolean contains(Object searchValue) {
        int hashIndex = this.hashIndex(searchValue);    // O(1)
        LinkedList<Object> list = this.bucket[hashIndex];  // O(1)
        return list.contains(searchValue);  // O(n) : 최악의 경우, 분산되어있기 때문에 O(1)
    }

    @Override
    public String toString() {
        return "MyHashSetV2{" +
                "bucket=" + Arrays.toString(bucket) +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("SET");
        set.add("D"); // 중복
        System.out.println(set);

        // 검색
        String searchValue = "SET";
        boolean contains = set.contains(searchValue);
        System.out.println("값 있니? " + contains);

        // 삭제
        String removeValue = "D";
        boolean removeResult = set.remove(removeValue);
        System.out.println("removeResult = " + removeResult);
    }
}
