package in.barmans.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class TaskSchedulingOrder {

	static Map<Integer, Node> nodes = new HashMap<Integer, Node>();
	static Map<Node, List<Node>> adjencyList = new HashMap<Node, List<Node>>();
	static Deque<Integer> stack = new LinkedList<Integer>();

	public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
		for (int[] preReq : prerequisites) {
			graphEdge(preReq[0], preReq[1]);
		}
		return sortGraph();
	}

	private static List<Integer> sortGraph() {

		for (Entry<Node, List<Node>> node : adjencyList.entrySet()) {
			visitNode(node.getKey());
		}

		return new ArrayList<Integer>(stack);
	}

	private static void visitNode(Node node) {
		System.out.printf("visitNode %d \n", node.data);
		if (node.visited)
			return;
		List<Node> nodes = getNonVisitedNeighbors(node);
		if (nodes != null) {
			
			for (Node thisNode : nodes) {
				if (thisNode.equals(node)) {
					throw new RuntimeException("cycle");
				}
				visitNode(thisNode);
			}
		}
		stack.push(node.data);
		node.visited = true;
	}

	private static List<Node> getNonVisitedNeighbors(Node node) {
		System.out.printf("getNonVisitedNeighbors %d \n", node.data);
		if (node != null) {
			List<Node> nodes = new ArrayList<Node>();
			if (adjencyList.get(node) == null)
				return null;
			for (Node nextNode : adjencyList.get(node)) {
				if (nextNode.equals(node)) {
					throw new RuntimeException("cycle");
				}
				if (!nextNode.visited) {
					nodes.add(nextNode);
				}
			}
			return nodes;
		}
		return null;
	}

	private static void graphEdge(int from, int to) {
		System.out.printf("graphEdge %d %d \n", from, to);

		Node nodeFrom = nodes.get(from);
		if (!nodes.containsKey(from)) {
			nodes.put(from, new Node(from));
			nodeFrom = nodes.get(from);
		}

		Node nodeTo = nodes.get(to);
		if (!nodes.containsKey(to)) {
			nodes.put(to, new Node(to));
			nodeTo = nodes.get(to);
		}

		List<Node> neighbors = adjencyList.get(nodeFrom);
		if (neighbors == null) {
			adjencyList.put(nodeFrom, new ArrayList<Node>());
			neighbors = adjencyList.get(nodeFrom);
		}

		neighbors.add(nodeTo);
	}

	public static void main(String[] args) {
		List<Integer> result = null;
//				TaskSchedulingOrder.findOrder(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
//		System.out.println(result);
////
//		result = TaskSchedulingOrder.findOrder(3,
//				new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
//		System.out.println(result);

		result = TaskSchedulingOrder.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
				new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println(result);
	}
}