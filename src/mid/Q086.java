package mid;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 */
public class Q086 {

	public static void solution() {

	}

	public static ListNode partition(ListNode head, int x) {
		if (head == null)
			return head;
		if (head.next == null)
			return head;
		ListNode greaterHeadNode = null;
		ListNode lastGreaterNode = null;
		ListNode smallerHeadNode = null;
		ListNode lastSmallerNode = null;

		ListNode curNode = head;

		while (curNode.next != null) {

			int val = curNode.val;
			if (val >= x && greaterHeadNode == null) {
				greaterHeadNode = curNode;
				lastGreaterNode = curNode;
			} else if (val < x && smallerHeadNode == null) {
				smallerHeadNode = curNode;
				lastSmallerNode = curNode;
			} else {
				if (val >= x) {
					lastGreaterNode.next = curNode;
					lastGreaterNode = curNode;
				} else {
					lastSmallerNode.next = curNode;
					lastSmallerNode = curNode;
				}
			}

			curNode = curNode.next;

		}
		int val = curNode.val;
		if (val >= x && greaterHeadNode == null) {
			greaterHeadNode = curNode;
			lastGreaterNode = curNode;
		} else if (val < x && smallerHeadNode == null) {
			smallerHeadNode = curNode;
			lastSmallerNode = curNode;
		} else {
			if (val >= x) {
				lastGreaterNode.next = curNode;
				lastGreaterNode = curNode;
			} else {
				lastSmallerNode.next = curNode;
				lastSmallerNode = curNode;
			}
		}
		if (greaterHeadNode == null) {
			lastSmallerNode.next = null;
			return smallerHeadNode;
		}
			
		if (smallerHeadNode == null) {
			lastGreaterNode.next = null;
			return greaterHeadNode;
		}
			
		lastGreaterNode.next = null;
		lastSmallerNode.next = greaterHeadNode;

		return smallerHeadNode;
	}

	public static void main(String[] args) {
		// partition(new int[] {1,4,3,2,5,2}, 3);
		ListNode node = new ListNode(new int[] { 1, 1 });

		partition(node.root, 3);
	}

	public static class ListNode {
		int val;
		ListNode root = null;
		ListNode next = null;

		ListNode(int x) {
			val = x;
		}

		ListNode(int[] A) {
			root = createList(A);
		}
		/*
		 * ListNode(int[] A, int index){ this(A[index]); //this(A,index); }
		 */

		private ListNode createList(int[] A) {
			ListNode head = new ListNode(A[0]);
			ListNode last = head;

			for (int i = 1; i < A.length; i++) {
				ListNode nextNode = new ListNode(A[i]);
				last.next = nextNode;
				last = nextNode;
			}
			return head;
		}

	}
}
