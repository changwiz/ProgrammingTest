package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
        	return true;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        return mirror(left,right);
    }
    
    private boolean mirror(TreeNode a, TreeNode b) {
    	if(a==null && b==null) {
    		return true;
    	} else if(a!= null && b!= null){
    		return a.val == b.val && mirror(a.left,b.right) && mirror(a.right, b.left);
    	} else {
    		return false;
    	}
    }
}
