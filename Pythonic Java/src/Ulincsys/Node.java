package Ulincsys;

public class Node<T> {
	public Node prev = null;
	public Node next = null;
	public T data = null;

	public Node(T item) {
		data = item;
	}

	public Node(Node p, Node n) {
		prev = p;
		next = n;
	}

	public Node() {

	}
}