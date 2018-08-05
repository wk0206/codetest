package CTCI.LinkedLists;

public class myLinklistNode {
	public myLinklistNode previous;
	public myLinklistNode next;
	//public myLinklistNode first;
	public myLinklistNode last;
	public int data;
	
	public myLinklistNode() {}
	
	public myLinklistNode(int d, myLinklistNode n, myLinklistNode p) {
		data = d;
		
		//previous = p;
		//next = n;
		
		setPrevious(p);
		setNext(n);
		
		
	}
	
	public boolean hasNext() {
		
		return true;
		
	}
	
	public void next() {
		
	}

	public void getLast() {
		
	}
	
	public void add() {
		
	}

	public myLinklistNode remove(myLinklistNode head, int d) {	
		myLinklistNode n  = head;
		if(n.data == d) {
			return head.next;
		}
		
		while(n!=null) {
			if(n.next.data==d) {
				n.next = n.next.next;
				return head;
			}
			
			if(n.data!=d) {
				n=n.next;
			}
		}
		
		return head;
	}
	
	public void setNext(myLinklistNode n) {
		next = n;
		
		if(this == last) {
			last = n;
		}
		if(n != null && previous.next != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(myLinklistNode p) {
		previous = p;
		if(p != null && previous.next != this) {
			p.setNext(this);
		}
	}
	
	
	
}
