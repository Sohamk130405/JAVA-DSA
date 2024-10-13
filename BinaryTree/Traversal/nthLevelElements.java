package BinaryTree.Traversal;

import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.Node;
import BinaryTree.Tree;

public class nthLevelElements {

    public static void nthLevel(Node root, int level) {
        if (root == null)
            return;
            if (level == 0)System.out.print(root.val + " ");
            nthLevel(root.left, level - 1);
            nthLevel(root.right, level - 1);
    }

     public static void levelorder(Node root) {
        System.out.print("Level Order: ");
        Queue<Node> q = new LinkedList<>();
        if (root != null)
            q.add(root);
        while (q.size() > 0) {
            Node front = q.remove();
            System.out.print(front.val + " ");
            if (front.left != null)
                q.add(front.left);
            if (front.right != null)
                q.add(front.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);

        a.left = b;
        a.right = c;
        b.left = d;
        b.right = e;
        c.right = g;
        c.left = f;

        for (int i = 0; i < Tree.levels(a); i++) {
            nthLevel(a, i);
            System.out.println();
        }
    }
}
