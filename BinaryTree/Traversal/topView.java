package BinaryTree.Traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import BinaryTree.Node;

public class topView {
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

        topViewOfTree(a);

    }

    public static class Pair {
        Node node;
        int level;

        Pair(Node node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public static void topViewOfTree(Node root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (q.size() > 0) {
            Pair temp = q.remove();
            Node node = temp.node;
            int lvl = temp.level;
            min = Math.min(min, lvl);
            max = Math.max(max, lvl);
            if (!map.containsKey(lvl))
                map.put(lvl, node.val);
            if (node.left != null)
                q.add(new Pair(node.left, lvl - 1));
            if (node.right != null)
                q.add(new Pair(node.right, lvl + 1));
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i)+" ");
        }

    }
}
