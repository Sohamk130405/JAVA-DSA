package DynamicProgramming.BinaryTree;

import java.util.HashMap;
import java.util.Map;

import BinaryTree.Node;

public class Diameter {
    static Map<Node, Integer> dp;

    public static void main(String[] args) {
        dp = new HashMap<>();
    }

    public static int diameter(Node root) {
        if (root == null)
            return 0;
        int rootDia = levels(root.left) + levels(root.right);
        int leftDia = levels(root.left);
        int rightDia = levels(root.right);
        return Math.max(rootDia, Math.max(leftDia, rightDia));
    }

    public static int levels(Node root) {
        if (root == null)
            return 0;
        if (dp.containsKey(root))
            return dp.get(root);
        int leftLvl = levels(root.left);
        int rightLvl = levels(root.right);
        dp.put(root, 1 + Math.max(leftLvl, rightLvl));
        return dp.get(root);
    }
}
