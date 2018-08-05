package practice;

import java.util.Random;

import practice.SkipListPractice20180413.Node;

public class SkipListPractice20180417<E> {

	// field
	//private Node<E> up, down, left, right;
	private int listLevel;
	private int nodes;

	public Node<E> head;
	public Node<E> tail;

	public Random random;
	private static final double PROBABILITY = 0.5;

	// constructor
	public SkipListPractice20180417() {
		
		random = new Random();
		init();
	}

	private void init() {
		head = new Node<E>(Node.HEAD_KEY, null);
		tail = new Node<E>(Node.TAIL_KEY, null);

		listLevel = 0;
		nodes = 0;

		linkH(head, tail);

	}

	// function
	public Node<E> locate(int key) {
		Node<E> p = head;

		while (true) {
			while (p.right != null && p.right.key <= key) {
				p = p.right;
			}

			if (p.down != null) {
				p = p.down;
			} else {
				break;
			}
		}

		return p;
	}

	public boolean delete(Node<E> n) {
		Node<E> p = locate(n.key);
		while (p.key == n.key) {
			p.left.right = p.right;
			p.right.left = p.left;

			if (n.up != null) {
				p = p.up;
			} else {
				nodes--;
				return true;
			}
		}

		return false;
	}

	public void insert(Node<E> n) {
		Node<E> p = locate(n.key);
		if (p.key == n.key) {
			System.out.println("node already exist");
			return;
		}

		Node<E> q = new Node<E>(n.key, n.value);
		linkToTail(p, q);
		int currentLevel = 0;

		while (random.nextDouble() >= 0.5) {
			if (currentLevel >= listLevel) {
				// make a new level
				Node<E> newHead = new Node<E>(Node.HEAD_KEY, null);
				Node<E> newTail = new Node<E>(Node.TAIL_KEY, null);

				linkH(newHead, newTail);
				linkV(newHead, head);
				linkV(newTail, tail);
			
				
				//this time is here, forget<------------------------------------------------wrong
				head = newHead;
				tail = newTail;

				// listLevel +1
				listLevel++;

			}

			while (p.up == null) {
				p = p.left;
			}

			p = p.up;

			Node<E> newNode = new Node<E>(n.key, n.value);
			linkToTail(p, newNode);
			linkV(newNode, q);

			q = newNode;

			currentLevel++;
		}
		nodes++;
	}

	public void upadte(Node<E> n) {
		Node<E> p = locate(n.key);
		if (p.key == n.key) {
			p.value = n.value;
			return;
		}
	}

	private void linkH(Node<E> n1, Node<E> n2) {
		n1.right = n2;
		n2.left = n1;
	}

	private void linkV(Node<E> upper, Node<E> lower) {
		upper.down = lower;
		lower.up = upper;
	}

	private void linkToTail(Node<E> l, Node<E> e) {
		e.left = l;
		e.right = l.right;
		l.right.left = e;
		l.right = e;

	}

	@Override
	public String toString() {
		if (nodes == 0)
			return "empty";

		StringBuilder builder = new StringBuilder();

		Node<E> p = head;
		while (p.down != null) {
			p = p.down;
		}

		p = p.right;
		while (p.right.key != Node.TAIL_KEY) {
			builder.append(p.toString());
			builder.append("\n");
			p = p.right;
		}

		return builder.toString();
	}

	public int size() {
		return nodes;
	}

	// Node structure
	public static class Node<E> {
		int key;
		E value;

		public Node<E> up, down, left, right;
		public static final int HEAD_KEY = Integer.MIN_VALUE;
		public static final int TAIL_KEY = Integer.MAX_VALUE;

		// constructor
		Node() {

		}

		Node(int k, E v) {
			this.key = k;
			this.value = v;
		}

		@Override
		public String toString() {
			// TODO:
			return "key-value: " + key + " - " + value;
		}

		@Override
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

		public void setKey(int k) {
			this.key = k;
		}

		public int getKey() {
			return this.key;
		}

		public void setValue(E v) {
			this.value = v;
		}

		public E getValue() {
			return this.value;
		}

	}

	public static void main(String[] args) {
		SkipListPractice20180417<String> list = new SkipListPractice20180417<String>();
		System.out.println(list);
		list.insert(new Node<String>(2, "w"));
		list.insert(new Node<String>(1, " "));
		list.insert(new Node<String>(3, "k"));
		list.insert(new Node<String>(1, "replace blank"));
		list.insert(new Node<String>(4, "a"));
		list.insert(new Node<String>(6, "b"));
		list.insert(new Node<String>(5, "c"));
		System.out.println(list);
		System.out.println(list.size());
		System.out.println("----delete----");
		list.delete(new Node<String>(1,""));
		System.out.println(list);
		System.out.println(list.size());

	}

}
