package section03;

public class Node {
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    public static void main(String[] args) {
        // 노드 생성하고 연결하기 A->B->C
        Node node = new Node("A");
        node.next = new Node("B");
        node.next.next = new Node("C");

        Node n = node;
        while (n != null) {
            System.out.println(n.item);
            n = n.next;
        }
    }
}
