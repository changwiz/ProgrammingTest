package net.wentaochang.FreeFormTest;

public class LCA {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}
		if(root == p){
			return p;
		} else if(root == q){
			return q;
		}
		TreeNode left = LCA(root.left, p, q);
		TreeNode right = LCA(root.right, p, q);
		if (left != null && right != null) {
			return root;
		}
		return left != null ? left : right;
	}
}
