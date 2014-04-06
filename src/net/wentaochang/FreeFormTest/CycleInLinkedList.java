package net.wentaochang.FreeFormTest;

public class CycleInLinkedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public boolean hasCycle(ListNode node){
		if(node == null){
			return false;
		}
		ListNode node2 = node.next;
		while(node2 != null){
			if(node == node2){
				return true;
			}
			node = node.next;
			node2 = node2.next;
			if(node2 != null){
				node2 = node2.next;
			}
		}
		return false;
	}
}
