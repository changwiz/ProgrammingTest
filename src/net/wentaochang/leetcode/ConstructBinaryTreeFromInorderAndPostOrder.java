package net.wentaochang.leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostOrder {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	// Recursion, trick is to use hash map to store the index of root node in
	// in-order list
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || postorder.length == 0 || inorder == null || inorder.length == 0 || postorder.length != inorder.length) {
			return null;
		}
		HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; ++i) {
			mapIndex.put(inorder[i], i);
		}

		return buildTree(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1, mapIndex);
	}

	private TreeNode buildTree(int[] postorder, int[] inorder, int px, int py, int ix, int iy, HashMap<Integer, Integer> mapIndex) {
		if (py - px == 0 || iy - ix == 0) {
			return new TreeNode(postorder[py]);
		} else if (px > py || ix > iy) {
			return null;
		}
		int rootVal = postorder[py];
		int index = mapIndex.get(rootVal);
		TreeNode root = new TreeNode(rootVal);
		root.left = buildTree(postorder, inorder, px, px + index - ix - 1, ix, index - 1, mapIndex);
		root.right = buildTree(postorder, inorder, px + index - ix, py-1, index + 1, iy, mapIndex);
		return root;
	}
}
