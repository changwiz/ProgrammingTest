package net.wentaochang.leetcode;

import net.wentaochang.leetcode.PopulatingNextRightPointersinEachNodeII.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null || root.left == null && root.right == null) {
			return;
		}
		root.left.next = root.right;
		root.right.next = root.next != null ? root.next.left : null;
		connect(root.left);
		connect(root.right);
	}
}
