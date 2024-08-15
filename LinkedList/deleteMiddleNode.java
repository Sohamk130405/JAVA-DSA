package LinkedList;

class Solution {
    public Node deleteMiddle(Node head) {
        if (head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next == null) {
            head.next = null;
            return head;
        }
        slow.val = slow.next.val;
        slow.next = slow.next.next;
        return head;
    }
}
