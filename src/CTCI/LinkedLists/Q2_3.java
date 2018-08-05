package CTCI.LinkedLists;

public class Q2_3 {

	
	public static boolean solution( myLinklistNode n) {
		//input check
		//n
		if(n==null) return false;
		//n.next
		if(n.next==null) return false;
		
		
		//delete(actually replace)
		n.data=n.next.data;
		n.next=n.next.next;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}

}
