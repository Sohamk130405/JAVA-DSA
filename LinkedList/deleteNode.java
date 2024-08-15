package LinkedList;

class Solution {
    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
