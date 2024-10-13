package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import BinaryTree.Node;


public class rightSideView {

    public static int levels(Node root){
        if(root==null) return 0;
        return 1 + Math.max(levels(root.left),levels(root.right));
    }
    public static void dfs(Node root , int level , List<Integer> ans){
        if(root==null) return;
        ans.set(level , root.val);
        dfs(root.left,level+1,ans);
        dfs(root.right,level+1,ans);
    }

    public static void levelorder(Node root, List<Integer> ans) {
        int prevLvl = 0;
        Queue<Pair> q = new LinkedList<>();
        if (root != null) {
            Pair x = new Pair(root, 0);
            q.add(x);
        }

        List<Integer> a = new ArrayList<>();
        while (q.size() > 0) {
            Pair front = q.remove();
            if (front.lvl > prevLvl) {
                ans.add(a.removeLast());
                a = new ArrayList<>();
                prevLvl++;
            }
            a.add(front.node.val);
            if (front.node.left != null) {
                Pair x = new Pair(front.node.left, front.lvl + 1);
                q.add(x);
            }
            if (front.node.right != null) {
                Pair x = new Pair(front.node.right, front.lvl + 1);
                q.add(x);
            }
        }

        ans.add(a.removeLast());
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
        List<Integer> ans = new ArrayList<>();
        // bfs
        // levelorder(a, ans);

        // dfs
        for (int i = 0; i < levels(a); i++) {
            ans.add(0);
        }

        dfs(a, 0, ans);
        System.out.println(ans);
    }
}
