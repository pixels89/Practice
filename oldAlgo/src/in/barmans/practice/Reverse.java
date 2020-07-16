package in.barmans.practice;

import java.util.LinkedList;

class Reverse {
	public static Node reverse_recursive(Node head) {
		return reverse(head, null);

	}

	public static Node reverse(Node node, Node prev) {

		if (node == null)
			return prev;
		Node head = reverse(node.next, node);
		node.next = prev;
		return head;

	}

	public static void main(String[] args) {
		Node list_head = null;
		list_head = new Node(1, new Node(2, new Node(3)));

		list_head = reverse_recursive(list_head);
		System.out.print("After Reverse (Recursive):");

	}
}