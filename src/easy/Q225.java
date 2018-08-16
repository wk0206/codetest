package easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*push(x) -- Push element x onto stack.
 *pop() -- Removes the element on top of the stack.
 *top() -- Get the top element.
 *empty() -- Return whether the stack is empty.
 */

/*
 *You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 *Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 *You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class Q225<T> {
	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	List<Integer> queue1 = new LinkedList<>();
	List<Integer> queue2 = new LinkedList<>();
	Queue<T> q1;
	Queue<T> q2;
	T sample;

	Queue<T> last;
	boolean flag = false;

	/** Initialize your data structure here. */
	// public MyStack() {
	public Q225() {
		q1 = new LinkedList();
		q2 = new LinkedList();
	}

	/** Push element x onto stack. */
	public void push(T t) {
		if (q1.isEmpty() && q2.isEmpty()) {
			q1.add(t);
			//last = q1;
			flag =false;
			return;
		}

		if (q1.isEmpty() && !q2.isEmpty()) {
			q1.add(t);
			//last = q1;
			flag =false;
			return;
		}

		if (!q1.isEmpty() && q2.isEmpty()) {
			q2.add(t);
			//last = q2;
			flag =true;
			return;
		}

		if (!q1.isEmpty() && !q2.isEmpty()) {
			T e;
			if(flag == true) {
				e = q2.poll();
			}else {
				e = q1.poll();
			}
			//e = last.poll();
			
			if (q1.size() == 0) {
				q2.add(e);
				q1.add(t);
				flag = false;
			} else {
				q1.add(e);
				q2.add(t);
				flag = true;
			}
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public T pop() {
		
		T res;
		if(flag ==true) {
			res = q2.poll();
			turn(q1,q2);
			flag = false;
		}
		else {
			res = q1.poll();
			turn(q2,q1);
			flag = true;
		}
		return res;
	}

	/** Get the top element. */
	public T top() {
		T res;
		if(flag ==true) {
			res = q2.peek();
		}
		else {
			res = q1.peek();
		}
		
		return res;
		
	}
	
	//clear qt1 to qt2
	//leave 1 element in qt1
	public void turn(Queue<T> qt1, Queue<T> qt2) {
		while(qt1.size()>1) {
			T e = qt1.poll();
			qt2.add(e);
		}
		
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {

		return q1.isEmpty() && q2.isEmpty();
	}

	public static void main(String[] args) {

		Q225<Integer> instance = new Q225<>();
		int res;
		instance.push(0);
		instance.push(1);
		instance.push(2);
		instance.push(3);
		instance.push(4);
		res = instance.top();
		res = instance.pop();

		System.out.println(res);
	}

}
