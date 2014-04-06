package net.wentaochang.leetcode;

import net.wentaochang.leetcode.BinaryTreePreorderTraversal.TreeNode;

public class FlattenBinaryTreetoLinkedList {
	//Simple solution
    public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.right;
		flatten(root.left);
		root.right = root.left;
		root.left = null;
		flatten(temp);
		while (root.right != null) {
			root = root.right;
		}
		root.right = temp;      
    }
    
    /*
	public void flatten(TreeNode root) {
		if(root != null) {
			last(root);
		}
	}

	private TreeNode last(TreeNode node) {
		if(node.left == null && node.right == null){
			return node;
		}
		TreeNode left = node.left;
		TreeNode right = node.right;
		TreeNode last = null;
		if(left == null){
			node.right = right;
			last = last(right);
			return last;
		} else {
			node.left = null;
			node.right = left;
			last = last(left);
			last.left = null;
			last.right = right;
		}
		if(right == null) {
			return last;
		} else {
			return last(right);
		}
	}*/
}
