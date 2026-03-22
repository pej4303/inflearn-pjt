package section05;

public class Node {
    Object item;
    Node next;

    /**
     * 생성자
     * @param item 저장할 값
     */
    public Node(Object item) {
        this.item = item;
    }

    /**
     * 전체 노드 출력
     * @param node 시작 노드
     */
    public static void printAll(Node node) {
        Node n = node;

        while (n != null) {
            System.out.println(n.item);
            n = n.next;
        }
    }

    /**
     * 마지막 노드 조회
     * @param node 시작 노드
     * @return 마지막 노드
     */
    private static Node getLastNode(Node node) {
        Node n = node;

        while (n.next != null) {
            n = n.next;
        }

        return n;
    }

    /**
     * 노드 조회
     * @param node 시작 노드
     * @param index 위치
     * @return 노드
     */
    private static Node getNode(Node node, int index) {
        Node n = node;

        for (int i = 0; i < index; i++) {
            n = n.next;
        }

        return n;
    }

    /**
     * 마지막 위치에 노드 추가
     * @param node 시작 노드
     * @param param 추가할 값
     */
    private static void setNode(Node node, String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

    /**
     * 노드 연결 구조 문자열 반환
     * @return 문자열
     */
    @Override
    public String toString() {
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
        // 노드 생성 및 연결 A -> B -> C
        Node node = new Node("A");
        node.next = new Node("B");
        node.next.next = new Node("C");

        // 마지막 노드 조회
        Node lastNode = getLastNode(node);
        System.out.println("lastNode = " + lastNode.item);

        // 특정 위치 노드 조회
        int index = 1;
        Node findNode = getNode(node, index);
        System.out.println("findNode = " + findNode.item);

        // 노드 추가
        setNode(node, "D");
        System.out.println(node);
    }
}