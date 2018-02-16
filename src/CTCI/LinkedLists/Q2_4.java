package CTCI.LinkedLists;

public class Q2_4 {
    public static LinkedListNode partition(LinkedListNode n, int value) {
    	LinkedListNode lessList = new LinkedListNode(value, null, null);
    	LinkedListNode lend = lessList;
    	LinkedListNode moreList = new LinkedListNode(value, null, null);
    	LinkedListNode mend = moreList;
    	while(n !=null) {
    		LinkedListNode next = n.next;
    		n.next = null;
    		System.out.println(n.data+":"+value+"-->"+(n.data<value?"less":"more"));
    		
    		if(n.data<value) {
    			//add to head of lessList
    			lend.next=n;
    			lend =n;
    			System.out.println(lessList.printForward());

        	}else {
        		//add to tail of moreList
        		mend.next = n;
        		mend = n;
        		System.out.println(moreList.printForward());
        	}
    		
    		
    		//next
			n=next;
    	}
    
    	if(lessList == null) return moreList;
    	System.out.println(lessList.printForward());
    	System.out.println(moreList.printForward());
    	
    	lend.next=moreList;
    	
    	
    	
    	
    	return lessList;
    }

    public static void main(String[] args) {
		/* Create linked list */
        int[] vals = {3,4,8,5,10,2,1};
        LinkedListNode head = new LinkedListNode(vals[0], null, null);
        LinkedListNode current = head;
        for (int i = 1; i < vals.length; i++) {
            current = new LinkedListNode(vals[i], null, current);
        }
        System.out.println(head.printForward());

		/* Partition */
        LinkedListNode h = partition(head, 5);

		/* Print Result */
        System.out.println(h.printForward());
    }
}
