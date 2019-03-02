package in.barmans.practice;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewBinaryTree {
	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static class NodeWithIndex {
		Node node;
		int index;

		NodeWithIndex(Node node, int index) {
			this.index = index;
			this.node = node;
		}
	}

	static TreeMap<Integer, NodeWithIndex> map = new TreeMap<>();

	public static void topViewInternal(Node node, int hIndex, int depth) {

		if (node != null) {

			if (!map.containsKey(hIndex)) {
				map.put(hIndex, new NodeWithIndex(node, depth));
			} else {
				if (map.get(hIndex).index > depth) {
					map.put(hIndex, new NodeWithIndex(node, depth));
				}
			}

			topViewInternal(node.left, hIndex - 1, depth + 1);
			topViewInternal(node.right, hIndex + 1, depth + 1);

		}

	}

	private static void topView(Node node) {
		topViewInternal(node, 0, 0);
		Collection<NodeWithIndex> values = map.values();
		for (NodeWithIndex nodeDepth : values) {
			System.out.println(nodeDepth.node.data);
		}
	}

	private static void topViewLevelWiseInternal(Node node, int hIndex) {
		if (node != null) {
			Queue<NodeWithIndex> q = new LinkedList<>();
			q.add(new NodeWithIndex(node, hIndex));
			while (!q.isEmpty()) {
				NodeWithIndex qNode = q.remove();
				Node newNode = qNode.node;

				if (!map.containsKey(qNode.index)) {
					map.put(qNode.index, qNode);
				}

				if (newNode.left != null) {
					q.add(new NodeWithIndex(newNode.left, qNode.index - 1));
				}
				if (newNode.right != null) {
					q.add(new NodeWithIndex(newNode.right, qNode.index + 1));
				}
			}
		}
	}

	private static void topViewLevelWise(Node node) {
		topViewLevelWiseInternal(node, 0);
		Collection<NodeWithIndex> values = map.values();
		for (NodeWithIndex nodeDepth : values) {
			System.out.println(nodeDepth.node.data);
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		topViewLevelWise(root);
	}
}
