package net.wentaochang.leetcode;

import net.wentaochang.leetcode.LinkedListCycle.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode smallList = new ListNode(-1);
        ListNode largeList = new ListNode(-1);
        ListNode smallEnd = smallList;
        ListNode largeEnd = largeList;
        
        while(head != null){
            if(head.val >= x){
                largeEnd.next = head;
                largeEnd = largeEnd.next;
            } else {
                smallEnd.next = head;
                smallEnd = largeEnd.next;
            }
            head = head.next;
        }
        smallEnd.next = largeList.next;
        largeEnd.next = null;
        
        return smallList.next;
    }
}
