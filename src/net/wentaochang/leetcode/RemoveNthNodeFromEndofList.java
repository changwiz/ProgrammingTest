package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class RemoveNthNodeFromEndofList {
	//boundary case: n is larger than length of list
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node1 = head;
        ListNode node2 = head;
        int count = n+1;
        int step = 0;
        while(node2!=null){
            node2 = node2.next;
            step++;
            if(count>0){
                count--;
            }else {
                node1 = node1.next;
            }
        }
        if(step>n){
            ListNode temp = node1.next;
            node1.next = node1.next.next;
            temp.next = null;
        } else {
            head = head.next;
            node1.next = null;
        }
        return head;
    }
}
