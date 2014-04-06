package net.wentaochang.leetcode;

import java.util.HashMap;

public class ConstructBinaryTreeFromPreorderAndInorder {
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
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0 || preorder.length != inorder.length) {
			return null;
		}
		HashMap<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; ++i) {
			mapIndex.put(inorder[i], i);
		}

		return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, mapIndex);
	}

	private TreeNode buildTree(int[] preorder, int[] inorder, int px, int py, int ix, int iy, HashMap<Integer, Integer> mapIndex) {
		if (py - px == 0 || iy - ix == 0) {
			return new TreeNode(preorder[px]);
		} else if (px > py || ix > iy) {
			return null;
		}
		int rootVal = preorder[px];
		int index = mapIndex.get(rootVal);
		TreeNode root = new TreeNode(rootVal);
		root.left = buildTree(preorder, inorder, px + 1, px + index - ix, ix, index - 1, mapIndex);
		root.right = buildTree(preorder, inorder, px + 1 + index - ix, py, index + 1, iy, mapIndex);
		return root;
	}
}
