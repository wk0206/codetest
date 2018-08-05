package CTCI.StacksAndQueues;

import java.util.EmptyStackException;

public class Q3_4<T> {
	MyStack<myQueueNode> s1 = new MyStack();
	MyStack<myQueueNode> s2 = new MyStack();

	private class myQueueNode<T> {
		private T data;
		private myQueueNode<T> next;

		public myQueueNode(T data) {
			this.data = data;
		}
	}

	private myQueueNode<T> first;
	private myQueueNode<T> last;

	// flag is the number of stack with "QUEUE" order
	private int flag = 0;

	public void add(T item) {
		// first item
		if (this.isEmpty()) {
			s1.push((myQueueNode) item);
		} else {
			// before first exchange
			if (flag == 0) {
				// add item to non-empty stack
				if (s1.isEmpty()) {
					s2.push((myQueueNode) item);
				}
				if (s2.isEmpty()) {
					s1.push((myQueueNode) item);
				}
				// after exchange
			} else if (flag == 1) {
				// add item to s1
				s1.push((myQueueNode) item);
			} else if (flag == 2) {
				// add item to s2
				s2.push((myQueueNode) item);
			}
		}
	}

	public void remove() {
		// TODO:how to define a new exception
		if (this.isEmpty())
			throw new EmptyStackException();

		if (flag == 0) {
			// exchange stack
			// set flag
			exchangeAndSetFlag(s1, s2);
			// pop()
			universalPop(flag);

		} else if (flag == 1 && !s1.isEmpty()) {
			s1.pop();
		} else if (flag == 1 && s1.isEmpty()) {
			// exchange stack
			// set flag
			exchangeAndSetFlag(s1, s2);

			// pop()
			universalPop(flag);

		} else if (flag == 2 && !s2.isEmpty()) {
			s2.pop();
		} else if (flag == 2 && s2.isEmpty()) {
			// exchange stack
			// set flag
			exchangeAndSetFlag(s1, s2);

			// pop()
			universalPop(flag);
		}
	}

	public void peek() {
		if (this.isEmpty())
			throw new EmptyStackException();
		if (flag == 0) {
			// exchange stack
			// set flag
			exchangeAndSetFlag(s1, s2);
			// peek()
			universalPeek(flag);
		} else if (flag == 1 && !s1.isEmpty()) {
			s1.peek();
		} else if (flag == 1 && s1.isEmpty()) {
			// exchange stack
			// set flag
			exchangeAndSetFlag(s1, s2);
			// peek()
			universalPeek(flag);
		} else if (flag == 2 && !s2.isEmpty()) {
			s2.peek();
		} else if (flag == 2 && s2.isEmpty()) {
			// exchange stack
			// set flag
			exchangeAndSetFlag(s1, s2);
			// peek()
			universalPeek(flag);
		}
	}

	public boolean isEmpty() {
		return s1.isEmpty() && s2.isEmpty();
	}

	private void exchangeAndSetFlag(MyStack<myQueueNode> s1, MyStack<myQueueNode> s2) {
		// exchange stack
		// set flag
		// pop()
		if (s1.isEmpty()) {
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			flag = 1;

		} else {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			flag = 2;
		}

	}

	private void universalPop(int flag) {
		if (flag == 1)
			s1.pop();
		if (flag == 2)
			s2.pop();
	}

	private void universalPeek(int flag) {
		if (flag == 1)
			s1.peek();
		if (flag == 2)
			s2.peek();
	}

}
