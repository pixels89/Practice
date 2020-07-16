package in.barmans.practice;

public class ReverseKElements {
	public static void main(String[] args) {
		Node a = new Node(2, new Node(5, new Node(6, new Node(8, new Node(12,
				new Node(15, new Node(20, new Node(1, new Node(3, new Node(4, new Node(7)))))))))));

		a.printList();
		Node reversed = reverseKElements(a, 3);
		reversed.printList();
	}

	// a b c d e f
	private static Node reverseKElements(Node node, int k) {

		if (node == null)
			return null;

		Node thisNode = node;
		Node prev = null;
		int count = 1;
		while (thisNode != null && count <= k) {
			prev = thisNode;
			thisNode = thisNode.next;
			count++;
		}

		Node segHead = reverseKElements(thisNode, k);

		prev = node;
		thisNode = node.next;
		count = 1;
		while (thisNode != null && count < k) {
			Node next = thisNode.next;
			thisNode.next = prev;

			prev = thisNode;
			thisNode = next;
			count++;
		}

		node.next = segHead;

		return prev;
	}
}
