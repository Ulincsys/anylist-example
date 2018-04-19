package Ulincsys;

import java.util.Random;

@SuppressWarnings("unchecked")
public class Plist {
	Random rand = new Random();
	Node Head;
	Node Tail;
	int length = 0;
	int count = 0;
	Node[] ind;

	public Plist() {
		config();
	}

	public Plist(Object... items) {
		config();
		append(items);
	}

	private void config() {
		Head = new Node();
		Tail = new Node();
		Head.next = Tail;
		Tail.prev = Head;
	}

	public void append(Node n) {
		if(Head.next == Tail) {
			n.next = Tail;
			Tail.prev = n;
			Head.next = n;
			n.prev = Head;
		} else {
			Node temp = Tail.prev;
			temp.next = n;
			n.prev = temp;
			n.next = Tail;
			Tail.prev = n;
		}
		length += 1;
	}

	public void append(Object... items) {
		for(Object item : items) {
			Node temp = new Node(item);
			append(temp);
		}
	}

	public Integer min() {
		int minimum = firstNum();
		Object[] temp = toArray();
		for(Object item : temp) {
			if(item instanceof Integer) {
				int num = Integer.parseInt(item.toString());
				if(num < minimum) { minimum = num; }
			}
		}
		return minimum;
	}

	public <Any> Any at(int i) {
		Object temp = get(i).data;
		Class dat = temp.getClass();
		
		return (Any)dat.cast(temp);
	}

	/*
	if(i >= 0) {
			T temp = indx[i].data.getClass();
			return temp.cast(indx[i].data);
		} else {
			i = indx.length - Math.abs(i);
			T temp = indx[i].data.getClass();
			return temp.cast(indx[i].data);
		}
	 */

	public Node get(int i) {
		Node[] indx = index();
		if(i >= 0) {
			return indx[i];
		} else {
			i = indx.length - Math.abs(i);
			return indx[i];
		}
	}

	public Object pop() {
		Node temp = Tail.prev;
		Tail.prev = temp.prev;
		temp.prev.next = Tail;
		return temp;
	}

	public Integer max() {
		int maximum = firstNum();
		Object[] temp = toArray();
		for(Object item : temp) {
			if(item instanceof Integer) {
				int num = Integer.parseInt(item.toString());
				if(num > maximum) { maximum = num; }
			}
		}
		return maximum;
	}

	public Node[] index() {
		ind = new Node[length];
		Node temp = Head.next;
		count = 0;
		while(temp != Tail) {
			ind[count] = temp;
			temp = temp.next;
			count++;
		}
		return ind;
	}

	public Integer firstNum() {
		Node temp = Head.next;
		while(temp != Tail) {
			if(temp.data instanceof Integer) {
				return Integer.parseInt(temp.data.toString());
			}
			temp = temp.next;
		}
		return null;
	}

	public Object[] toArray() {
		Node temp = Head.next;
		Object[] arry = new Object[length];
		count = 0;
		while(temp != Tail) {
			arry[count] = temp.data;
			++count;
			temp = temp.next;
		}
		return arry;
	}

	public int length() {
		return length;
	}

	public void read() {
		Node temp = Head.next;
		System.out.print("[ ");
		while(temp != Tail) {
			System.out.print(temp.data);
			if(temp.next != Tail) { System.out.print(", "); }
			temp = temp.next;
		}
		System.out.println(" ]");
	}

	// fillers
	public void fill() {
		for(int i = 0; i < 100; ++i) {
			Node<Integer> temp = new Node<Integer>(rand.nextInt(1000));
			append(temp);
		}
	}

	public void fill(int amt) {
		for(int i = 0; i < amt; ++i) {
			Node<Integer> temp = new Node<Integer>(rand.nextInt(1000));
			append(temp);
		}
	}

	public void fill(int amt, int maxVal) {
		for(int i = 0; i < amt; ++i) {
			Node<Integer> temp = new Node<Integer>(rand.nextInt(maxVal));
			append(temp);
		}
	}
}