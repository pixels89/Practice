package in.barmans.practice;

/**
 * Given a binary tree and a node in the binary tree, find Postorder successor
 * of the given node.
 * 
 * Observation: instead finding the successor we could find the predesessor of
 * reverse postorder.
 * 
 * reverse of post order is
 * 
 * 1. visit node 2. visit right 3. visit left
 * 
 * @author mbarman
 *
 */
public class PostOrderSuccessor {

	private static int prevRevPost(Node node, int previous, int value) {
		if (node != null) {
			// check if node matches
			if (node.data == value) {
				return previous;
			}

			// check right with previous as parent node
			previous = node.data;
			int right = prevRevPost(node.right, previous, value);
			if (right != -1)
				return right;

			// check left with previous as right node if available
			if (node.right != null) {
				previous = node.right.data;
			}
			int left = prevRevPost(node.left, previous, value);
			if (left != -1) {
				return left;
			}

		}
		return -1;
	}

	public static void main(String[] args) {

		Node root = new Node(20);
		Node _10 = new Node(10);
		root.left = _10;
		_10.left = new Node(4);
		Node _18 = new Node(18);
		_10.right = _18;
		Node _14 = new Node(14);
		_18.left = _14;
		_18.right = new Node(19);
		_14.left = new Node(13);
		_14.right = new Node(15);

		Node _26 = new Node(26);
		root.right = _26;
		_26.left = new Node(24);
		_26.right = new Node(27);

		System.out.println(prevRevPost(root, -1, 24));

	}

	// This code is contributed
	// by MukeshBarman
}
