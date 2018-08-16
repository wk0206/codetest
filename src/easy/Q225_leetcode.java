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
public class Q225_leetcode<T> {
	/**
	 * Your MyStack object will be instantiated and called as such: MyStack obj =
	 * new MyStack(); obj.push(x); int param_2 = obj.pop(); int param_3 = obj.top();
	 * boolean param_4 = obj.empty();
	 */
	// one Queue solution
	private Queue<Integer> q = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		q.add(x);
		for (int i = 1; i < q.size(); i++) { // rotate the queue to make the tail be the head
			q.add(q.poll());
		}
	}

	// Removes the element on top of the stack.
	public int pop() {
		return q.poll();
	}

	// Get the top element.
	public int top() {
		return q.peek();
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return q.isEmpty();
	}

	public static void main(String[] args) {

		Q225_leetcode<Integer> instance = new Q225_leetcode<>();
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
