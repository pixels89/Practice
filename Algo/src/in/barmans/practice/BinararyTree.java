package in.barmans.practice;

public class BinararyTree {
	private Node root;

	public BinararyTree(Node root) {
		this.root = root;
	}

	public void insert(int value) {

	}

	public Node getRoot() {
		return root;
	}

	public static void inorder(Node node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}

	public static void reverseInorder(Node node) {
		if (node != null) {
			reverseInorder(node.right);
			System.out.print(node.data + " ");
			reverseInorder(node.left);
		}
	}

	public static void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	public static void reversePreorder(Node node) {
		if (node != null) {
			reversePreorder(node.right);
			reversePreorder(node.left);
			System.out.print(node.data + " ");
		}
	}

	public static void postorder(Node node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
		}
	}

	public static void reversePostorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			reversePostorder(node.right);
			reversePostorder(node.left);
		}
	}

}
