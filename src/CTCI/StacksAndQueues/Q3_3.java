package CTCI.StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Q3_3<T> {
	private static class StackNode<T>{
		private int belongTo;
		private T data;
		private StackNode<T> next;
		
		
		//what if the initial is private
		public StackNode(T data) {
			if(CapacityLeft>0) {
				belongTo = stackNo;
				CapacityLeft--;
			}else {
				stackNo+=1;
				belongTo = stackNo;
				CapacityLeft = Capacity;
			}
			this.data = data;
		}
	}
	
	//store 'top' for every stack
	private ArrayList<StackNode<T>> stacks = new ArrayList<>();
	
	private StackNode<T> top;
	private static final int Capacity = 32;
	private static int CapacityLeft = Capacity;
	public static int stackNo = 0;
	
	public T pop() {
		if(stacks.size()==0)throw new EmptyStackException();
		if(top == null) {
			stacks.remove(stackNo);
			stackNo-=1;
			top = stacks.get(stackNo);	
		}
		T item = top.data;
		top = top.next;
		CapacityLeft++;
		return item;
	}
	
	public void push(T item, int index) {

		StackNode<T> currentTop = stacks.get(index);
		//a new start of a stack
		if(currentTop == null) {
			StackNode<T> t = new StackNode<T>(item);
			t.next = null;
			top = t;
			stacks.add(top);
		//continue of a stack
		}else {
			StackNode<T> t = new StackNode<T>(item);
			t.next = currentTop;
			top = t;
			stacks.remove(index);
			stacks.add(top);
		}
		
	}
	
	public T peek() {
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public T popAt(int index) {
		StackNode<T> currentTop = stacks.get(index);
		StackNode<T> tempTop = currentTop.next;
		stacks.remove(index);
		stacks.add(tempTop);
		
		return currentTop.data;
	}
	

}
