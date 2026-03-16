package section03;

public class Node {
    Object item;
    Node next;

    public Node(Object item) {
        this.item = item;
    }

    /**
     * 전체 노드 출력하기
     * @param node
     */
    public static void printAll(Node node) {
        Node n = node;

        while (n != null) {
            System.out.println(n.item);
            n = n.next;
        }
    }

    /**
     * 마지막 노드 가져오기
     * @param node
     * @return
     */
    private static Node getLastNode(Node node) {
        Node n = node;

        while (n.next != null) {
            n = n.next;
        }

        return n;
    }

    /**
     * 노드 가져오기
     * @param node
     * @param index
     * @return
     */
    private static Node getNode(Node node, int index) {
        Node n = node;
        // index만큼만 이동하면 된다.
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n;
    }

    /**
     * 노드 추가하기
     * @param node
     * @param param
     */
    private static void setNode(Node node, String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
//        return "Node{" +
//                "item=" + item +
//                ", next=" + next +
//                '}';

        // 이렇게 출력하는게 연결 관계를 보기가 편함
        StringBuilder sb = new StringBuilder();
        Node n = this;
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

    public static void main(String[] args) {
        // 노드 생성하고 연결하기 A->B->C
        Node node = new Node("A");
        node.next = new Node("B");
        node.next.next = new Node("C");

//        System.out.println(node);
//        System.out.println(node.next);

        // 모든 노드 탐색하기
//        printAll(node);

        // 마지막 노드 가져오기
        Node lastNode = getLastNode(node);
        System.out.println("lastNode = " + lastNode.item);

        // 특정 index의 노드 조회하기
        int index = 1;
        Node findNode = getNode(node, index);
        System.out.println("findNode = " + findNode.item);
        
        // 노드 추가
        setNode(node, "D");
        System.out.println(node);
    }
}
