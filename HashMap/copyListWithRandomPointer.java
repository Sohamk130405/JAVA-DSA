package HashMap;

import java.util.HashMap;

class Node {

    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
    }
}

public class copyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node head2 = deepCopy(head);
        Node temp1 = head;
        Node temp2 = head2;
        HashMap<Node, Node> map = new HashMap<>();

        while (temp1 != null) {
            map.put(temp1, temp2);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        for (Node key : map.keySet()) {
            Node val = map.get(key);
            if (key.random != null) {
                val.random = map.get(key.random);
            }
        }

        return head2;
    }

    public Node deepCopy(Node head) {
        Node head2 = new Node(head.val);
        Node t1 = head.next;
        Node t2 = head2;

        while (t1 != null) {
            Node temp = new Node(t1.val);
            t2.next = temp;
            t2 = t2.next;
            t1 = t1.next;
        }
        return head2;
    }
}
