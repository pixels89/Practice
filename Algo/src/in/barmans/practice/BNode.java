package in.barmans.practice;

public class BNode {
	public BNode(int i) {
		data = i;
	}

	public BNode(int i, BNode bNode, BNode bNode2) {
		data = i;
		left = bNode;
		right = bNode2;
	}

	int data;
	BNode left;
	BNode right;

	public static void print(BNode node) {
		if (node != null) {
			print(node.left);
			System.out.print(node.data + " ");
			print(node.right);
		}
	}
	public static void printPost(BNode node) {
		if (node != null) {
			print(node.left);
			print(node.right);
			System.out.print(node.data + " ");
		}
	}
}
