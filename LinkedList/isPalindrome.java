package LinkedList;


class isPalindrome {
    public boolean main(Node head) {
        if (head.next == null)
            return true;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node t2 = reverse(slow);
        Node t1 = head;
        while (t2 != null) {
            if (t1.val != t2.val)
                return false;
            t1 = t1.next;
            t2 = t2.next;
        }
        return true;
    }

    public Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = null;
        Node curr = head;
        Node temp = head;

        while (temp != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}