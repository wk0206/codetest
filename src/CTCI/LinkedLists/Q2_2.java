package CTCI.LinkedLists;

public class Q2_2 {
	public static void solution(myLinklistNode head, int index) {
		int count = 1;
		myLinklistNode n = head;
		while(n.hasNext()) {

			if(count>=index) {
				System.out.println(n.data);
				n=n.next;
			}
			count++;			
		}
	}

}
