public class 复杂链表的复制 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        CloneNodes(head);
        ConnectRandomNode(head);
        Node cloneHead = PartNodes(head);
        return cloneHead;
    }

    private Node PartNodes(Node head) {
        Node node = head;
        Node cloneHead = null;
        Node cloneNode = null;
        if (node != null) {
            cloneHead = node.next;
            cloneNode = node.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        while (node != null) {
            cloneNode.next = node.next;
            cloneNode = cloneNode.next;
            node.next = cloneNode.next;
            node = node.next;
        }
        return cloneHead;
    }

    private void ConnectRandomNode(Node head) {
        Node node = head;
        while (node != null) {
            Node cloneNode = node.next;
            if (node.random != null) {
                cloneNode.random = node.random.next;
            }
            node = cloneNode.next;
        }
    }

    private void CloneNodes(Node head) {
        Node node = head;
        while (node != null) {
            Node clone = new Node(-1);
            clone.val = node.val;
            clone.next = node.next;
            clone.random = null;
            node.next = clone;
            node = clone.next;
        }
    }
}
