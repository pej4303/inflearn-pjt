package section03;

public class MyLinkedList {
    private Node node;
    private int size = 0;

    /**
     * 노드 추가
     * @param obj
     */
    public void add(Object obj) {
        Node newNode = new Node(obj);
        if (this.node == null) {
            this.node = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }

        this.size++;
    }

    public void add(int index, Object obj) {
        Node newNode = new Node(obj);

        if (index == 0) {
            // 첫 번째 노드에 추가
            newNode.next = node;
            node = newNode;
        } else {
            // 직전 노드 찾기
            Node prev = this.getNode(index - 1);
            // 새 노드에 찾은 직전 노드 연결
            newNode.next = prev.next;
            // 직전 노드에 새 노드를 연결
            prev.next = newNode;
        }
        this.size++;
    }

    /**
     * 삭제
     * @param index
     * @return
     */
    public Object remove(int index) {
        Node removeNode = this.getNode(index);
        Object removeItem = removeNode.item;

        if (index == 0) {
            node = removeNode.next;
        } else {
            // 삭제 대상의 직전 노드 찾기
            Node prev = this.getNode(index - 1);
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
     * 마지막 노드 가져오기
     * @return
     */
    private Node getLastNode() {
        Node n = this.node;

        while (n.next != null) {
            n = n.next;
        }

        return n;
    }

    public Object set(int index, Object obj) {
        Node n = this.getNode(index);
        Object oldVal = n.item;
        n.item = obj;

        // 왜 이전값을 반환해야되지...???
        return oldVal;
    }

    public Object get(int index) {
        Node node = this.getNode(index);
        return node.item;
    }

    /**
     * 노드 가져오기
     * @param index
     * @return
     */
    private Node getNode(int index) {
        Node n = node;
        // index만큼만 이동하면 된다.
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /**
     * 원소 검색
     * @param obj
     * @return
     */
    public int indexOf(Object obj) {
        int index = 0;
        Node n = node;

        while (n != null) {
            if (obj.equals(n.next)) {
                return index;
            }

            n = n.next;
            index++;
        }

        return -1;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "node=" + node +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");

        System.out.println("list.size = " + list.getSize());
        System.out.println("list.get(1) = " + list.get(1));
        System.out.println("list.indexOf(\"c\") = " + list.indexOf("c"));
        System.out.println("list.set(2, \"z\") = " + list.set(2, "z"));
        System.out.println(list);

        list.add("d");

        list.add(2, "e");
        // 중간 항목 추가 : O(n)
        System.out.println(list);

        list.remove(3);
        // 중간 항목 삭제 : O(n)
        System.out.println(list);
    }
}
