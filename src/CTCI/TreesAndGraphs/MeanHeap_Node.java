package CTCI.TreesAndGraphs;

import java.util.Comparator;

public class MeanHeap_Node<T> {
	public Node<T> head;

	public class Node<T> implements Comparator {
		public String name;
		public Node<T> left;
		public Node<T> right;

		public Node<T> parent;

		@Override
		public int compare(Object arg0, Object arg1) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

	public MeanHeap_Node() {
		this.head = new Node();
		head.parent = null;
		head.left = null;
		head.right = null;
	}

	public MeanHeap_Node(Node<T> start) {
		this.head = start;
	}

	public void insert(Node item) {
		// get last
		Node parent = getLast(head);
		// insert
		if (parent.left == null) {
			parent.left = item;
			item.parent = parent;
		} else {
			parent.right = item;
		}

		item.parent = parent;
		// build heap
		buildHeap(item);
	}

	// get the parent of the last item should insert
	// if the tree is perfect, return left down node.
	private Node<T> getLast(Node head) {

		return head;
	}

	private void buildHeap(Node item) {
		if (item.left == null && item.right == null) {
			// build upward
			item.parent = swap(item.parent);
			buildHeap(item.parent);
		} else {

		}

	}

	private Node swap(Node parent) {
		if (parent.right == null) {
			Node l = parent.compare(parent.left, parent) == 0 ? parent.left : parent;
			Node p = parent.compare(parent.left, parent) == 0 ? parent : parent.left;
			Node r = null;
		} else {

		}

		return parent;
	}

	public Node<T> extract_min(Node head) {
		// get min(head)
		Node result = head;

		// replace head with last element
		Node lastParent = getLast(head);
		Node lastChild;
		if (lastParent.right != null) {
			lastChild = lastParent.right;
			lastParent.right = null;
		} else {
			lastChild = lastParent.left;
			lastParent.left = null;
		}

		lastChild.parent = null;
		head = lastChild;

		// build heap
		buildHeap(head);

		return result;
	}

}
