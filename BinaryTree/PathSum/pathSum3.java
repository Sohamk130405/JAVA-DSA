package BinaryTree.PathSum;

import BinaryTree.Node;

public class pathSum3 {
     public int tagetSum(Node root, long sum){
        if(root==null) return 0;
        int count = 0;
        if(root.val==sum) count++;
        count+= tagetSum(root.left,sum-root.val) + tagetSum(root.right,sum-root.val);
        return count;
    }
    public int pathSum(Node root, int sum) {
        if(root==null) return 0 ;
        return tagetSum(root,sum) + pathSum(root.left,sum) + pathSum(root.right,sum);
    }
}
