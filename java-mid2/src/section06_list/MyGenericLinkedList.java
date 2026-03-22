package section06_list;

public class MyGenericLinkedList<E> implements MyList<E> {
    private Node<E> node;
    private int size = 0;

    /**
     * 요소 변경 (기존값 반환)
     * @param index 위치
     * @param e 변경할 요소
     * @return 기존 요소
     */
    @Override
    public E set(int index, E e) {
        Node<E> n = this.getNode(index);
        E oldVal = n.item;
        n.item = e;

        return oldVal;
    }

    /**
     * 요소 반환
     * @param index 위치
     * @return 요소
     */
    @Override
    public E get(int index) {
        Node<E> node = this.getNode(index);
        return node.item;
    }

    /**
     * 마지막 위치에 요소 추가
     * @param e 추가할 요소
     */
    @Override
    public void add(E e) {
        Node newNode = new Node(e);

        if (this.node == null) {
            this.node = newNode;
        } else {
            Node<E> lastNode = this.getLastNode();
            lastNode.next = newNode;
        }

        this.size++;
    }

    /**
     * 지정 위치에 요소 추가
     * @param index 위치
     * @param e 추가할 요소
     */
    @Override
    public void add(int index, E e) {
        Node<E> newNode = new Node(e);

        if (index == 0) {
            // 첫 번째 노드에 추가
            newNode.next = node;
            node = newNode;
        } else {
            // 직전 노드 찾기
            Node<E> prev = this.getNode(index - 1);
            // 새 노드에 찾은 직전 노드 연결
            newNode.next = prev.next;
            // 직전 노드에 새 노드를 연결
            prev.next = newNode;
        }

        this.size++;
    }

    /**
     * 요소 삭제
     * @param index 위치
     * @return 삭제된 요소
     */
    @Override
    public E remove(int index) {
        Node<E> removeNode = this.getNode(index);
        E removeItem = removeNode.item;

        if (index == 0) {
            node = removeNode.next;
        } else {
            // 삭제 대상의 직전 노드 찾기
            Node<E> prev = this.getNode(index - 1);
            // 직전 노드(prev)의 다음 노드를 삭제 노드의 다음 노드와 연결한다.
            prev.next = removeNode.next;
        }

        // 삭제 대상 노드 초기화
        removeNode.item = null;
        removeNode.next = null;

        this.size--;

        return removeItem;
    }

    /**
     * 요소 위치 반환 (없으면 -1)
     * @param e 찾을 요소
     * @return 인덱스
     */
    @Override
    public int indexOf(E e) {
        int index = 0;
        Node<E> n = node;

        while (n != null) {
            if (e.equals(n.next)) {
                return index;
            }

            n = n.next;
            index++;
        }

        return -1;
    }

    /**
     * 사이즈 반환
     * @return 리스트 크기
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * 노드 조회
     * @param index 위치
     * @return 노드
     */
    private Node<E> getNode(int index) {
        Node<E> n = node;
        // index만큼만 이동하면 된다.
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /**
     * 마지막 노드 조회
     * @return 마지막 노드
     */
    private Node<E> getLastNode() {
        Node<E> n = this.node;

        while (n.next != null) {
            n = n.next;
        }

        return n;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }

    /**
     * 정적 중첩 클래스
     */
    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node<E> n = this;
            sb.append("[");

            while (n != null) {
                sb.append(n.item);

                if (n.next != null) {
                    sb.append("->");
                }

                n = n.next;
            }

            sb.append("]");

            return sb.toString();
        }
    }

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
