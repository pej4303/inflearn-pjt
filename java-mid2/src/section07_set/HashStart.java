package section07_set;

import java.util.Arrays;
import java.util.LinkedList;

public class HashStart {
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        test4();
    }

    public static void test1() {
        Integer[] inputArray = new Integer[4];
        inputArray[0] = 1;
        inputArray[1] = 2;
        inputArray[2] = 5;
        inputArray[3] = 8;
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 8;
        // 4번 반복 O(n)
        for (int inputValue : inputArray) {
            if (inputValue == searchValue) {
                System.out.println(inputValue);
            }
        }
    }

    public static void test2() {
        // 값을 배열의 인덱스로 사용함 => 검색속도는 좋지만 메모리 낭비가 심해짐
        Integer[] inputArray = new Integer[100];
        inputArray[1] = 1;
        inputArray[2] = 2;
        inputArray[5] = 5;
        inputArray[8] = 8;
        inputArray[14] = 14;
        inputArray[99] = 99;
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        int searchValue = 99;
        Integer result = inputArray[searchValue]; // O(1)
        System.out.println(result);
    }

    public static void test3() {
        //{1, 2, 5, 8, 14, 99}
        System.out.println("hashIndex(1) = " + hashIndex(1));
        System.out.println("hashIndex(2) = " + hashIndex(2));
        System.out.println("hashIndex(5) = " + hashIndex(5));
        System.out.println("hashIndex(8) = " + hashIndex(8));
        System.out.println("hashIndex(14) = " + hashIndex(14));
        System.out.println("hashIndex(99) = " + hashIndex(99));

        Integer[] inputArray = new Integer[CAPACITY];
        add(inputArray, 1);
        add(inputArray, 2);
        add(inputArray, 5);
        add(inputArray, 8);
        add(inputArray, 14);
        add(inputArray, 99);
        System.out.println("inputArray = " + Arrays.toString(inputArray));

        // 검색
        int searchValue = 14;
        // 1. 해시 인덱스 구하기 
        int hashIndex = hashIndex(searchValue);
        System.out.println("searchValue hashIndex = " + hashIndex);
        // 2. 배열에 해시 인덱스를 대입해서 값을 조회
        Integer result = inputArray[hashIndex]; // O(1)
        System.out.println(result);
    }

    public static void test4() {
        //{1, 2, 5, 8, 14, 99}
        // LinkedList 사용 이유 => 가끔 발생하는 충돌하기 때문에 메모리 측면에서
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9); //중복
        System.out.println("buckets = " + Arrays.toString(buckets));

        // 검색
        int searchValue = 9;
        boolean contains = contains(buckets, searchValue);
        System.out.println("bucket.contains(" + searchValue + ") = " + contains);
    }

    /**
     * 데이터 저장
     * @param inputArray
     * @param value
     */
    private static void add(Integer[] inputArray, int value) {
        // 1. value를 가지고 해시 인덱스 구하기
        int hashIndex = hashIndex(value);
        // 2. 구한 해시 인덱스에 값 넣기
        inputArray[hashIndex] = value;
    }

    /**
     * 데이터 저장
     * @param buckets
     * @param value
     */
    private static void add(LinkedList<Integer>[] buckets, int value) {
        int hashIndex = hashIndex(value);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        if (!bucket.contains(value)) { // O(n)
            bucket.add(value);
        }
    }

    /**
     *
     * @param buckets
     * @param searchValue
     * @return
     */
    private static boolean contains(LinkedList<Integer>[] buckets, int searchValue) {
        int hashIndex = hashIndex(searchValue);
        LinkedList<Integer> bucket = buckets[hashIndex]; // O(1)
        return bucket.contains(searchValue); // O(n)
    }

    /**
     * 해시 인덱스 반환
     * @param value
     * @return
     */
    static int hashIndex(int value) {
        // 나머지 연산
        return value % CAPACITY;
    }
}