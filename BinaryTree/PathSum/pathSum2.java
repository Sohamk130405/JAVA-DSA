package BinaryTree.PathSum;

import java.util.ArrayList;
import java.util.List;

import BinaryTree.Node;

public class pathSum2 {
    public List<List<Integer>> pathSum(Node root, int target) {
     List<Integer> a = new ArrayList<>();
     List<List<Integer>> ans = new ArrayList<>();
     targetSum(root,target,a,ans);
     return ans;
    }

    public void targetSum(Node root, int target,List<Integer> a,List<List<Integer>> ans){
        if(root==null) return;
        if (root.left == null && root.right == null) {
            if (root.val == target){
                a.add(root.val);
                ans.add(a);
                return;
            }            
            else return;    
        }
        a.add(root.val);
         List<Integer> x = new ArrayList<>();
         List<Integer> y = new ArrayList<>();
        for(int i = 0 ; i < a.size() ; i++){
            x.add(a.get(i));
            y.add(a.get(i));
        }
        targetSum(root.left,target-root.val,x,ans);
        targetSum(root.right,target-root.val,y,ans);
    }
}
