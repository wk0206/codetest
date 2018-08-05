package practice;

import java.util.Random;

import test.SkipList.Node;

public class SkipListPractice20180413<E> {

	// define node
	public static class Node<E> {
		public int key;
		public E value;

		public Node<E> l, r, u, d;
		public static final int HEAD_KEY = Integer.MIN_VALUE;
		public static final int TAIL_KEY = Integer.MAX_VALUE;

		public Node() {

		}

		public Node(int k, E v) {
			this.key = k;
			this.value = v;
		}

		@Override
		public String toString() {
			return "key-value: " + key + " - " + value;
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
	}

	// define field
	private int listLevel;
	private Node<E> head;
	private Node<E> tail;
	private int nodes;
	private Random random;
	private static final double PROBABILITY = 0.5;

	// define function
	public SkipListPractice20180413() {
		random = new Random();
		init();
	}

	private void init() {
		head = new Node<E>(Node.HEAD_KEY, null);
		tail = new Node<E>(Node.TAIL_KEY, null);

		linkHorizontal(head, tail);

		listLevel = 0;
		nodes = 0;

	}

	public boolean isEmpty() {
		return nodes == 0;
	}

	public int size() {
		return nodes;
	}

	public void put(int k, E v) {
		Node<E> p = findNode(k);

		// key already exist, update value
		if (k == p.key) {
			p.value = v;
			return;
		}

		// key do not exist , insert into level 0
		Node<E> q = new Node<E>(k, v);
		
		//TODO:------------------
		//this place had big mistake happen
		//linkHorizontal(p.q);<--------------------------------------------------------------------------------wrong
		linkLast(p, q);
		//TODO:------------------
		int currentLevel = 0;

		// decide if this key need up level
		while (random.nextDouble() < PROBABILITY) {
			// check if it is the level MAX
			if (currentLevel >= listLevel) {
				// build new level
				listLevel++;
				Node<E> p1 = new Node<E>(Node.HEAD_KEY, null);
				Node<E> p2 = new Node<E>(Node.TAIL_KEY, null);
				linkHorizontal(p1, p2);
				linkVertical(p1, head);
				linkVertical(p2, tail);
				head = p1;
				tail = p2;

			}

			while (p.u == null) {
				p = p.l;
			}
			p = p.u;

			// make a new node, link to left, link to down
			Node<E> e = new Node<E>(k, v);
			linkLast(p, e);
			linkVertical(e,q);

			q = e;
			currentLevel++;
		}
		
		nodes++;

	}
//	public void put(int k, E v) {
//		Node<E> p = findNode(k);
//
//		// if they have teh same key ,replace value and return
//		if (k == p.getKey()) {
//			p.value = v;
//			return;
//		}
//
//		// make a new Node , add to tail(most near to the given key)
//		//q is the node we need to add
//		Node<E> target = new Node<E>(k, v);
//		linkLast(p, target);
//		int currentLevel = 0;
//
//		// roll
//		while (random.nextDouble() < PROBABILITY) {
//			// build a new level , if it is not enough.
//			if (currentLevel >= listLevel) {
//				listLevel++;
//				Node<E> p1 = new Node<E>(Node.HEAD_KEY, null);
//				Node<E> p2 = new Node<E>(Node.TAIL_KEY, null);
//				linkHorizontal(p1, p2);
//				linkVertical(p1, head);
//				linkVertical(p2, tail);
//				head = p1;
//				tail = p2;
//			}
//
//			// put p to upper level(p is not the node we add, it is the node nearest to added node)
//			//this layer means, we already decide to add a layer to current node
//			//so p will point to every layer's nearest node
//			//until the outer while stop
//			while (p.u == null) {
//				p = p.l;
//			}
//			p = p.u;
//
//			Node<E> e = new Node<E>(k, v);
//			linkLast(p, e);
//			linkVertical(e, target);
//			target = e;
//			currentLevel++;
//
//		}
//
//		nodes++;
//	}
	public Node<E> get(int k) {
		Node<E> p = findNode(k);

		if (k == p.getKey()) {
			return p;
		} else {
			return null;
		}
	}

	public boolean delete(int k) {
		Node<E> e = findNode(k);

		while (k == e.key) {
			e.l.r = e.r;
			e.r.l = e.l;

			if (e.u != null) {
				e = e.u;
			} else {
				nodes--;
				return true;
			}

		}
		// default situation: no such key
		return false;

	}

//	private Node<E> findNode(int key) {
//		// start from head;
//		Node<E> p = head;
//
//		// if we need a new level, we make a new level
//		while (true) {
//			while (p.r.key != Node.TAIL_KEY && p.r.key <= key) {
//				p = p.r;
//			}
//
//			if (p.d != null) {
//				p = p.d;
//			} else {
//				break;
//			}
//		}
//		return p;
//	}
	//find the most near node, or the node itself
	private Node<E> findNode(int key) {
		Node<E> p = head;
		while (true) {
			while (p.r.key != Node.TAIL_KEY && p.r.key <= key) {
				p = p.r;
			}

			if (p.d != null) {
				p = p.d;
			} else {
				break;
			}
		}
		//if key exist, return the node
		//if key do not exist, return the most left near node
		return p;
	}
	
	private Node<E> newLevel() {
		Node<E> newHead = new Node<E>(Node.HEAD_KEY, null);
		Node<E> newTail = new Node<E>(Node.TAIL_KEY, null);

		// connect head and tail
		linkHorizontal(newHead, newTail);

		// connect vertial
		linkVertical(newHead, head);
		linkVertical(newTail, tail);

		head = newHead;
		tail = newTail;

		// update maxLevel
		listLevel++;
		
		return head;
	}

	private void linkLast(Node<E> l, Node<E> e) {
		e.l = l;
		e.r = l.r;
		l.r.l = e;
		l.r = e;

	}

	private void linkHorizontal(Node<E> p, Node<E> n) {
		p.r = n;
		n.l = p;
	}

	private void linkVertical(Node<E> u, Node<E> d) {
		u.d = d;
		d.u = u;

	}

	@Override
	public String toString() {
		if(isEmpty()) {
			return "empty";
		}
		
		StringBuilder sb = new StringBuilder();
		Node<E> p = head;
		while(p.d!=null) {
			p=p.d;
		}
		while (p.l != null) {
			p = p.l;
		}
		if (p.r != null) {
			p = p.r;
		}
		while(p.r != null) {
			sb.append(p.toString());
			sb.append("\n");
			p = p.r;
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		SkipListPractice20180413<String> list = new SkipListPractice20180413<String>();
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
		System.out.println("----delete----");
		list.delete(1);
		System.out.println(list);
		System.out.println(list.size());
		

	}
}
