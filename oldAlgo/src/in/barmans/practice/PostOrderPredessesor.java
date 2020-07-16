package in.barmans.practice;

/**
 * Given a binary tree and a node in the binary tree, find Post order successor
 * of the given node.
 * 
 * @author mbarman
 *
 */
public class PostOrderPredessesor extends BinaryTree {

	public PostOrderPredessesor(Node root) {
		super(root);
	}

	private static int postPre(Node node, int previous, int value) {

		// Base case
		if (node == null) {
			return -1;
		}

		// call Left passing previous as current pre
		int left = postPre(node.left, previous, value);
		if (left != -1) {
			return left;
		}
		if (node.left != null) {
			previous = node.left.data;
		}

		// call right passing previous as left value is available
		int right = postPre(node.right, previous, value);
		if (right != -1) {
			return right;
		}

		// Postorder call
		if (node.data == value) {
			return previous;
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

		inorder(root);
		System.out.println();
		reverseInorder(root);
		System.out.println();
		preorder(root);
		System.out.println();
		reversePreorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
		reversePostorder(root);
		System.out.println();

		System.out.println(postPre(root, -1, 24));

	}

	// This code is contributed
	// by MukeshBarman
}
