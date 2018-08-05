package CTCI.StacksAndQueues;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;


public class Q3_2<T>{
	private static class StackNode<T>{
		private T data;
		private StackNode<T> next;
		
		public StackNode(T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;
	private StackNode<T> min;
	
	private boolean isSmaller(T data1, T data2) {
		return false;
	}
	
	public T pop() {
		if(top == null) throw new EmptyStackException();
		T item = top.data;
		top = top.next;
		min = min.next;
		return item;
	}
	
	public void push(T item) {
		//Queue Normal
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
		
		//Queue Min
		if(min == null) min = t;
		//item> min, push min 
		if(this.isSmaller(min.data, item)) {
			StackNode<T> temp = min;
			temp.next = min;
			min = temp;
		//item< min, push item
		}else {
			StackNode<T> temp = new StackNode<T>(item);
			temp.next = min;
			min = temp;
		}
	}
	
	public T peek() {
		if(top == null) throw new EmptyStackException();
		return top.data;
	}
	
	public T min() {
		if(min == null) throw new EmptyStackException();
		return min.data;
	} 
	
	public boolean isEmpty() {
		return top == null;
	}
	

}
