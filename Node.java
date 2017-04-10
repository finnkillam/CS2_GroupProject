import javafx.scene.control.Button;

//class Node
public class Node {
	private Button data;
	private Node next;

	public Node(Button d, Node n) {
		data = d;
		next = n;
	}

	public Button getData() {
		return data;
	}

	public Node getNext() {
		return next;
	}

	public void setData(Button d) {
		data = d;
	}

	public void setNext(Node n) {
		next = n;
	}

	public String toString() {
		return data + "-->";
	}
}

