package in.barmans.practice;

public class MergeLinkedList {
	public static void main(String[] args) {
		Node a = new Node(2, new Node(5, new Node(6, new Node(8, new Node(12, new Node(15, new Node(20)))))));
		Node b = new Node(1, new Node(3, new Node(4, new Node(7, new Node(13)))));

		

		Node head = mergeSort(a, b);

		
	}



	private static Node mergeSort(Node a, Node b) {
		Node head = null, last = null;
		while (a != null || b != null) {
			Node least;
			if (a == null) {
				least = b;
				b = b.next;
			} else if (b == null) {
				least = a;
				a = a.next;
			} else if (a.data < b.data) {
				least = a;
				a = a.next;
			} else {
				least = b;
				b = b.next;
			}

			if (head == null) {
				head = last = least;
			} else {
				last.next = least;
				last = last.next;
			}

		}

		return head;
	}
}
