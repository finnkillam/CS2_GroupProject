public class LinkedList {
	private Node front;
	private int count;

	// constructor
	public LinkedList() {
		front = null;
		count = 0;
	}

	// add a node to the front of the linked list
	public void addToFront(Assignment d) {
		Node n;
		n = new Node(d, front);
		front = n;
		count++;
	}

	public void addToEnd(Assignment d) {
		Node n;
		n = new Node(d, null);
		Node curr = front;
		if (front == null)
			front = n;
		else {
			while (curr.getNext() != null)
				curr = curr.getNext();
			curr.setNext(n);
		}
		count++;
	}
	
	public void remove(int index) {
		Node curr = front;
		for (int i = 0; i < index-1; i++)
			curr = curr.getNext();
		curr.setNext(curr.getNext().getNext());
		count--;
	}

	// get the current size of the list
	public int size() {
		return count;
	}

	// check if the list is empty
	public boolean isEmpty() {
		return (count == 0);
	}

	// clear the list
	public void clear() {
		front = null;
		count = 0;
	}

	// get the content of the first node
	public Assignment getFrontData() {
		if (front == null)
			return null;
		else
			return front.getData();
	}

	// new method added - get the first node
	public Node getFront() {
		return front;
	}

	// returns node at input index
	public Assignment get(int index) {
		Node curr = front;
		for (int i = 0; i < index; i++)
			curr = curr.getNext();
		return curr.getData();
	}

	// returns -1 if the string is not found, otherwise, returns index of
	// string.
	public int containsName(String d) {
		Node curr = front;
		boolean found = false;
		int index = -1;
		while (curr != null && !found) {
			index++;
			if (curr.getData().getName().equals(d))
				found = true;
			curr = curr.getNext();
		}
		if (!found)
			return -1;
		else
			return index;

	}

	// returns -1 if the string is not found, otherwise, returns index of string.
	public int contains(Assignment d) {
		Node curr = front;
		boolean found = false;
		int index = -1;
		while (curr != null && !found) {
			index++;
			if (curr.getData().equals(d))
				found = true;
			curr = curr.getNext();
		}
		if (!found)
			return -1;
		else
			return index;

	}

	// scan the list and print contents
	public void enumerate() {
		Node curr = front;
		while (curr != null) {
			System.out.print(curr);
			curr = curr.getNext();
		}
		System.out.println(".");
	}
}
