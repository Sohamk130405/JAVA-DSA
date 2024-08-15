package LinkedList;

public class Solution {
    public Node getIntersectionNode(Node headA, Node headB) {

        int lenA = 0;
        int lenB = 0;
        Node temp = headA;
        Node tempA = headA;
        Node tempB = headB;

        while (temp != null) {
            temp = temp.next;
            lenA++;
        }

        temp = headB;
        while (temp != null) {
            temp = temp.next;
            lenB++;
        }

        int diff = Math.abs(lenA - lenB);

        if (lenA > lenB) {
            while (diff > 0) {
                tempA = tempA.next;
                diff--;
            }
        }
        if (lenA < lenB) {
            while (diff > 0) {
                tempB = tempB.next;
                diff--;
            }
        }

        while (tempA != null && tempB != null) {
            if (tempA == tempB)
                return tempA;
            tempA = tempA.next;
            tempB = tempB.next;
        }

        return null;
    }
}