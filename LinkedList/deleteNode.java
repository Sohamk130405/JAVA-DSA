package LinkedList;

class deleteNode {
    public void main(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
