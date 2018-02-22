package CTCI.StacksAndQueues;

public class Q3_5 {

	static MyStack<Integer> stack = new MyStack<>();
	static MyStack<Integer> temp = new MyStack<>();

	public void push(Integer item) {
		if (stack.isEmpty()) {
			stack.push(item);
		} else {
			if (stack.peek() > item) {
				stack.push(item);
			} else {
				// insert to stack
				insertStack(stack, temp, item);
			}
		}
	}

	public Integer pop() {
		return stack.pop();
	}

	public Integer peek() {
		return stack.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	private void insertStack(MyStack<Integer> stack, MyStack<Integer> temp, int item) {
		while (stack.peek() <= item) {
			temp.push(stack.pop());
		}

		stack.push(item);

		while (!temp.isEmpty()) {
			stack.push(temp.pop());
		}

	}
}
