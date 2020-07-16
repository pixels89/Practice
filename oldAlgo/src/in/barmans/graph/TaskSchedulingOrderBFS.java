package in.barmans.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class TaskSchedulingOrderBFS {

	static Map<Integer, Node> nodes = new HashMap<Integer, Node>();
	static Map<Node, List<Node>> adjencyList = new HashMap<Node, List<Node>>();

	static Map<Node, Integer> inCount = new HashMap<Node, Integer>();
	static List<List<Node>> listOfSources = new LinkedList<List<Node>>();

	public static List<Integer> findOrder(int tasks, int[][] prerequisites) {
		for (int[] preReq : prerequisites) {
			graphEdge(preReq[0], preReq[1]);
		}
		return sortGraph();
	}

	private static List<Integer> sortGraph() {
		List<Node> sources = getSources();

		while (sources != null && sources.size() > 0) {
			listOfSources.add(sources);
			removeEdges(sources);
			sources = getSources();
		}

		List<Integer> sorted = new ArrayList<Integer>();
		for (List<Node> nodes : listOfSources) {
			for (Node node : nodes) {
				sorted.add(node.data);
			}
		}
		return sorted;
	}

	private static List<Node> getSources() {
		List<Node> sources = new ArrayList<Node>();
		for (Entry<Node, Integer> node : inCount.entrySet()) {
			if (node.getValue() == 0) {
				sources.add(node.getKey());
			}
		}
		return sources;
	}

	private static void removeEdges(List<Node> sources) {
		for (Node node : sources) {
			List<Node> neighbors = adjencyList.get(node);
			if (neighbors != null) {
				for (Node neighbor : neighbors) {
					inCount.put(neighbor, inCount.get(neighbor) - 1);
				}
			}
			inCount.remove(node);
		}

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
		inCount.put(nodeTo, inCount.getOrDefault(nodeTo, 0) + 1);
		inCount.put(nodeFrom, inCount.getOrDefault(nodeFrom, 0));

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

		result = TaskSchedulingOrderBFS.findOrder(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
				new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
		System.out.println(result);
	}
}