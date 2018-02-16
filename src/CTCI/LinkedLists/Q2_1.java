package CTCI.LinkedLists;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Q2_1 {
	
	public static void solution(LinkedList firstNode) {
		
		HashSet<Integer> tempSet = new HashSet<>();
		
		LinkedList<Integer> n = firstNode;
		LinkedList<Integer> previous = null;
		
		while(n!=null) {
			if(tempSet.contains(n)) {
				//delete this element
				//previous.next = n.next;	
			}else {
				tempSet.add(n.poll());
			}
		}
		

		
		for(Iterator<Integer> i = firstNode.iterator(); i.hasNext();) {
				}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> llist = new LinkedList<>();
		solution(llist);
		
	
	}

}
