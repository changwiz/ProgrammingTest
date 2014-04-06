package net.wentaochang.leetcode;

import java.util.ArrayList;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return res;
        }
        ArrayList<Integer> level = new ArrayList<Integer>();
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        int curLevel = 1, nextLevel = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.remove(0);
            level.add(node.val);
            curLevel--;
            if(node.left != null){
                queue.add(node.left);
                nextLevel++;
            }
            if(node.right != null){
                queue.add(node.right);
                nextLevel++;
            }
            
            if(curLevel == 0){
                res.add(level);
                level = new ArrayList<Integer>();
                curLevel = nextLevel;
                nextLevel = 0;
            }
        }
        return res;
    }
}
