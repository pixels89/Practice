package in.barmans.practice;

public class Node {
	public Node(int data, Node next) {
		this.data = data;
		this.next = next;
	}

	public Node(int data) {
		this.data = data;

	}

	int data;
	Node next;

	public void printList() {
		Node node = this;
		while (node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.println();
	}
}
