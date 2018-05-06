package mid;

public class Q024 {

	public static class ListNode {
	     public int val;
	     public ListNode next;
	     public ListNode(int x) { val = x; }
	 }
	
    public static ListNode swapPairs(ListNode head) {
        ListNode NH = new ListNode(0);
        NH.next = head;
        
        ListNode c = NH;
        ListNode n = c.next;
        
        while(!(c.next==null || c.next.next==null)){
            insert(c , c.next.next);
            c = c.next.next;
        }
        
        return NH.next;
    }
    
    public static void insert(ListNode N1, ListNode N2){
        ListNode temp;
        temp = N1.next;
        temp.next = N2.next;
        N1.next = N2;
        N2.next = temp;
    }	
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	ListNode n2 = new ListNode(2);
    	ListNode n3 = new ListNode(3);
    	ListNode n4 = new ListNode(4);
    	
    	head.next = n2;
    	n2.next = n3;
    	n3.next = n4;
    	
    	ListNode res = swapPairs(head);
    }

}
 