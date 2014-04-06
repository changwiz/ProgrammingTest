package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class ValidateBinarySearchTree {
	//Binary search tree: range min~max
	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE,Integer.MAX_VALUE);	
	}
	
	private boolean isValidBST(TreeNode root, int min, int max) {
		if(root == null){
			return true;
		}
		TreeNode left = root.left;
		TreeNode right = root.right;
		if(left != null && (left.val >= root.val || left.val <= min) || right!= null && (right.val <= root.val || right.val >= max)) {
			return false;
		} else if(!isValidBST(left, min, root.val)){
			return false;
		} else if(!isValidBST(right, root.val, max)){
			return false;
		}
		return true;
	}
}
