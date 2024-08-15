package LinkedList;

class Solution {
    public Node removeNthFromEnd(Node head, int n) {
        if (head.next == null)
            return null;

        Node slow = head;
        Node fast = head;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
