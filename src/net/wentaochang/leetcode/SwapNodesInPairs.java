package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode node1 = newHead;
        ListNode node2 = head;
        while(node2!=null&&node2.next!=null){
            ListNode temp = node2.next;
            node2.next = temp.next;
            temp.next = node2;
            node1.next = temp;
            node1=node2;
            node2=node2.next;
        }
        return newHead.next;
    }
}
