package test;

import java.util.LinkedList;
import java.util.Random;

public class SkipList<E> extends LinkedList<E> {

	private Node<E> head, tail;
	private int nodes;
	private int listLevel;
	private Random random;
	private static final double PROBABILITY = 0.5;

	public SkipList() {
		random = new Random();
		clear();
	}

	public void clear() {
		head = new Node<E>(Node.HEAD_KEY, null);
		tail = new Node<E>(Node.TAIL_KEY, null);
		horizontalLink(head, tail);
		listLevel = 0;
		nodes = 0;

	}

	public boolean isEmpty() {
		return nodes == 0;
	}

	public int size() {
		return nodes;
	}

	//find the most near node, or the node itself
	private Node<E> findNode(int key) {
		Node<E> p = head;
		while (true) {
			while (p.right.key != Node.TAIL_KEY && p.right.key <= key) {
				p = p.right;
			}

			if (p.down != null) {
				p = p.down;
			} else {
				break;
			}
		}
		//if key exist, return the node
		//if key do not exist, return the most left near node
		return p;
	}

	public Node<E> search(int key) {
		Node<E> p = findNode(key);
		if (key == p.getKey()) {
			return p;
		} else {
			return null;
		}
	}

	public void put(int k, E v) {
		Node<E> p = findNode(k);

		// if they have teh same key ,replace value and return
		if (k == p.getKey()) {
			p.value = v;
			return;
		}

		// make a new Node , add to tail(most near to the given key)
		//q is the node we need to add
		Node<E> target = new Node<E>(k, v);
		backLink(p, target);
		int currentLevel = 0;

		// roll
		while (random.nextDouble() < PROBABILITY) {
			// build a new level , if it is not enough.
			if (currentLevel >= listLevel) {
				listLevel++;
				Node<E> p1 = new Node<E>(Node.HEAD_KEY, null);
				Node<E> p2 = new Node<E>(Node.TAIL_KEY, null);
				horizontalLink(p1, p2);
				verticallLink(p1, head);
				verticallLink(p2, tail);
				head = p1;
				tail = p2;
			}

			// put p to upper level(p is not the node we add, it is the node nearest to added node)
			//this layer means, we already decide to add a layer to current node
			//so p will point to every layer's nearest node
			//until the outer while stop
			while (p.up == null) {
				p = p.left;
			}
			p = p.up;

			Node<E> e = new Node<E>(k, v);
			backLink(p, e);
			verticallLink(e, target);
			target = e;
			currentLevel++;

		}

		nodes++;
	}

	private void backLink(Node<E> n1, Node<E> n2) {
		n2.left = n1;
		n2.right = n1.right;
		n1.right.left = n2;
		n1.right = n2;
	}

	private void horizontalLink(Node<E> n1, Node<E> n2) {
		n1.right = n2;
		n2.left = n1;
	}

	private void verticallLink(Node<E> n1, Node<E> n2) {
		n1.down = n2;
		n2.up = n1;
	}

	@Override
	public String toString() {
		if (isEmpty()) {
			return "empty";
		}
		StringBuilder builder = new StringBuilder();
		Node<E> p = head;
		while (p.down != null) {
			p = p.down;
		}

		while (p.left != null) {
			p = p.left;
		}
		if (p.right != null) {
			p = p.right;
		}
		while (p.right != null) {
			builder.append(p);
			builder.append("\n");
			p = p.right;
		}

		return builder.toString();

	}

	public static class Node<E> {
		public int key;
		public E value;

		public Node<E> right;
		public Node<E> left;
		public Node<E> up;
		public Node<E> down;

		public static final int HEAD_KEY = Integer.MIN_VALUE;
		public static final int TAIL_KEY = Integer.MAX_VALUE;

		public Node(int k, E element) {
			this.key = k;
			this.value = element;

		}

		public int getKey() {
			return this.key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public E getValue() {
			return this.value;
		}

		public void setValue(E value) {
			this.value = value;
		}

		public boolean equals(Object o) {
			if (this == o) {
				return true;
			}

			if (o == null) {
				return false;
			}

			if (!(o instanceof Node<?>)) {
				return false;
			}

			Node<E> ent;
			try {
				ent = (Node<E>) o;
			} catch (ClassCastException ex) {
				return false;
			}

			return (ent.getKey() == key) && (ent.getValue() == value);
		}

		@Override
		public String toString() {
			return "key - value: " + key + " - " + value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SkipList<String> list = new SkipList<String>();
		System.out.println(list);
		list.put(2, "wang");
		list.put(1, " ");
		list.put(3, "kang");
		list.put(1, "replace blank");
		list.put(4, "a");
		list.put(6, "b");
		list.put(5, "c");
		System.out.println(list);
		System.out.println(list.size());
	}

}
