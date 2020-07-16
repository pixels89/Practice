package in.barmans.slidingw;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		int[] in = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
		int[] out = maxSlidingWindow(in, 4);
		for (int i : out) {
			System.out.println(in[i]);
		}

	}

	private static int[] maxSlidingWindow(int[] in, int k) {
		if (in == null)
			return null;
		if (in.length < k)
			return null;

		Deque<Integer> q = new LinkedList<Integer>();
		int[] result = new int[in.length + 1 - k];
		for (int i = 0; i < in.length; i++) {
			if (q.peekFirst() != null && q.peekFirst() < i + 1 - k) {
				q.removeFirst();
			}
			if (q.peekLast() == null) {
				q.offerLast(i);
			} else {
				while (q.peekLast() != null && in[q.peekLast()] <= in[i]) {
					q.pollLast();
				}
				q.offerLast(i);
			}

			if (i + 1 >= k) {
				result[i + 1 - k] = q.peekFirst();
			}
		}
		return result;
	}

}
