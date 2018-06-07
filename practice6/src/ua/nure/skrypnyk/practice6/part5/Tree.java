package ua.nure.skrypnyk.practice6.part5;

public class Tree<E extends Comparable<E>> {

	private static final int INDENT = 5;

	private Node<E> root = null;

	public boolean remove(E element) {
		Node<E> nodeToRemove = find(root, element);
		if (nodeToRemove == null)
			return false;
		removeNode(root, element);
		return true;
	}

	private Node<E> removeNode(Node<E> node, E element) {
		if (node == null)
			return null;
		else if (element.compareTo(node.data) < 0)
			node.left = removeNode(node.left, element);
		else if (element.compareTo(node.data) > 0)
			node.right = removeNode(node.right, element);
		else {
			if (isLeafNode(node))
				node = null;
			else if (node.left == null)
				node = node.right;
			else if (node.right == null)
				node = node.left;
			else{
				Node<E> minNodeForRightSubTree = minNode(node.right);
				node.data = minNodeForRightSubTree.data;
				removeNode(node.right,minNodeForRightSubTree.data);
			}
		}
		return node;
	}
	private Node<E> minNode(Node<E> node){
		if (node.left == null)
			return node;
		else
			return minNode(node.left);
	}

	private boolean isLeafNode(Node<E> node) {
		if (node.left == null && node.right == null)
			return true;
		return false;
	}

	public void add(E[] elements) {
		for (E element : elements) {
			add(element);
		}
	}

	public boolean add(E e) {
		if (root == null) {
			root = new Node(e);
			return true;
		} else
			return addTo(root, e);
	}

	private boolean addTo(Node<E> node, E e) {
		if (e.compareTo(node.data) < 0) {
			if (node.left == null) {
				node.left = new Node(e);
				return true;
			}
			addTo(node.left, e);
		} else if (e.compareTo(node.data) > 0) {
			if (node.right == null) {
				node.right = new Node(e);
				return true;
			}
			addTo(node.right, e);
		}
		return false;
	}

	private Node<E> find(Node<E> node, E element) {
		if (node == null)
			return null;
		if (element.compareTo(node.data) == 0)
			return node;
		else if (element.compareTo(node.data) < 0)
			return find(node.left, element);
		else
			return find(node.right, element);
	}

	public void print() {
		print(root, 0);
	}

	private void print(Node<E> node, int space) {
		if (node == null)
			return;
		space += INDENT;
		print(node.right, space);
		printSpaces(space);
		System.out.printf("%d%n", node.data);
		print(node.left, space);
	}

	private void printSpaces(int space) {
		for (int i = INDENT; i < space; i++) {
			System.out.print(" ");
		}
	}

	private static class Node<E> {
		private E data;
		private Node<E> left;
		private Node<E> right;

		public Node(E data) {
			this.data = data;
		}
	}

}
