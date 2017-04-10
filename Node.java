//class Node
public class Node {
	private Assignment data;
	private Node next;

	public Node(Assignment d, Node n) {
		data = d;
		next = n;
	}

	public Assignment getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Assignment d) {
		data = d;
	}

	public void setNext(Node n) {
		next = n;
	}

	public String toString() {
		return data + "-->";
	}
}

