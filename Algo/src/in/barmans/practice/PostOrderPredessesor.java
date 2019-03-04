package in.barmans.practice;

/**
 * Given a binary tree and a node in the binary tree, find Postorder predecessor
 * of the given node.
 * 
 * @author mbarman
 *
 */
public class PostOrderPredessesor {

	private static int postPre(Node node, int pre, int val) {
		if (node == null) {
			return -1;
		}

		int left = postPre(node.left, pre, val);
		if (left != -1) {
			return left;
		}
		if (node.left != null) {
			pre = node.left.data;
		}
		int right = postPre(node.right, pre, val);
		if (right != -1) {
			return right;
		}

		if (node.data == val) {
			return pre;
		} else
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

		System.out.println(postPre(root, -1, 24));

	}

	static class Node {
		Node left, right;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}
	
	// This code is contributed 
	// by MukeshBarman
}
