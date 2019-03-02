package in.barmans.practice;

/**
 * Longest consecutive sequence in Binary tree Given a Binary Tree find the
 * length of the longest path which comprises of nodes with consecutive values
 * in increasing order. Every node is considered as a path of length 1.
 * 
 * @author mbarman
 *
 */
public class LongestConsequtiveBinaryTree {

	private static int max = 0;;

	static void findLongestConsecutiveInternal(Node node, int currentMax, int expected) {
		if (node != null) {
			if (node.data == expected) {
				currentMax++;
			} else {
				currentMax = 1;
			}

			if (currentMax > LongestConsequtiveBinaryTree.max) {
				LongestConsequtiveBinaryTree.max = currentMax;
			}
			findLongestConsecutiveInternal(node.left, currentMax, node.data + 1);

			findLongestConsecutiveInternal(node.right, currentMax, node.data + 1);
		}
	}

	static int findLongestConsecutive(Node node) {
		findLongestConsecutiveInternal(node, 0, -1);
		return LongestConsequtiveBinaryTree.max;
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		Node left = new Node(2);
		node.left = left;
		Node four = new Node(4);
		left.left = four;
		Node five = new Node(5);
		four.right = five;
		five.left = new Node(6);

		findLongestConsecutive(node);
		System.out.println(max);
		assert max == 1;
	}

}
