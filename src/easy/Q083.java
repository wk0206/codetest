package easy;

import DataStructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Q083 {

    public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null)return head;
		ListNode list = head;
 
    	int current = head.val;
    	while(head.next!=null && current == head.next.val ){
    		head = head.next;
    	}

    	
    	return head;
    }

}
