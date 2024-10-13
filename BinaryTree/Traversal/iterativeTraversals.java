package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import BinaryTree.Node;

public class iterativeTraversals {

    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if (root != null)
            st.push(root);
        while (st.size() > 0) {
            Node top = st.pop();
            ans.add(top.val);
            if (top.right != null)
                st.push(top.right);
            if (top.left != null)
                st.push(top.left);
        }
        return ans;
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if (root != null)
            st.push(root);
        while (st.size() > 0) {
            Node top = st.pop();
            if (top.left != null)
                st.push(top.left);
            if (top.right != null)
                st.push(top.right);
            ans.add(top.val);
        }
        ans = ans.reversed();
        return ans;
    }

    public static List<Integer> inorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node temp = root;
        while (true) {
            if (temp != null) {
                st.push(temp);
                temp = temp.left;
            } else {
                if (st.size() == 0)
                    break;
                Node top = st.pop();
                ans.add(top.val);
                temp = top.right;
            }
        }
        return ans;
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
        List<Integer> ans = postorder(a);
        System.out.println(ans);
    }
}
