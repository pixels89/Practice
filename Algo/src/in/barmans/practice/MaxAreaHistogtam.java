package in.barmans.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaHistogtam {
	private void maxArea(int[] histogram) {

		int area = 0;
		int currArea = 0;
		Deque<Integer> indexStack = new ArrayDeque<Integer>();
		for (int i = 0; i < histogram.length; i++) {
			if (indexStack.isEmpty() || histogram[indexStack.peek()] < histogram[i]) {
				currArea = histogram[i] * 1;
				area = Math.max(currArea, area);
				indexStack.push(i);
			} else if (histogram[indexStack.peek()] == histogram[i]) {
				currArea = histogram[i] * ((i - indexStack.peek()) + 1);
				area = Math.max(currArea, area);
			} else if (histogram[indexStack.peek()] > histogram[i]) {
				while (indexStack.peek() > histogram[i]) {
					Integer poppedIndex = indexStack.pop();
					currArea = histogram[i] * ((i - poppedIndex) + 1);
					area = Math.max(currArea, area);
				}
			}

		}
		while (!indexStack.isEmpty()) {
			Integer poppedIndex = indexStack.pop();
			int width = indexStack.isEmpty() ? histogram.length : histogram.length - 1 - indexStack.peek();
			currArea = histogram[poppedIndex] * width;
			area = Math.max(currArea, area);
		}

	}

}
