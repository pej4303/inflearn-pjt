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

        size++;
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
    }
}
